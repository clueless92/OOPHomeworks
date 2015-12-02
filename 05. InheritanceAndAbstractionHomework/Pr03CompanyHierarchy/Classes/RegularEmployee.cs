using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr03CompanyHierarchy.Enums;
using Pr03CompanyHierarchy.Interfaces;

namespace Pr03CompanyHierarchy.Classes
{
    abstract class RegularEmployee : Employee
    {
        public RegularEmployee(string id, string firstName, string lastName, double salary,
            Department department) : base(id, firstName, lastName, salary, department)
        {
        }
    }
}
