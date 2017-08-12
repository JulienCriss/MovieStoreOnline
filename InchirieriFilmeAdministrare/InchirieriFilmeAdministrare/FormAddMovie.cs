using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Windows.Forms;

namespace InchirieriFilmeAdministrare
{
    public partial class FormAddMovie : Form
    {
        public FormAddMovie()
        {
            InitializeComponent();
        }
        private bool IsDigitsOnly(string str)
        {
            foreach (char c in str)
            {
                if (c < '0' || c > '9')
                    return false;
            }

            return true;
        }
        private void buttonAddMovie_Click(object sender, EventArgs e)
        {
            String nume = textBoxNumeFilm.Text;
            String tip = comboBoxTipFilm.Text;
            String pret = textBoxPret.Text;
            String trailer = textBoxTrailer.Text;
            String imageURL = textBoxURLimg.Text;
            String descriere = richTextBoxDescriere.Text;
            String imageExtension = "";
            Uri uri = new Uri(imageURL);
            bool isPretOk = IsDigitsOnly(pret);
            if (UrlExists(imageURL))
            {
                Console.WriteLine("ext: "+imageExtension);
                imageExtension = System.IO.Path.GetFileName(uri.LocalPath);
                imageExtension = imageExtension.Split('.')[1];
            }
            if (nume != "" && tip != "" && pret != "" && trailer != "" && imageURL != "" && descriere != "" && imageExtension != "" && isPretOk)
            {
                insertMovie(nume, tip, pret, trailer, imageURL,imageExtension, descriere);
                this.Close();
            }
            else
            {
                MessageBox.Show("Nu lasati campuri necompletate!");
            }

        }
        private void insertMovie(String nume, String tip, String pret, String trailer, String imageURL,String imageExtension, String descriere)
        {
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create("http://" + Form1.IP + "/ProiectInchirieriFilme/InsertMovie");
            request.CookieContainer = Form1.cookies;

            var postData = "nume="+nume;
            postData += "&tip="+tip;
            postData += "&pret="+pret;
            postData += "&trailer="+trailer;
            postData += "&descriere=" + descriere;
            postData += "&imageExtension=" + imageExtension;
            postData += "&imageURL=" + imageURL;

            var data = Encoding.ASCII.GetBytes(postData);
            
            request.Method = "POST";
            request.ContentType = "application/x-www-form-urlencoded";
            request.ContentLength = data.Length;

            using (var stream = request.GetRequestStream())
            {
                stream.Write(data, 0, data.Length);
            }

            var response = (HttpWebResponse)request.GetResponse();

            var responseString = new StreamReader(response.GetResponseStream()).ReadToEnd();
            if (responseString == "succes")
            {
                MessageBox.Show("Adaugare film cu succes!");
            }
            else
            {
                MessageBox.Show("Adaugare film esuata!");
            }
        }

        private static bool UrlExists(string url)
        {
            try
            {
                new System.Net.WebClient().DownloadData(url);
                return true;
            }
            catch (System.Net.WebException e)
            {
                if (((System.Net.HttpWebResponse)e.Response).StatusCode == System.Net.HttpStatusCode.NotFound)
                    return false;
                else
                    throw;
            }
        }
    }
}
