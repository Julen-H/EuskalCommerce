using Control_Panel.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Control_Panel
{
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void Form3_Load(object sender, EventArgs e)
        {
            using (var db = new odoodb())
            {
                var result = db.hr_employee
                    .Join(db.sale_order_line,
                     employee => employee.id,
                     order => order.salesman_id,
                     (user, order) => new {User = user,Order = order.price_total  }
                          )
                    .GroupBy(joinResult => joinResult.User.id)
                    .Select(groupedResult => new
                    {
                        EmployeeName = groupedResult.FirstOrDefault().User.name,
                        TotalAmount = groupedResult.Sum(grouped => grouped.Order)
                    })
                    .Take(5)
                    .OrderBy(r => r.TotalAmount)
                    .ToList();

                var controls = chart2.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>().FirstOrDefault();

                if (controls != null)
                {
                    controls.Series.Clear();
                    controls.Series.Add("Employees");
                    controls.Series["Employees"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Bar;
                    controls.Series["Employees"].Color = System.Drawing.Color.Blue;

                    foreach (var r in result)
                    {
                        controls.Series["Employees"].Points.AddXY(r.EmployeeName, r.TotalAmount);
                    }
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        private void langileakToolStripMenuItem_Click(object sender, EventArgs e)
        {


        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void itemsToolStripMenuItem_Click(object sender, EventArgs e)
        {


        }

        private void sellersToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form3 form3 = new Form3();
            form3.Show();
            this.Close();

        }

        private void chart2_Load(object sender, EventArgs e)
        {

        }

        private void dailyToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            OpenFormWith("daily");
        }

        private void monthlyToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            OpenFormWith("monthly");
        }

        private void yearlyToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            OpenFormWith("yearly");
        }

        private void OpenFormWith(string date)
        {
            Form2 form2 = new Form2(date);
            form2.chosenDate = date;
            form2.Show();
            this.Close();
        }
        private void inStockToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            OpenFormWith("InStock");

        }

        private void EmployeesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form1 to = new Form1();
            this.Close();
            to.Show();
        }

        private void sellersToolStripMenuItem_Click_1(object sender, EventArgs e)
        {

        }

        private void itemsToolStripMenuItem_Click_1(object sender, EventArgs e)
        {

        }

        private void dailyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWith("daily");
        }

        private void yearlyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWith("yearly");
        }

        private void inStockToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWith("InStock");
        }

        private void chart2_Load_1(object sender, EventArgs e)
        {

        }
    }
}
