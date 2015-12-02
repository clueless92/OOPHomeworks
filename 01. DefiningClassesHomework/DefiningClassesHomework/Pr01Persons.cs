using System;
using System.Linq;

namespace DefiningClassesHomework
{
    class Person
    {
        private string name;
        private int age;
        private string email;
        public Person(string name, int age)
        {
            setName(name);
            setAge(age);
        }
        public Person(string name, int age, string email) : this(name, age)
        {
            setEmail(email);
        }

        public void setName(string name)
        {
            if (name == "")
            {
                throw new ArgumentException("Name cannot be empty");
            }
            this.name = name;
        }

        public string getName()
        {
            return name;
        }

        public void setAge(int age)
        {
            if (age < 1 || age > 100)
            {
                throw new ArgumentException("Age cannot be less than 1 or more than 100");
            }
            this.age = age;
        }

        public int getAge()
        {
            return age;
        }

        public void setEmail(string email)
        {
            if (email != null && !email.Contains('@'))
            {
                throw new ArgumentException("Email cannot be empty and must contain '@'");
            }
            this.email = email;
        }

        public string getEmail()
        {
            return email;
        }

        public override string ToString() {
            string toPrint = String.Format("{0} is {1} years old. Email is: {2}", getName(), getAge(), getEmail());
            return toPrint;
        }
    }
    class Pr01Persons
    {
        static void Main(string[] args)
        {
            Person ivan = new Person("Ivan", 25);
            Person pesho = new Person("Pesho", 24, "pesho@pmail.com");
            //Person nameless = new Person("", 56);
            //Person unborn = new Person("Kiro", -2);
            //Person babaPenka = new Person("Penka", 27, "invalidMail#abv.bg");
            Console.WriteLine(ivan.ToString());
            Console.WriteLine(pesho.ToString());
        }
    }
}
