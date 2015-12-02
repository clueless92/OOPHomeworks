using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr03CompanyHierarchy.Enums;
using Pr03CompanyHierarchy.Interfaces;

namespace Pr03CompanyHierarchy.Classes
{
    class Developer : RegularEmployee, IDeveloper
    {
        private List<Project> projects;
        public Developer(string id, string firstName, string lastName, double salary, Department department,
            List<Project> projects) : base(id, firstName, lastName, salary, department)
        {
            this.Projects = projects;
        }

        public List<Project> Projects
        {
            get { return projects; }
            set { projects = value; }
        }
    }
}
