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
    [Table("product_template")]
    public class Products
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public float list_price { get; set; }
        public bool purchase_ok { get; set; }

    }
}
