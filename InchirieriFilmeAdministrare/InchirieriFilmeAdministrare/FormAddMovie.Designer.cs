namespace InchirieriFilmeAdministrare
{
    partial class FormAddMovie
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.textBoxNumeFilm = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.comboBoxTipFilm = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.textBoxPret = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.textBoxTrailer = new System.Windows.Forms.TextBox();
            this.richTextBoxDescriere = new System.Windows.Forms.RichTextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.buttonAddMovie = new System.Windows.Forms.Button();
            this.imgURL = new System.Windows.Forms.Label();
            this.textBoxURLimg = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // textBoxNumeFilm
            // 
            this.textBoxNumeFilm.Location = new System.Drawing.Point(133, 13);
            this.textBoxNumeFilm.Name = "textBoxNumeFilm";
            this.textBoxNumeFilm.Size = new System.Drawing.Size(246, 22);
            this.textBoxNumeFilm.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Location = new System.Drawing.Point(25, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(78, 17);
            this.label1.TabIndex = 2;
            this.label1.Text = "Nume Film:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.Color.Transparent;
            this.label2.Location = new System.Drawing.Point(25, 57);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(61, 17);
            this.label2.TabIndex = 4;
            this.label2.Text = "Tip Film:";
            // 
            // comboBoxTipFilm
            // 
            this.comboBoxTipFilm.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboBoxTipFilm.FormattingEnabled = true;
            this.comboBoxTipFilm.Items.AddRange(new object[] {
            "actiune",
            "comedie",
            "drama",
            "horror",
            "sf",
            "animatie"});
            this.comboBoxTipFilm.Location = new System.Drawing.Point(133, 54);
            this.comboBoxTipFilm.Name = "comboBoxTipFilm";
            this.comboBoxTipFilm.Size = new System.Drawing.Size(246, 24);
            this.comboBoxTipFilm.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.Color.Transparent;
            this.label3.Location = new System.Drawing.Point(25, 101);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(38, 17);
            this.label3.TabIndex = 6;
            this.label3.Text = "Pret:";
            // 
            // textBoxPret
            // 
            this.textBoxPret.Location = new System.Drawing.Point(133, 98);
            this.textBoxPret.Name = "textBoxPret";
            this.textBoxPret.Size = new System.Drawing.Size(246, 22);
            this.textBoxPret.TabIndex = 7;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.BackColor = System.Drawing.Color.Transparent;
            this.label4.Location = new System.Drawing.Point(25, 146);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(53, 17);
            this.label4.TabIndex = 8;
            this.label4.Text = "Trailer:";
            // 
            // textBoxTrailer
            // 
            this.textBoxTrailer.Location = new System.Drawing.Point(133, 142);
            this.textBoxTrailer.Name = "textBoxTrailer";
            this.textBoxTrailer.Size = new System.Drawing.Size(246, 22);
            this.textBoxTrailer.TabIndex = 9;
            // 
            // richTextBoxDescriere
            // 
            this.richTextBoxDescriere.Location = new System.Drawing.Point(485, 13);
            this.richTextBoxDescriere.Name = "richTextBoxDescriere";
            this.richTextBoxDescriere.Size = new System.Drawing.Size(599, 200);
            this.richTextBoxDescriere.TabIndex = 10;
            this.richTextBoxDescriere.Text = "";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.BackColor = System.Drawing.Color.Transparent;
            this.label6.Location = new System.Drawing.Point(405, 13);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(73, 17);
            this.label6.TabIndex = 12;
            this.label6.Text = "Descriere:";
            // 
            // buttonAddMovie
            // 
            this.buttonAddMovie.Location = new System.Drawing.Point(485, 285);
            this.buttonAddMovie.Name = "buttonAddMovie";
            this.buttonAddMovie.Size = new System.Drawing.Size(157, 41);
            this.buttonAddMovie.TabIndex = 13;
            this.buttonAddMovie.Text = "Adaugare Film";
            this.buttonAddMovie.UseVisualStyleBackColor = true;
            this.buttonAddMovie.Click += new System.EventHandler(this.buttonAddMovie_Click);
            // 
            // imgURL
            // 
            this.imgURL.AutoSize = true;
            this.imgURL.BackColor = System.Drawing.Color.Transparent;
            this.imgURL.Location = new System.Drawing.Point(25, 187);
            this.imgURL.Name = "imgURL";
            this.imgURL.Size = new System.Drawing.Size(97, 17);
            this.imgURL.TabIndex = 14;
            this.imgURL.Text = "URL imagine: ";
            // 
            // textBoxURLimg
            // 
            this.textBoxURLimg.Location = new System.Drawing.Point(133, 184);
            this.textBoxURLimg.Name = "textBoxURLimg";
            this.textBoxURLimg.Size = new System.Drawing.Size(246, 22);
            this.textBoxURLimg.TabIndex = 15;
            // 
            // FormAddMovie
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.WhiteSmoke;
            this.BackgroundImage = global::InchirieriFilmeAdministrare.Properties.Resources.pixars_up_wide1;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(1096, 338);
            this.Controls.Add(this.textBoxURLimg);
            this.Controls.Add(this.imgURL);
            this.Controls.Add(this.buttonAddMovie);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.richTextBoxDescriere);
            this.Controls.Add(this.textBoxTrailer);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.textBoxPret);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.comboBoxTipFilm);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBoxNumeFilm);
            this.Name = "FormAddMovie";
            this.Text = "FormAddMovie";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBoxNumeFilm;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox comboBoxTipFilm;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox textBoxPret;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBoxTrailer;
        private System.Windows.Forms.RichTextBox richTextBoxDescriere;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button buttonAddMovie;
        private System.Windows.Forms.Label imgURL;
        private System.Windows.Forms.TextBox textBoxURLimg;
    }
}