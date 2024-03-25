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
    [Table("purchase_order")]
    public class Purchases
    {
        [Key]

        public int id { get; set; }
        public float amount_total { get; set; }
    }
}
