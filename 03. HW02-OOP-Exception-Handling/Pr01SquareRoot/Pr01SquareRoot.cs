using System;

namespace Pr01SquareRoot
{
    class Pr01SquareRoot
    {
        static void Main(string[] args)
        {
            try
            {
                int n = int.Parse(Console.ReadLine());
                if (n < 0)
                {
                    throw new ArgumentException(String.Format("Number must be in range [0, {0}]", int.MaxValue));
                }
                Console.WriteLine(Math.Sqrt(n));
            }
            catch (ArgumentException ae)
            {
                Console.WriteLine(ae.Message);
            }
            catch (Exception e)
            {
                Console.WriteLine("Not a number");
            }
            finally
            {
                Console.WriteLine("Good bye");
            }
        }
    }
}
