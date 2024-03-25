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
    [Table("hr_department")]
    public class Department
    {

        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public string description { get; set; }


    }
}
