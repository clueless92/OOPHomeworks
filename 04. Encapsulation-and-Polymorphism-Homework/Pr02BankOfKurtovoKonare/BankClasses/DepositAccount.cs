using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr02BankOfKurtovoKonare.CustomerClasses;
using Pr02BankOfKurtovoKonare.Interfaces;

namespace Pr02BankOfKurtovoKonare.BankClasses
{
    internal class DepositAccount : BankAccount, IWithdrawable
    {
        public DepositAccount(Customer customer, decimal balance, decimal interestRate)
            : base(customer, balance, interestRate)
        {
        }

        public void Withdraw(decimal amount)
        {
            this.Balance -= amount;
        }

        public override decimal InterestForMonths(int months)
        {
            if (this.Balance > 0m && this.Balance < 1000m)
            {
                return 0m;
            }
            if (months < 1)
            {
                return 0m;
            }
            return base.InterestForMonths(months);
        }
    }
}
