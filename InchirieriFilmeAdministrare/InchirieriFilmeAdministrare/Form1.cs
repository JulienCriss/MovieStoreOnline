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
    public partial class Form1 : Form
    {
        public static CookieContainer cookies = new CookieContainer();
        public static String IP;
        public int login(String utilizator, String parola)
        {
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create("http://" + IP + "/ProiectInchirieriFilme/LoginAdmin");
            request.CookieContainer = cookies;
            var postData = "user=" + utilizator;
            postData += "&password=" + parola;
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
            Console.WriteLine(responseString);
            if (responseString == "login-ok")
            {
                return 1;
            }
            return 0;
        }
        public Form1()
        {
            InitializeComponent();
        }

        private void buttonLogare_Click(object sender, EventArgs e)
        {
            String user = textBoxUser.Text;
            String password = textBoxPassword.Text;
            IP = textBoxIP.Text;
            if (login(user, password) == 1)
            {
                FormMainPanel formMainPanel = new FormMainPanel();
                this.Hide();
                formMainPanel.ShowDialog(this);
                this.Show();
                textBoxUser.Clear();
                textBoxPassword.Clear();
            }
            else
            {
                MessageBox.Show("Nume utilizator sau parola incorecta!");
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
