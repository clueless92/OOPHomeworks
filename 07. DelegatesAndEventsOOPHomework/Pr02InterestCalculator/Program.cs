using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Pr02InterestCalculator
{
    class Program
    {
        static void Main(string[] args)
        {
            InterestCalculator interestCalculator = 
                new InterestCalculator(500, 0.056, 10, InterestCalculator.GetCompoundInterest);
            Console.WriteLine("{0:f4}", interestCalculator.Result); // 874.1968
            interestCalculator = new InterestCalculator(2500, 0.072, 15, InterestCalculator.GetSimpleInterest);
            Console.WriteLine("{0:f4}", interestCalculator.Result); // 5200.0000
        }
    }
}
