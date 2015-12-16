using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr02InterestCalculator
{
    public delegate double CalculateInterest(double money, double interest, int years);
    public class InterestCalculator
    {
        public double Result { get; set; }
        public InterestCalculator(double money, double interest, int years, CalculateInterest interestDelegate)
        {
            Result = interestDelegate(money, interest, years);
        }
        public static double GetSimpleInterest(double money, double interest, int years)
        {
            double simpleInterest = money * (1d + interest * years);
            return simpleInterest;
        }
        public static double GetCompoundInterest(double money, double interest, int years)
        {
            double compoundInterest = money * Math.Pow(1d + interest / 12, years * 12);
            return compoundInterest;
        }
    }
}
