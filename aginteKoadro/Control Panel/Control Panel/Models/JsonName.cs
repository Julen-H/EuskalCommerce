using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Control_Panel.Models
{
    public class Lang
    {
        /*
         * Names are saved as a multilingual JSON object, gets the name in a certain lang.
         */
        public static string GetProductName(string nameDataString, string lang)
        {
            JObject jsonObject = JObject.Parse(nameDataString);

            if (jsonObject.TryGetValue(lang, out JToken value))
            {
                return value.ToString();
            }
            else
            {
                // Handle the case where the specified language is not found in the JSON object.
                return string.Empty; // You can change this to throw an exception or handle it differently.
            }
        }
    }
}