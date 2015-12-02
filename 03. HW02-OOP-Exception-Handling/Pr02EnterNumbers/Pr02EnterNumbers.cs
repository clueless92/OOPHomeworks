using System;

namespace Pr02EnterNumbers
{
    class Pr02EnterNumbers
    {
        private static int lastN = 1;
        static void Main(string[] args)
        {
            for (int i = 1; i <= 10;)
            {
                try
                {
                    Console.Write("Please, enter {0} number: ", i);
                    lastN = ReadNumber(lastN, 100);
                    i++;
                }
                catch (ArgumentException ae)
                {
                    Console.WriteLine(ae.Message);
                }
                catch (Exception e)
                {
                    Console.WriteLine("NaN! Please, enter a valid number.");
                }
            }
        }

        static int ReadNumber(int start, int end)
        {
            int n = int.Parse(Console.ReadLine());
            if (n < start || n > end)
            {
                throw new ArgumentException(
                    String.Format("Number must be in range [{0}, {1}]. Please, try again.", start, end));
            }
            return n;
        }
    }
}
