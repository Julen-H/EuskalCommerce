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
    [Table("res_partner")]
    public class Clients
    {
        [Key]
        public int Id { get; set; }
    }
}
