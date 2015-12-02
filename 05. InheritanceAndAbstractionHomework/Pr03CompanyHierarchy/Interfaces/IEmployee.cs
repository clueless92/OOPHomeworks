using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr03CompanyHierarchy.Enums;

namespace Pr03CompanyHierarchy.Interfaces
{
    interface IEmployee
    {
        double Salary { get; set; }
        Department Department { get; set; }
    }
}
