using System;

namespace Pr02Animals.AnimalClasses
{
    abstract class Animal
    {
        private string name;
        private int age;
        private Gender gender;

        public Animal(string name, int age, Gender gender)
        {
            this.Name = name;
            this.Age = age;
            this.Gender = gender;
        }

        public string Name
        {
            get { return name; }
            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentException("Name cannot be null or empty");
                }
                name = value;
            }
        }

        public int Age
        {
            get { return age; }
            set
            {
                if (age < 0)
                {
                    throw new ArgumentOutOfRangeException("Age cannot be nagative");
                }
                age = value;
            }
        }

        public Gender Gender
        {
            get { return gender; }
            set
            {
                gender = value;
            }
        }
    }
}
