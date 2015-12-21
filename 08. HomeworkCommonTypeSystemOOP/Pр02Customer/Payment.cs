using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr02Customer
{
    class Payment
    {
        private string productName;
        private decimal price;

        public Payment(string productName, decimal price)
        {
            this.Price = price;
            this.ProductName = productName;
        }

        public string ProductName
        {
            get { return this.productName; }
            set { this.productName = value; }
        }

        public decimal Price
        {
            get { return this.price; }
            set { this.price = value; }
        }
    }
}
