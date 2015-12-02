using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr02BankOfKurtovoKonare.CustomerClasses;
using Pr02BankOfKurtovoKonare.Interfaces;

namespace Pr02BankOfKurtovoKonare.BankClasses
{
    internal abstract class BankAccount : IDepositable
    {
        private Customer customer;
        private decimal balance;
        private decimal interestRate;

        protected BankAccount(Customer customer, decimal balance, decimal interestRate)
        {
            this.customer = customer;
            this.balance = balance;
            this.interestRate = interestRate;
        }

        public Customer Customer
        {
            get { return customer; }
            set { customer = value; }
        }

        public decimal Balance
        {
            get { return balance; }
            protected set { balance = value; }
        }

        public decimal InterestRate
        {
            get { return interestRate; }
            set { interestRate = value; }
        }

        public virtual decimal InterestForMonths(int months)
        {
            if (months < 1)
            {
                return 0m;
            }
            return this.Balance * (1m + this.InterestRate * months);
        }

        public void Deposit(decimal amount)
        {
            this.Balance += amount;
        }
    }
}
