using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr02BankOfKurtovoKonare.CustomerClasses;
using Pr02BankOfKurtovoKonare.Interfaces;

namespace Pr02BankOfKurtovoKonare.BankClasses
{
    internal class MortgageAccount : BankAccount
    {
        public MortgageAccount(Customer customer, decimal balance, decimal interestRate)
            : base(customer, balance, interestRate)
        {
        }

        public override decimal InterestForMonths(int months)
        {
            if (Customer is Individual)
            {
                months -= 6;
                return base.InterestForMonths(months);
            }
            if (months <= 12)
            {
                return base.InterestForMonths(months) / 2m;
            }
            return base.InterestForMonths(12) / 2m + base.InterestForMonths(months - 12);
        }
    }
}
