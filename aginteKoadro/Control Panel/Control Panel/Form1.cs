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
    public partial class Form1 : Form
    {
        float totalCost = 0;
        float totalFacturation = 0;
      
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //Winnings
            using (var db = new odoodb())
            {
                var facturation = db.sale_order.Select(p => p.amount_total);

                foreach (var onlyFacturation in facturation)
                {
                    totalFacturation += float.Parse(onlyFacturation.ToString());
                }

                labelwinnings.Text = ((float)System.Math.Round(totalFacturation, 2)).ToString();
            }

            //Costs
            using (var db = new odoodb())
            {
                var costs = db.purchase_order.Select(p => p.amount_total);

                foreach (var onlyCost in costs)
                {
                    totalCost += float.Parse(onlyCost.ToString());
                }

                labelcosts.Text = ((float)System.Math.Round(totalCost, 2)).ToString();
            }
            using (var db = new odoodb())
            {
                var employeeData = db.hr_employee
                    .Join(db.hr_department,
                        employee => employee.department_id,
                        department => department.id,
                        (employee, department) => new { Employee = employee, Department = department })
                    .GroupBy(joinResult => joinResult.Employee.department_id)
                    .Select(groupedResult => new
                    {
                        EmployeeCount = groupedResult.Count(),
                        EmployeeDepartment = groupedResult.Select(x => x.Department.name).FirstOrDefault()
                    });

                var controls = chart2.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>().FirstOrDefault();

                if (controls != null)
                    {
                    controls.Series.Clear();
                    controls.Series.Add("Employee");
                    

                    foreach (var r in employeeData)
                    {
                        controls.Series["Employee"].Points.AddXY(r.EmployeeDepartment, r.EmployeeCount);
                        controls.Series["Employee"].IsValueShownAsLabel = true;
                        controls.Series["Employee"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Doughnut;
                    }

                }

            }
            
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void chart2_Click(object sender, EventArgs e)
        {

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
            this.Hide();

        }

        private void chart2_Load(object sender, EventArgs e)
        {

        }

        private void dailyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWith("daily");
        }

        private void monthlyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWith("monthly");
        }

        private void yearlyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWith("yearly");
        }

        private void OpenFormWith(string date)
        {
            Form2 form2 = new Form2(date);
            form2.chosenDate = date;
            form2.Show();
            this.Hide();
        }
        private void inStockToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWith("InStock");
            
        }

        private void groupBox1_Enter_1(object sender, EventArgs e)
        {

        }

        private void labelcosts_Click(object sender, EventArgs e)
        {

        }
    }
}
