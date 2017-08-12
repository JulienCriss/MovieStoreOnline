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
    public partial class FormMainPanel : Form
    {
        public FormMainPanel()
        {
            InitializeComponent();
        }

        private void buttonExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void FormMainPanel_Load(object sender, EventArgs e)
        {
            showMovies();
        }
        private void showMovies()
        {
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create("http://" + Form1.IP + "/ProiectInchirieriFilme/DataMovies");
            request.CookieContainer = Form1.cookies;

            request.Method = "GET";
            request.ContentType = "application/x-www-form-urlencoded";

            var response = (HttpWebResponse)request.GetResponse();
            String responseString = new StreamReader(response.GetResponseStream()).ReadToEnd();
            string[] sep = { "<end>" };
            string[] lines = responseString.Split(sep, System.StringSplitOptions.RemoveEmptyEntries);
            string[] separatingChars = {"<<"};
            string[] columns = { "", "", "", "", "", "", ""};
            foreach (string s in lines)
            {
                if (s.Length > 2)
                {
                    try
                    {
                        if (s.Length > 1)
                        {
                            columns = s.Split(separatingChars, System.StringSplitOptions.RemoveEmptyEntries);
                            dataGrid.Rows.Add(columns);
                        }
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine(ex.Message);
                    }
                }
            }
        }

        private void buttonRemove_Click(object sender, EventArgs e)
        {
            DataGridViewRow row = dataGrid.SelectedRows[0];
            int id_film = Convert.ToInt32(row.Cells[0].Value.ToString());
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create("http://" + Form1.IP + "/ProiectInchirieriFilme/DeleteMovie");
            request.CookieContainer = Form1.cookies;
            var postData = "id_film=" + id_film.ToString();
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
                MessageBox.Show("Stergere cu succes!");
            }
            else
            {
                MessageBox.Show("Stergere esuata!");
            }
            dataGrid.Rows.Clear();
            showMovies();   
        }

        private void buttonAdd_Click(object sender, EventArgs e)
        {
            this.Hide();
            FormAddMovie formAddMovie = new FormAddMovie();
            formAddMovie.ShowDialog(this);
            this.Show();
            dataGrid.Rows.Clear();
            showMovies();
        }
    }
}
