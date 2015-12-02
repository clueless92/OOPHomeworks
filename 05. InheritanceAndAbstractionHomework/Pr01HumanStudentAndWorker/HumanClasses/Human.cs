using System;

namespace Pr01HumanStudentAndWorker.HumanClasses
{
    abstract class Human
    {
        private string firstName;
        private string lastName;

        public Human(string firstName, string lastName)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
        }

        public string FirstName
        {
            get { return firstName; }
            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentException("First name must not be null or empty.");
                }
                firstName = value;
            }
        }

        public string LastName
        {
            get { return lastName; }
            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentException("Last name must not be null or empty.");
                }
                lastName = value;
            }
        }

        public override string ToString()
        {
            string info = string.Format("{0} {1}", FirstName, LastName);
            return info;
        }
    }
}
