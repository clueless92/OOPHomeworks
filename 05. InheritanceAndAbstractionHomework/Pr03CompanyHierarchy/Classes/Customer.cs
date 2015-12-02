using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr03CompanyHierarchy.Interfaces;

namespace Pr03CompanyHierarchy.Classes
{
    class Customer : Person, ICustomer
    {
        private double netPurchaseAmount;

        public double NetPurchaseAmount
        {
            get { return netPurchaseAmount; }
            set { netPurchaseAmount = value; }
        }

        public Customer(string id, string firstName, string lastName, double netPurchaseAmount)
            : base(id, firstName, lastName)
        {
            this.NetPurchaseAmount = netPurchaseAmount;
        }
    }
}
