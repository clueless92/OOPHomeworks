using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr01HumanStudentAndWorker.HumanClasses;

namespace Pr01HumanStudentAndWorker
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                List<Student> studentList = new List<Student>()
                {
                    new Student("Anton", "Antonov", "B2222"),
                    new Student("Marin", "Marinov", "I9999"),
                    new Student("Kiro", "Kirov", "C3333"),
                    new Student("Vikodin", "Vikodinov", "E5555"),
                    new Student("Pesho", "Peshov", "G7777"),
                    new Student("Rado", "Radov", "D4444"),
                    new Student("Chuchulina", "Chuchulinova", "H8888"),
                    new Student("Spiridon", "Spiridonov", "J0000"),
                    new Student("Penka", "Penkova", "F6666"),
                    new Student("Ivan", "Ivanov", "A1111")
                };

                studentList = studentList.OrderBy(s => s.FacultyNumber).ToList();
                foreach (Student s in studentList)
                {
                    Console.WriteLine(s);
                }

                List<Worker> workerList = new List<Worker>()
                {
                    new Worker("Anton", "Antonov", 150.6, 8),
                    new Worker("Pesho", "Peshov", 180.0, 8),
                    new Worker("Kiro", "Kirov", 190.19, 8),
                    new Worker("Vikodin", "Vikodinov", 200.11, 12),
                    new Worker("Marin", "Marinov", 800.99, 8),
                    new Worker("Rado", "Radov", 50.50, 4),
                    new Worker("Chuchulina", "Chuchulinova", 90.9, 8),
                    new Worker("Spiridon", "Spiridonov", 500.42, 8),
                    new Worker("Penka", "Penkova", 300.30, 4),
                    new Worker("Ivan", "Ivanov", 1000.12, 16)
                };

                workerList = workerList.OrderByDescending(w => w.MoneyPerHour()).ToList();
                Console.WriteLine();
                foreach (Worker w in workerList)
                {
                    Console.WriteLine(w);
                }

                List<Human> humanList = new List<Human>();
                humanList.AddRange(workerList);
                humanList.AddRange(studentList);
                humanList = humanList.OrderBy(h => h.FirstName).ThenBy(h => h.LastName).ToList();

                Console.WriteLine();
                foreach (Human h in humanList)
                {
                    Console.WriteLine(h);
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
