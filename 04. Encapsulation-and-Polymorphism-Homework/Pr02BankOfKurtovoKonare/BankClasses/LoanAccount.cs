using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr02BankOfKurtovoKonare.CustomerClasses;
using Pr02BankOfKurtovoKonare.Interfaces;

namespace Pr02BankOfKurtovoKonare.BankClasses
{
    internal class LoanAccount : BankAccount
    {
        public LoanAccount(Customer customer, decimal balance, decimal interestRate) : base(customer, balance, interestRate)
        {
        }

        public override decimal InterestForMonths(int months)
        {
            if (Customer is Individual)
            {
                months -= 3;
            }
            else
            {
                months -= 2;
            }
            return base.InterestForMonths(months);
        }
    }
}
