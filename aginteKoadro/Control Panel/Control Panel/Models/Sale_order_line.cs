using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Control_Panel.Models
{
    [Table("sale_order_line")]
    public class Sale_order_line
    {
        [Key]

        public int id { get; set; }
        public int order_id { get; set; }
        public int product_id { get; set; }
        public float qty_delivered { get; set; }
        public int salesman_id {  get; set; }
        public float price_total { get; set; }
    }
}