using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using Pr04GenericListVersion;

namespace Pr03GenericList
{
    class Program
    {
        static void Main(string[] args)
        {
            GenericList<int> list = new GenericList<int>() {0, 1, 2, 3};
            Console.WriteLine("Some ToString, Add, RemoveAt and Insert tests:");
            Console.WriteLine(list);
            list.RemoveAt(2);
            Console.WriteLine(list);
            list.Insert(2, 2);
            Console.WriteLine(list);
            list.Insert(4, 4);
            Console.WriteLine(list);
            list.Add(0);
            Console.WriteLine("Test IndexOf(0): {0}", list.IndexOf(0));
            Console.WriteLine("Test LastIndexOf(0): {0}", list.LastIndexOf(0));
            Console.WriteLine("Test String.Join/foreach: {0}", string.Join(", ", list));
            Console.WriteLine();
            Console.WriteLine("Test Max: {0}", list.Max());
            Console.WriteLine("Test Min: {0}", list.Min());
            list.Add(6);
            list.Add(7);
            list.Add(8);
            list.Add(9);
            list.RemoveAt(5);
            list.Insert(5, 5);

            Console.WriteLine("Test foreach:");
            foreach (var item in list)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("Count after all tests: {0}", list.Count);
            list.Clear();
            Console.WriteLine("Test Clear: {0}", list);
            Console.WriteLine();

            Type type = typeof (GenericList<>);
            var allAttributes = type.GetCustomAttributes(false);
            foreach (var attribute in allAttributes)
            {
                if (attribute is VersionAttribute)
                {
                    Console.WriteLine(attribute);
                }
            }
        }
    }
}
