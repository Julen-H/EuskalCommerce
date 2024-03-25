using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.Data.Entity;
using System.Security.Policy;
using System.ComponentModel.DataAnnotations.Schema;

namespace Control_Panel.Models
{
    [Table("stock_quant")]
    public class Stock
    {
        [Key]
        public int id { get; set; }
        public int product_id { get; set; }
        public DateTime inventory_date { get; set; }
        public float quantity { get; set; }
    }
}
