using System;
using System.Collections.Generic;
using Pr03CompanyHierarchy.Classes;
using Pr03CompanyHierarchy.Enums;

namespace Pr03CompanyHierarchy
{
    class Program
    {
        static void Main(string[] args)
        {
            SalesEmployee daniela = new SalesEmployee("A5", "Daniela", "Dankova", 500.54, Department.Sales, new List<Sale>());
            Developer pesho = new Developer("D0", "Pesho", "Peshov", 1199.99, Department.Production, new List<Project>());
            Manager anton = new Manager("M16", "Anton", "Antonov", 600.38, Department.Marketing, new List<Employee>());
            anton.Employees.Add(daniela);
            anton.Employees.Add(pesho);

            List<Employee> employeeList = new List<Employee>() { daniela, pesho, anton };
            foreach (Employee employee in employeeList)
            {
                Console.WriteLine(employee);
                Console.WriteLine();
            }
        }
    }
}
