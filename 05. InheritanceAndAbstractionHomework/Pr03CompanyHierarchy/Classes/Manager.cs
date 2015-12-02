using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr03CompanyHierarchy.Enums;
using Pr03CompanyHierarchy.Interfaces;

namespace Pr03CompanyHierarchy.Classes
{
    class Manager : Employee, IManager
    {
        private List<Employee> employees;
        public Manager(string id, string firstName, string lastName, double salary, Department department,
            List<Employee> employees) : base(id, firstName, lastName, salary, department)
        {
            this.Employees = employees;
        }

        public List<Employee> Employees
        {
            get { return employees; }
            set { employees = value; }
        }
    }
}
