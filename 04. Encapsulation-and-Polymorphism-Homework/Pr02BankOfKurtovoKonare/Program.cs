using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr02BankOfKurtovoKonare.BankClasses;
using Pr02BankOfKurtovoKonare.CustomerClasses;

namespace Pr02BankOfKurtovoKonare
{
    class Program
    {
        static void Main(string[] args)
        {
            DepositAccount depositAccount = new DepositAccount(new Company("SoftUni OOD"), 10000m, 0.6m);
            depositAccount.Withdraw(2m);
            depositAccount.Deposit(2m);
            Console.WriteLine("{0} depositAccount interest for 12 months: {1:f2}", 
                depositAccount.Customer.Name, depositAccount.InterestForMonths(12));

            depositAccount.Withdraw(9500m);
            Console.WriteLine("{0} depositAccount interest for 12 months: {1:f2}", 
                depositAccount.Customer.Name, depositAccount.InterestForMonths(12));
            Console.WriteLine();


            BankAccount loanAccount = new LoanAccount(new Individual("Pesho"), 999m, 0.8m);
            loanAccount.Deposit(1m);
            Console.WriteLine("{0} loanAccount interest for 12 months: {1:f2}",
                loanAccount.Customer.Name, loanAccount.InterestForMonths(12));

            loanAccount.Customer = new Company("Pesho ET");
            Console.WriteLine("{0} loanAccount interest for 12 months: {1:f2}",
                loanAccount.Customer.Name, loanAccount.InterestForMonths(12));
            Console.WriteLine();


            BankAccount mortgageAccount = new MortgageAccount(new Individual("Kiro"), 999m, 0.7m);
            mortgageAccount.Deposit(1m);
            Console.WriteLine("{0} mortgageAccount interest for 18 months: {1:f2}",
                mortgageAccount.Customer.Name, mortgageAccount.InterestForMonths(18));

            mortgageAccount.Customer = new Company("Kiro ET");
            Console.WriteLine("{0} mortgageAccount interest for 18 months: {1:f2}",
                mortgageAccount.Customer.Name, mortgageAccount.InterestForMonths(18));

            Console.WriteLine("{0} mortgageAccount interest for 6 months: {1:f2}",
                mortgageAccount.Customer.Name, mortgageAccount.InterestForMonths(6));
            Console.WriteLine();
        }
    }
}
