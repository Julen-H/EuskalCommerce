using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Control_Panel.Models
{
    [Table("sale_order")]
    public class Sales
    {
        [Key]

        public int id { get; set; }
        public int partner_id { get; set; }
        public DateTime date_order { get; set; }
        public float amount_total { get; set; }
    }
}
