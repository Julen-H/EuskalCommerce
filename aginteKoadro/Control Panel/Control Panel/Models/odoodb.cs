using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace Control_Panel.Models
{
    public class odoodb : DbContext
    {
        public odoodb() : base(nameOrConnectionString: "odoodb")
        { } 
        public DbSet<Employee> hr_employee { get; set; }
        public DbSet<Purchases> purchase_order { get; set; }
        public DbSet<Department> hr_department { get; set; }
        public DbSet<Clients> res_partner { get; set; }
        public DbSet<Users> res_users { get; set; }
        public DbSet<Products> product_template { get; set; }
        public DbSet<Stock> stock_quant { get; set; }
        public DbSet<Sales> sale_order { get; set; }
        public DbSet<Sale_order_line> sale_order_line { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.HasDefaultSchema("public");
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();

        }
    }
}
