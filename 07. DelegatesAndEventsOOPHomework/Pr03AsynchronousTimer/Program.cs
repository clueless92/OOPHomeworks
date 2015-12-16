using System;

namespace Pr03AsynchronousTimer
{
    class Program
    {
        public static void SomeMethod(string smth)
        {
            Console.WriteLine("SomeMethod: {0}", smth);
        }
        public static void AnotherMethod(string smth)
        {
            Console.WriteLine("AnotherMethod: {0}", smth);
        }
        static void Main()
        {
            AsyncTimer someTimer = new AsyncTimer(SomeMethod, 1000, 10);
            someTimer.Start();
            AsyncTimer anotherTimer = new AsyncTimer(AnotherMethod, 500, 20);
            anotherTimer.Start();
        }
    }
}
