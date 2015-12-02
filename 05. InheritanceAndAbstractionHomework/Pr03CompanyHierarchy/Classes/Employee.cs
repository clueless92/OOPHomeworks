using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr03CompanyHierarchy.Enums;
using Pr03CompanyHierarchy.Interfaces;

namespace Pr03CompanyHierarchy.Classes
{
    abstract class Employee : Person, IEmployee
    {
        private double salary;
        private Department department;
        public Employee(string id, string firstName, string lastName, double salary, Department department)
            : base(id, firstName, lastName)
        {
            this.Salary = salary;
            this.Department = department;
        }

        public double Salary
        {
            get { return salary; }
            set
            {
                if (value < 0.0d)
                {
                    throw new ArgumentOutOfRangeException("Salary cannot be negative");
                }
                this.salary = value;
            }
        }
        public Department Department { get; set; }

        public override string ToString()
        {
            string info = string.Format("Department: {0}, Salary: {1}", Department, Salary);
            return base.ToString() + Environment.NewLine + info;
        }
    }
}
