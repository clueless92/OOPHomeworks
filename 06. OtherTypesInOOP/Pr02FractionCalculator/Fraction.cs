using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr02FractionCalculator
{
    struct Fraction
    {
        private long numerator;
        private long denominator;

        public Fraction(long numerator, long denominator) : this()
        {
            this.Numerator = numerator;
            this.Denominator = denominator;
        }

        public long Numerator
        {
            get { return numerator; }
            set { numerator = value; }
        }

        public long Denominator
        {
            get { return denominator; }
            set
            {
                if (value == 0)
                {
                    throw new DivideByZeroException("Denominator cannot be 0");
                }
                denominator = value;
            }
        }

        public static Fraction operator + (Fraction f1, Fraction f2)
        {
            if (f1.Denominator == f2.Denominator)
            {
                return new Fraction(f1.Numerator + f2.Numerator, f1.Denominator);
            }
            long commonDenuminator = f1.Denominator * f2.Denominator;
            long addedNumerator = f1.Numerator * f2.Denominator + f2.Numerator * f1.Denominator;
            return new Fraction(addedNumerator, commonDenuminator);
        }

        public static Fraction operator - (Fraction f1, Fraction f2)
        {
            if (f1.Denominator == f2.Denominator)
            {
                return new Fraction(f1.Numerator - f2.Numerator, f1.Denominator);
            }
            long commonDenuminator = f1.Denominator * f2.Denominator;
            long addedNumerator = f1.Numerator * f2.Denominator - f2.Numerator * f1.Denominator;
            return new Fraction(addedNumerator, commonDenuminator);
        }

        public override string ToString()
        {
            decimal result = (decimal) this.Numerator / this.Denominator;
            return result.ToString();
        }
    }
}
