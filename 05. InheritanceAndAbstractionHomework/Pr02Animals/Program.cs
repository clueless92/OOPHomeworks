using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using Pr02Animals.AnimalClasses;
using Pr02Animals.AnimalClasses.CatClasses;

namespace Pr02Animals
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                List<Animal> animalList = new List<Animal>()
                {
                    new Cat("Myrshichka", 5, Gender.Male),
                    new Dog("Sharo", 6, Gender.Male),
                    new Frog("Kermit", 2, Gender.Male),
                    new Kitten("Maca", 11),
                    new Tomcat("Pencho", 10),
                    new Dog("Sharka", 4, Gender.Female),
                    new Frog("Neznam", 1, Gender.Female)
                };
                double avgAgeCats = animalList.Where(a => a is Cat).Average(a => a.Age);
                Console.WriteLine("Average age of cats is: {0:f2}", avgAgeCats);
                double avgAgeDogs = animalList.Where(a => a is Dog).Average(a => a.Age);
                Console.WriteLine("Average age of dogs is: {0:f2}", avgAgeDogs);
                double avgAgeFrogs = animalList.Where(a => a is Frog).Average(a => a.Age);
                Console.WriteLine("Average age of frogs is: {0:f2}", avgAgeFrogs);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
