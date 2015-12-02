using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr03CompanyHierarchy.Interfaces;

namespace Pr03CompanyHierarchy.Classes
{
    class Sale : ISallable
    {
        private string productName;
        private DateTime date;
        private double price;

        public string ProductName
        {
            get { return productName; }
            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentNullException("Product name cannot be null or empty");
                }
                productName = value;
            }
        }

        public DateTime Date
        {
            get { return date; }
            set { date = value; }
        }

        public double Price
        {
            get { return price; }
            set
            {
                if (value < 0.0d)
                {
                    throw new ArgumentOutOfRangeException("Price cannot be negative");
                }
                price = value;
            }
        }
    }
}
