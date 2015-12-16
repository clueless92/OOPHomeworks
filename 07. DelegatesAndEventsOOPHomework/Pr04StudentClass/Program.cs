using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr04StudentClass
{
    class Program
    {
        static void Main(string[] args)
        {
            Student student = new Student("Kiro", 25);
            student.Name = "Prokopi";
            student.Age = 30;
        }
    }
}
