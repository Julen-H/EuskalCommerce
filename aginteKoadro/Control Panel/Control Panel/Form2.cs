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
    public partial class Form2 : Form
    {
        public string chosenDate { get; set; }
        public Form2(string intervalo)
        {
            InitializeComponent();
            chosenDate = intervalo;
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            DateTime todayDate = DateTime.Now;

            switch (chosenDate)
            {
                case ("daily"):
                    // Daily facturation

                    using (var db = new odoodb())
                    {
                        var result = db.sale_order
                            .Where(p => p.date_order.Month == todayDate.Month)
                            .GroupBy(p => p.date_order.Day)
                            .Select(groupedResult => new
                            {
                                Day = groupedResult.FirstOrDefault().date_order.Day,
                                TotalFacturation = groupedResult.Sum(grouped => grouped.amount_total)
                            })
                            .ToList();

                        var kontrolak = chart2.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>().FirstOrDefault();

                        kontrolak.ChartAreas[0].AxisX.Title = "Day";
                        kontrolak.ChartAreas[0].AxisY.Title = "Price in euros";

                        kontrolak.ChartAreas[0].AxisX.Minimum = 1;
                        kontrolak.ChartAreas[0].AxisX.Maximum = 31;

                        if (kontrolak != null)
                        {
                            kontrolak.Series.Clear();
                            kontrolak.Series.Add("Revenue");
                            kontrolak.Series["Revenue"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Area;
                            kontrolak.Series["Revenue"].Color = System.Drawing.Color.Blue;

                            foreach (var r in result)
                            {
                                kontrolak.Series["Revenue"].Points.AddXY(r.Day, r.TotalFacturation);
                            }
                        }
                    }

                    // Most sold items
                    using (var db = new odoodb())
                    {
                        var result = db.sale_order_line
                            .Join(db.sale_order,
                                order_line => order_line.order_id,
                                order => order.id,
                                (order_line, order) => new { Date = order.date_order, ProductId = order_line.product_id, Quantity = order_line.qty_delivered }
                            )
                            .Join(db.product_template,
                                joinedData => joinedData.ProductId,
                                product => product.id,
                                (joinedData, product) => new { joinedData.Date, joinedData.ProductId, Product = product.name, joinedData.Quantity }
                            )
                            .Where(p => p.Date.Month == todayDate.Month)
                            .GroupBy(p => p.ProductId)
                            .Select(groupedResult => new
                            {
                                groupedResult.FirstOrDefault().Product,
                                Quantity = groupedResult.Sum(grouped => grouped.Quantity)
                            })
                            .OrderByDescending(r => r.Quantity)
                            .Take(5)
                            .ToList();


                        List<Label> allLabels = new List<Label>();
                        allLabels.Add(ItemLabel1);
                        allLabels.Add(ItemLabel2);
                        allLabels.Add(ItemLabel3);
                        allLabels.Add(ItemLabel4);
                        allLabels.Add(ItemLabel5);

                        for (int i = 0; i < 5; i++)
                        {
                            try
                            {
                                allLabels[i].Text = (i + 1).ToString() + ". " + result[i].Product.ToString().Split(' ')[1].Split('"')[1];
                            }
                            catch
                            {
                                allLabels[i].Text = (i + 1).ToString() + ". No product";
                            }
                        }
                    }

                    break;

                case ("monthly"):
                    // Monthly factrations

                    using (var db = new odoodb())
                    {
                        var result = db.sale_order
                            .Where(p => p.date_order.Year == todayDate.Year)
                            .GroupBy(p => p.date_order)
                            .Select(groupedResult => new
                            {
                                Month = groupedResult.FirstOrDefault().date_order.Month,
                                TotalFacturation = groupedResult.Sum(grouped => grouped.amount_total)
                            })
                            .ToList();

                        var controls = chart2.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>().FirstOrDefault();

                        controls.ChartAreas[0].AxisX.Title = "Month";
                        controls.ChartAreas[0].AxisY.Title = "Facturation (€)";

                        controls.ChartAreas[0].AxisX.Minimum = 1;
                        controls.ChartAreas[0].AxisX.Maximum = 12;

                        if (controls != null)
                        {
                            controls.Series.Clear();
                            controls.Series.Add("Revenue");
                            controls.Series["Revenue"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Area;
                            controls.Series["Revenue"].Color = System.Drawing.Color.Purple;

                            foreach (var r in result)
                            {
                                controls.Series["Revenue"].Points.AddXY(r.Month, r.TotalFacturation);
                            }
                        }
                    }

                    // Most sold items
                    using (var db = new odoodb())
                    {
                        var result = db.sale_order_line
                            .Join(db.sale_order,
                                order_line => order_line.order_id,
                                order => order.id,
                                (order_line, order) => new { Date = order.date_order, ProductId = order_line.product_id, quantity = order_line.qty_delivered }
                            )
                            .Join(db.product_template,
                                joinedData => joinedData.ProductId,
                                product => product.id,
                                (joinedData, produktua) => new { joinedData.Date, joinedData.ProductId, Product = produktua.name, joinedData.quantity }
                            )
                            .Where(p => p.Date.Year == todayDate.Year)
                            .GroupBy(p => p.ProductId)
                            .Select(groupedResult => new
                            {
                                groupedResult.FirstOrDefault().Product,
                                quantity = groupedResult.Sum(grouped => grouped.quantity)
                            })
                            .OrderByDescending(r => r.quantity)
                            .Take(5)
                            .ToList();


                        List<Label> allLabels = new List<Label>();
                        allLabels.Add(ItemLabel1);
                        allLabels.Add(ItemLabel2);
                        allLabels.Add(ItemLabel3);
                        allLabels.Add(ItemLabel4);
                        allLabels.Add(ItemLabel5);

                        for (int i = 0; i < 5; i++)
                        {
                            try
                            {
                                allLabels[i].Text = (i + 1).ToString() + ". " + result[i].Product.ToString().Split(' ')[1].Split('"')[1];
                            }
                            catch
                            {
                                allLabels[i].Text = (i + 1).ToString() + ".no products";
                            }
                        }
                    }

                    break;

                case ("yearly"):

                    // Yearly facturation

                    using (var db = new odoodb())
                    {
                        var result = db.sale_order
                            .Where(p => p.date_order.Year <= todayDate.Year && p.date_order.Year > todayDate.Year - 5)
                            .GroupBy(p => p.date_order)
                            .Select(groupedResult => new
                            {
                                Year = groupedResult.FirstOrDefault().date_order.Year,
                                FakturazioTotala = groupedResult.Sum(grouped => grouped.amount_total)
                            })
                            .ToList();

                        var controls = chart2.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>().FirstOrDefault();

                        controls.ChartAreas[0].AxisX.Title = "Year";
                        controls.ChartAreas[0].AxisY.Title = "Facturation (€)";

                        controls.ChartAreas[0].AxisX.Minimum = todayDate.Year - 4;
                        controls.ChartAreas[0].AxisX.Maximum = todayDate.Year;

                        if (controls != null)
                        {
                            controls.Series.Clear();
                            controls.Series.Add("Revenue");
                            controls.Series["Revenue"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Area;
                            controls.Series["Revenue"].Color = System.Drawing.Color.Purple;

                            foreach (var r in result)
                            {
                                controls.Series["Revenue"].Points.AddXY(r.Year, r.FakturazioTotala);
                            }
                        }
                    }

                    // Most sold items
                    using (var db = new odoodb())
                    {
                        var result = db.sale_order_line
                            .Join(db.sale_order,
                                order_line => order_line.order_id,
                                order => order.id,
                                (order_line, order) => new { Date = order.date_order, ProductId = order_line.product_id, quantity = order_line.qty_delivered }
                            )
                            .Join(db.product_template,
                                joinedData => joinedData.ProductId,
                                product => product.id,
                                (joinedData, product) => new { joinedData.Date, joinedData.ProductId, Product = product.name, joinedData.quantity }
                            )
                            .Where(p => p.Date.Year <= todayDate.Year && p.Date.Year > todayDate.Year - 5)
                            .GroupBy(p => p.ProductId)
                            .Select(groupedResult => new
                            {
                                groupedResult.FirstOrDefault().Product,
                                quantity = groupedResult.Sum(grouped => grouped.quantity)
                            })
                            .OrderByDescending(r => r.quantity)
                            .Take(5)
                            .ToList();


                        List<Label> allLabels = new List<Label>();
                        allLabels.Add(ItemLabel1);
                        allLabels.Add(ItemLabel2);
                        allLabels.Add(ItemLabel3);
                        allLabels.Add(ItemLabel4);
                        allLabels.Add(ItemLabel5);

                        for (int i = 0; i < 5; i++)
                        {
                            try
                            {
                                allLabels[i].Text = (i + 1).ToString() + ". " + result[i].Product.ToString().Split(' ')[1].Split('"')[1];
                            }
                            catch
                            {
                                allLabels[i].Text = (i + 1).ToString() + ".No products";
                            }
                        }
                    }

                    break;

                case ("InStock"):
                    MostSoldItems.Hide();
                    using (var db = new odoodb())
                    {
                        var stockQuant = db.stock_quant
                            .Join(db.product_template,
                                stock => stock.product_id,
                                product => product.id,
                                (stock, product) => new { Stock = stock, Product = product })
                            .Where(p => p.Stock.inventory_date == new DateTime(2023,12,31))
                            .GroupBy(joinResult => joinResult.Stock.product_id)
                            .Select(groupedResult => new
                            {
                                ProductCount = groupedResult.Sum(stock => stock.Stock.quantity),
                                ProductName = groupedResult.Select(x => x.Product.name).FirstOrDefault()
                            })
                       .ToList();
                        var translatedStockQuant = stockQuant.Select(r => new
                        {
                            ProductCount = r.ProductCount,
                            ProductName = Lang.GetProductName(r.ProductName, "en_US")
                        });


                        var controls = chart2.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>().FirstOrDefault();

                        if (controls != null)
                        {

                            controls.Series.Clear();
                            controls.Series.Add("Stock");


                            foreach (var r in translatedStockQuant)
                            {
                                controls.Series["Stock"].Points.AddXY( r.ProductName, r.ProductCount);
                                controls.Series["Stock"].IsValueShownAsLabel = true;
                                controls.Series["Stock"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Doughnut;
                                
                            }

                        }
                    }
                    break;
            
            }
        
        
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

       
        private void chart2_Load(object sender, EventArgs e)
        {

        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void EmployeesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form1 to = new Form1();
            this.Close();
            to.Show();
        }

        private void itemsToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void sellersToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form3 to = new Form3();
            this.Close();
            to.Show();

        }

        private void dailyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWithDate("daily");
        }

        private void monthlyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWithDate("monthly");
        }

        private void yearlyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWithDate("yearly");
        }

        private void OpenFormWithDate(string date)
        {
            Form2 form2 = new Form2(date);
            form2.chosenDate = date;
            form2.Show();
            this.Hide();
        }
        private void inStockToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFormWithDate("InStock");
        }

        private void ItemLabel5_Click(object sender, EventArgs e)
        {

        }

        private void ItemLabel1_Click(object sender, EventArgs e)
        {

        }

        private void ItemLabel2_Click(object sender, EventArgs e)
        {

        }

        private void ItemLabel3_Click(object sender, EventArgs e)
        {

        }

        private void ItemLabel4_Click(object sender, EventArgs e)
        {

        }

        private void MostSoldItems_Enter(object sender, EventArgs e)
        {
            this.Hide();
        }
    }
}
