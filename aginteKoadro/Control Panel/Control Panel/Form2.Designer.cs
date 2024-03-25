namespace Control_Panel
{
    partial class Form2
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form2));
            this.chart2 = new ChartEmployee.UserControl1();
            this.label1 = new System.Windows.Forms.Label();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.EmployeesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.itemsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.dailyToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.monthlyToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.yearlyToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.inStockToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.sellersToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.MostSoldItems = new System.Windows.Forms.GroupBox();
            this.ItemLabel2 = new System.Windows.Forms.Label();
            this.ItemLabel3 = new System.Windows.Forms.Label();
            this.ItemLabel4 = new System.Windows.Forms.Label();
            this.ItemLabel5 = new System.Windows.Forms.Label();
            this.ItemLabel1 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.menuStrip1.SuspendLayout();
            this.MostSoldItems.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // chart2
            // 
            this.chart2.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.chart2.Location = new System.Drawing.Point(12, 31);
            this.chart2.Name = "chart2";
            this.chart2.Size = new System.Drawing.Size(795, 483);
            this.chart2.TabIndex = 12;
            this.chart2.Load += new System.EventHandler(this.chart2_Load);
            // 
            // label1
            // 
            this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Arial Rounded MT Bold", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(888, 40);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(465, 43);
            this.label1.TabIndex = 9;
            this.label1.Text = "ITEMS CONTROL PANEL";
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.EmployeesToolStripMenuItem,
            this.itemsToolStripMenuItem,
            this.sellersToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(1353, 30);
            this.menuStrip1.TabIndex = 11;
            this.menuStrip1.Text = "menuStrip1";
            this.menuStrip1.ItemClicked += new System.Windows.Forms.ToolStripItemClickedEventHandler(this.menuStrip1_ItemClicked);
            // 
            // EmployeesToolStripMenuItem
            // 
            this.EmployeesToolStripMenuItem.Name = "EmployeesToolStripMenuItem";
            this.EmployeesToolStripMenuItem.Size = new System.Drawing.Size(95, 26);
            this.EmployeesToolStripMenuItem.Text = "Employees";
            this.EmployeesToolStripMenuItem.Click += new System.EventHandler(this.EmployeesToolStripMenuItem_Click);
            // 
            // itemsToolStripMenuItem
            // 
            this.itemsToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.dailyToolStripMenuItem,
            this.monthlyToolStripMenuItem,
            this.yearlyToolStripMenuItem,
            this.inStockToolStripMenuItem});
            this.itemsToolStripMenuItem.Name = "itemsToolStripMenuItem";
            this.itemsToolStripMenuItem.Size = new System.Drawing.Size(59, 26);
            this.itemsToolStripMenuItem.Text = "Items";
            this.itemsToolStripMenuItem.Click += new System.EventHandler(this.itemsToolStripMenuItem_Click);
            // 
            // dailyToolStripMenuItem
            // 
            this.dailyToolStripMenuItem.Name = "dailyToolStripMenuItem";
            this.dailyToolStripMenuItem.Size = new System.Drawing.Size(146, 26);
            this.dailyToolStripMenuItem.Text = "Daily";
            this.dailyToolStripMenuItem.Click += new System.EventHandler(this.dailyToolStripMenuItem_Click);
            // 
            // monthlyToolStripMenuItem
            // 
            this.monthlyToolStripMenuItem.Name = "monthlyToolStripMenuItem";
            this.monthlyToolStripMenuItem.Size = new System.Drawing.Size(146, 26);
            this.monthlyToolStripMenuItem.Text = "Monthly";
            this.monthlyToolStripMenuItem.Click += new System.EventHandler(this.monthlyToolStripMenuItem_Click);
            // 
            // yearlyToolStripMenuItem
            // 
            this.yearlyToolStripMenuItem.Name = "yearlyToolStripMenuItem";
            this.yearlyToolStripMenuItem.Size = new System.Drawing.Size(146, 26);
            this.yearlyToolStripMenuItem.Text = "Yearly";
            this.yearlyToolStripMenuItem.Click += new System.EventHandler(this.yearlyToolStripMenuItem_Click);
            // 
            // inStockToolStripMenuItem
            // 
            this.inStockToolStripMenuItem.Name = "inStockToolStripMenuItem";
            this.inStockToolStripMenuItem.Size = new System.Drawing.Size(146, 26);
            this.inStockToolStripMenuItem.Text = "In Stock";
            this.inStockToolStripMenuItem.Click += new System.EventHandler(this.inStockToolStripMenuItem_Click);
            // 
            // sellersToolStripMenuItem
            // 
            this.sellersToolStripMenuItem.Name = "sellersToolStripMenuItem";
            this.sellersToolStripMenuItem.Size = new System.Drawing.Size(127, 26);
            this.sellersToolStripMenuItem.Text = "Best Employees";
            this.sellersToolStripMenuItem.Click += new System.EventHandler(this.sellersToolStripMenuItem_Click);
            // 
            // MostSoldItems
            // 
            this.MostSoldItems.Controls.Add(this.ItemLabel2);
            this.MostSoldItems.Controls.Add(this.ItemLabel3);
            this.MostSoldItems.Controls.Add(this.ItemLabel4);
            this.MostSoldItems.Controls.Add(this.ItemLabel5);
            this.MostSoldItems.Controls.Add(this.ItemLabel1);
            this.MostSoldItems.Location = new System.Drawing.Point(850, 205);
            this.MostSoldItems.Name = "MostSoldItems";
            this.MostSoldItems.Size = new System.Drawing.Size(503, 346);
            this.MostSoldItems.TabIndex = 13;
            this.MostSoldItems.TabStop = false;
            this.MostSoldItems.Text = "Most Sold Items";
            this.MostSoldItems.Enter += new System.EventHandler(this.MostSoldItems_Enter);
            // 
            // ItemLabel2
            // 
            this.ItemLabel2.Font = new System.Drawing.Font("Microsoft Sans Serif", 28.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ItemLabel2.ForeColor = System.Drawing.Color.Blue;
            this.ItemLabel2.Location = new System.Drawing.Point(40, 81);
            this.ItemLabel2.Name = "ItemLabel2";
            this.ItemLabel2.Size = new System.Drawing.Size(337, 54);
            this.ItemLabel2.TabIndex = 8;
            this.ItemLabel2.Text = "1-XXXXXXXX";
            this.ItemLabel2.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.ItemLabel2.Click += new System.EventHandler(this.ItemLabel2_Click);
            // 
            // ItemLabel3
            // 
            this.ItemLabel3.Font = new System.Drawing.Font("Microsoft Sans Serif", 28.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ItemLabel3.ForeColor = System.Drawing.Color.Yellow;
            this.ItemLabel3.Location = new System.Drawing.Point(40, 135);
            this.ItemLabel3.Name = "ItemLabel3";
            this.ItemLabel3.Size = new System.Drawing.Size(337, 54);
            this.ItemLabel3.TabIndex = 7;
            this.ItemLabel3.Text = "1-XXXXXXXX";
            this.ItemLabel3.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.ItemLabel3.Click += new System.EventHandler(this.ItemLabel3_Click);
            // 
            // ItemLabel4
            // 
            this.ItemLabel4.Font = new System.Drawing.Font("Microsoft Sans Serif", 28.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ItemLabel4.ForeColor = System.Drawing.Color.Purple;
            this.ItemLabel4.Location = new System.Drawing.Point(40, 189);
            this.ItemLabel4.Name = "ItemLabel4";
            this.ItemLabel4.Size = new System.Drawing.Size(337, 54);
            this.ItemLabel4.TabIndex = 6;
            this.ItemLabel4.Text = "1-XXXXXXXX";
            this.ItemLabel4.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.ItemLabel4.Click += new System.EventHandler(this.ItemLabel4_Click);
            // 
            // ItemLabel5
            // 
            this.ItemLabel5.Font = new System.Drawing.Font("Microsoft Sans Serif", 28.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ItemLabel5.ForeColor = System.Drawing.Color.Red;
            this.ItemLabel5.Location = new System.Drawing.Point(40, 255);
            this.ItemLabel5.Name = "ItemLabel5";
            this.ItemLabel5.Size = new System.Drawing.Size(337, 54);
            this.ItemLabel5.TabIndex = 5;
            this.ItemLabel5.Text = "1-XXXXXXXX";
            this.ItemLabel5.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.ItemLabel5.Click += new System.EventHandler(this.ItemLabel5_Click);
            // 
            // ItemLabel1
            // 
            this.ItemLabel1.Font = new System.Drawing.Font("Microsoft Sans Serif", 28.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ItemLabel1.ForeColor = System.Drawing.Color.Lime;
            this.ItemLabel1.Location = new System.Drawing.Point(40, 27);
            this.ItemLabel1.Name = "ItemLabel1";
            this.ItemLabel1.Size = new System.Drawing.Size(337, 54);
            this.ItemLabel1.TabIndex = 4;
            this.ItemLabel1.Text = "1-XXXXXXXX";
            this.ItemLabel1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.ItemLabel1.Click += new System.EventHandler(this.ItemLabel1_Click);
            // 
            // button1
            // 
            this.button1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.button1.Image = global::Control_Panel.Properties.Resources._32205;
            this.button1.Location = new System.Drawing.Point(939, 75);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(135, 123);
            this.button1.TabIndex = 10;
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.pictureBox1.Image = global::Control_Panel.Properties.Resources.ethazi_logo;
            this.pictureBox1.Location = new System.Drawing.Point(1102, 75);
            this.pictureBox1.Margin = new System.Windows.Forms.Padding(4);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(169, 123);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 8;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1353, 553);
            this.Controls.Add(this.MostSoldItems);
            this.Controls.Add(this.chart2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.menuStrip1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form2";
            this.Text = "Form2";
            this.Load += new System.EventHandler(this.Form2_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.MostSoldItems.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private ChartEmployee.UserControl1 chart2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem EmployeesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem itemsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem sellersToolStripMenuItem;
        private System.Windows.Forms.GroupBox MostSoldItems;
        private System.Windows.Forms.ToolStripMenuItem dailyToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem monthlyToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem yearlyToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem inStockToolStripMenuItem;
        private System.Windows.Forms.Label ItemLabel1;
        private System.Windows.Forms.Label ItemLabel2;
        private System.Windows.Forms.Label ItemLabel3;
        private System.Windows.Forms.Label ItemLabel4;
        private System.Windows.Forms.Label ItemLabel5;
    }
}