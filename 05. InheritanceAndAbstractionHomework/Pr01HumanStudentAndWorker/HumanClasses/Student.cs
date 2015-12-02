using System;

namespace Pr01HumanStudentAndWorker.HumanClasses
{
    class Student : Human
    {
        private string facultyNumber;
        public Student(string firstName, string lastName, string facultyNumber) : base(firstName, lastName)
        {
            this.FacultyNumber = facultyNumber;
        }

        public string FacultyNumber
        {
            get { return facultyNumber; }
            set
            {
                if (value.Length < 5 || value.Length > 10)
                {
                    throw new ArgumentOutOfRangeException("Faculty number must be 5 to 10 characters long.");
                }
                facultyNumber = value;
            }
        }

        public override string ToString()
        {
            string info = base.ToString() + string.Format(", FN: {0}", FacultyNumber);
            return info;
        }
    }
}
