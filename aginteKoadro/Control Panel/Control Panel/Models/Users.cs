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
    [Table("res_users")]
    public class Users
    {
        [Key]
        public string id { get; set; }
        public string name { get; set; }
        public string Taldea { get; set; }
        public virtual List<Employee> Bezeroa { get; set; }
        public string active { get; set; }
    }
}
