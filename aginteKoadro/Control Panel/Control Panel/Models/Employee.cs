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
    [Table("hr_employee")]
    public class Employee
    {
        [Key] 
        public int id { get; set; }
        public string name { get; set; }
        public int customer_rank {  get; set; }
        public int department_id { get; set; }
    }
}
