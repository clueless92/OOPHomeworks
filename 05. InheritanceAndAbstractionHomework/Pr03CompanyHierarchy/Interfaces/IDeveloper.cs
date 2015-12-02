using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr03CompanyHierarchy.Classes;

namespace Pr03CompanyHierarchy.Interfaces
{
    interface IDeveloper
    {
        List<Project> Projects { get; set; }
    }
}
