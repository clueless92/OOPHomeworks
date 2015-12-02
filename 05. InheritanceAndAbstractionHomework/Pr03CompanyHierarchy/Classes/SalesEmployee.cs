using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr03CompanyHierarchy.Enums;
using Pr03CompanyHierarchy.Interfaces;

namespace Pr03CompanyHierarchy.Classes
{
    class SalesEmployee : RegularEmployee, ISalesEmployee
    {
        private List<Sale> sales;

        public SalesEmployee(string id, string firstName, string lastName, double salary, Department department,
            List<Sale> sales) : base(id, firstName, lastName, salary, department)
        {
            this.Sales = sales;
        }

        public List<Sale> Sales
        {
            get { return sales; }
            set { sales = value; }
        }
    }
}
