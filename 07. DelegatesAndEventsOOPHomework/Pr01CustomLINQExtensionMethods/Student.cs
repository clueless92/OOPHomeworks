using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Pr01CustomLINQExtensionMethods
{
    public class Student
    {
        private string name;
        private double grade;

        public Student(string name, double grade)
        {
            this.Name = name;
            this.Grade = grade;
        }

        public string Name
        {
            get { return name; }
            set
            {
                if (string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentNullException("Name cannot be empty.");
                }
                name = value;
            }
        }

        public double Grade
        {
            get { return grade; }
            set
            {
                if (value < 0 || value > 10)
                {
                    throw new ArgumentOutOfRangeException("Grade must be a real number in range [0, 10].");
                }
                grade = value;
            }
        }
    }
}
