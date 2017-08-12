namespace InchirieriFilmeAdministrare
{
    partial class FormMainPanel
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
            this.dataGrid = new System.Windows.Forms.DataGridView();
            this.id_film = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nume_film = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.tip_film = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.pret_film = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.trailer_url = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.imagine = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.descriere = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.panel1 = new System.Windows.Forms.Panel();
            this.buttonAdd = new System.Windows.Forms.Button();
            this.buttonExit = new System.Windows.Forms.Button();
            this.buttonRemove = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGrid)).BeginInit();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // dataGrid
            // 
            this.dataGrid.AllowUserToAddRows = false;
            this.dataGrid.AllowUserToDeleteRows = false;
            this.dataGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGrid.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.id_film,
            this.nume_film,
            this.tip_film,
            this.pret_film,
            this.trailer_url,
            this.imagine,
            this.descriere});
            this.dataGrid.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGrid.Location = new System.Drawing.Point(0, 0);
            this.dataGrid.Margin = new System.Windows.Forms.Padding(2);
            this.dataGrid.MaximumSize = new System.Drawing.Size(1920, 1080);
            this.dataGrid.MinimumSize = new System.Drawing.Size(975, 405);
            this.dataGrid.MultiSelect = false;
            this.dataGrid.Name = "dataGrid";
            this.dataGrid.RowTemplate.Height = 24;
            this.dataGrid.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGrid.Size = new System.Drawing.Size(975, 424);
            this.dataGrid.TabIndex = 0;
            // 
            // id_film
            // 
            this.id_film.HeaderText = "ID";
            this.id_film.Name = "id_film";
            this.id_film.ReadOnly = true;
            this.id_film.Width = 40;
            // 
            // nume_film
            // 
            this.nume_film.HeaderText = "Film";
            this.nume_film.Name = "nume_film";
            this.nume_film.ReadOnly = true;
            this.nume_film.Width = 200;
            // 
            // tip_film
            // 
            this.tip_film.HeaderText = "Tip";
            this.tip_film.Name = "tip_film";
            this.tip_film.ReadOnly = true;
            this.tip_film.Width = 40;
            // 
            // pret_film
            // 
            this.pret_film.HeaderText = "Pret";
            this.pret_film.Name = "pret_film";
            this.pret_film.ReadOnly = true;
            this.pret_film.Width = 40;
            // 
            // trailer_url
            // 
            this.trailer_url.HeaderText = "Trailer";
            this.trailer_url.Name = "trailer_url";
            this.trailer_url.ReadOnly = true;
            // 
            // imagine
            // 
            this.imagine.HeaderText = "Imagine";
            this.imagine.Name = "imagine";
            this.imagine.ReadOnly = true;
            // 
            // descriere
            // 
            this.descriere.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.descriere.HeaderText = "Descriere";
            this.descriere.Name = "descriere";
            this.descriere.ReadOnly = true;
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.Transparent;
            this.panel1.BackgroundImage = global::InchirieriFilmeAdministrare.Properties.Resources.pixars_up_wide__1_;
            this.panel1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.panel1.Controls.Add(this.buttonAdd);
            this.panel1.Controls.Add(this.buttonExit);
            this.panel1.Controls.Add(this.buttonRemove);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Right;
            this.panel1.Location = new System.Drawing.Point(617, 0);
            this.panel1.Margin = new System.Windows.Forms.Padding(2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(148, 424);
            this.panel1.TabIndex = 4;
            // 
            // buttonAdd
            // 
            this.buttonAdd.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonAdd.Location = new System.Drawing.Point(20, 2);
            this.buttonAdd.Margin = new System.Windows.Forms.Padding(2);
            this.buttonAdd.Name = "buttonAdd";
            this.buttonAdd.Size = new System.Drawing.Size(110, 26);
            this.buttonAdd.TabIndex = 1;
            this.buttonAdd.Text = "Adauga Film";
            this.buttonAdd.UseVisualStyleBackColor = true;
            this.buttonAdd.Click += new System.EventHandler(this.buttonAdd_Click);
            // 
            // buttonExit
            // 
            this.buttonExit.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonExit.Location = new System.Drawing.Point(20, 396);
            this.buttonExit.Margin = new System.Windows.Forms.Padding(2);
            this.buttonExit.Name = "buttonExit";
            this.buttonExit.Size = new System.Drawing.Size(110, 26);
            this.buttonExit.TabIndex = 3;
            this.buttonExit.Text = "Iesire";
            this.buttonExit.UseVisualStyleBackColor = true;
            this.buttonExit.Click += new System.EventHandler(this.buttonExit_Click);
            // 
            // buttonRemove
            // 
            this.buttonRemove.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRemove.Location = new System.Drawing.Point(20, 42);
            this.buttonRemove.Margin = new System.Windows.Forms.Padding(2);
            this.buttonRemove.Name = "buttonRemove";
            this.buttonRemove.Size = new System.Drawing.Size(110, 26);
            this.buttonRemove.TabIndex = 2;
            this.buttonRemove.Text = "Sterge Film";
            this.buttonRemove.UseVisualStyleBackColor = true;
            this.buttonRemove.Click += new System.EventHandler(this.buttonRemove_Click);
            // 
            // FormMainPanel
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Maroon;
            this.ClientSize = new System.Drawing.Size(765, 424);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.dataGrid);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "FormMainPanel";
            this.Text = "FormMainPanel";
            this.Load += new System.EventHandler(this.FormMainPanel_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGrid)).EndInit();
            this.panel1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGrid;
        private System.Windows.Forms.Button buttonAdd;
        private System.Windows.Forms.Button buttonRemove;
        private System.Windows.Forms.Button buttonExit;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.DataGridViewTextBoxColumn id_film;
        private System.Windows.Forms.DataGridViewTextBoxColumn nume_film;
        private System.Windows.Forms.DataGridViewTextBoxColumn tip_film;
        private System.Windows.Forms.DataGridViewTextBoxColumn pret_film;
        private System.Windows.Forms.DataGridViewTextBoxColumn trailer_url;
        private System.Windows.Forms.DataGridViewTextBoxColumn imagine;
        private System.Windows.Forms.DataGridViewTextBoxColumn descriere;
    }
}