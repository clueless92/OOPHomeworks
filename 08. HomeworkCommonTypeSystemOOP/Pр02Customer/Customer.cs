using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr02Customer
{
    class Customer : ICloneable, IComparable<Customer>
    {
        private string firstName;
        private string middleName;
        private string lastName;
        private string id;
        private string permanentAddress;
        private string mobilePhone;
        private string email;
        private CustomerType customerType;
        private IList<Payment> payments;

        public Customer(string firstName, string middleName, string lastName, string id, 
            string permanentAddress = null, string mobilePhone = null, string email = null)
        {
            this.FirstName = firstName;
            this.MiddleName = middleName;
            this.LastName = lastName;
            this.ID = id;
            this.PermanentAddress = permanentAddress;
            this.MobilePhone = mobilePhone;
            this.Email = email;
            this.Payments = new List<Payment>();
        }

        public string FirstName
        {
            get { return firstName; }
            set { firstName = value; }
        }

        public string MiddleName
        {
            get { return middleName; }
            set { middleName = value; }
        }

        public string LastName
        {
            get { return lastName; }
            set { lastName = value; }
        }

        public string ID
        {
            get { return id; }
            set { id = value; }
        }

        public string PermanentAddress
        {
            get { return permanentAddress; }
            set { permanentAddress = value; }
        }

        public string MobilePhone
        {
            get { return mobilePhone; }
            set { mobilePhone = value; }
        }

        public string Email
        {
            get { return email; }
            set { email = value; }
        }

        public CustomerType CustomerType
        {
            get { return customerType; }
            set { customerType = value; }
        }

        public IList<Payment> Payments
        {
            get { return payments; }
            set { payments = value; }
        }

        public void AddPayment(Payment payment)
        {
            this.Payments.Add(payment);
            var paymetsCount = this.Payments.Count;
            if (paymetsCount <= 1)
            {
                this.CustomerType = CustomerType.OneTime;
            }

            if (paymetsCount >= 2)
            {
                this.CustomerType = CustomerType.Regular;
            }

            if (paymetsCount >= 5)
            {
                this.CustomerType = CustomerType.Golden;
            }

            if (paymetsCount >= 8)
            {
                this.CustomerType = CustomerType.Diamond;
            }
        }

        public override bool Equals(object obj)
        {
            if (obj.GetType() != this.GetType())
            {
                return false;
            }
            Customer other = (Customer) obj;
            bool areEqual = string.Equals(FirstName, other.FirstName)
                && string.Equals(this.MiddleName, other.MiddleName)
                && string.Equals(LastName, other.LastName) && ID == other.ID;
            return areEqual;
        }

        public override int GetHashCode()
        {
            unchecked
            {
                return this.ID.GetHashCode();
            }
        }

        public int CompareTo(Customer other)
        {
            string fullNameThis = string.Format("{0} {1} {2}", this.FirstName, this.MiddleName, this.LastName);
            string fullNameOther = string.Format("{0} {1} {2}", other.FirstName, other.MiddleName, other.LastName);
            if (String.Compare(fullNameThis, fullNameOther, StringComparison.Ordinal) == 0)
            {
                return String.Compare(this.ID, other.ID, StringComparison.Ordinal);
            }
            return String.Compare(fullNameThis, fullNameOther, StringComparison.Ordinal);
        }

        public override string ToString()
        {
            string paymentsString = "";
            if (this.Payments.Count != 0)
            {
                foreach (var payment in this.Payments)
                {
                    paymentsString += payment + " ";
                }
            }
            string customerString =
                String.Format("{0} {1} {2}\nEGN: {3}\nAddress: {4}\nMobile: {5}\nEmail: {6}\nPayments: {7}\nType: {8}",
                this.FirstName,
                this.MiddleName,
                this.LastName,
                this.ID,
                this.PermanentAddress,
                this.MobilePhone,
                this.Email,
                paymentsString,
                this.CustomerType);

            return customerString;
        }

        public object Clone()
        {
            var cloning = new Customer(this.FirstName, this.MiddleName, this.LastName,
            this.ID, this.PermanentAddress, this.Email, this.MobilePhone);

            cloning.Payments = new List<Payment>();
            foreach (var payment in this.Payments)
            {
                cloning.Payments.Add(new Payment(payment.ProductName, payment.Price));
            }
            cloning.CustomerType = this.CustomerType;

            return cloning;
        }

        public static bool operator ==(Customer firstCustomer, Customer secondCustomer)
        {
            return firstCustomer.Equals(secondCustomer);
        }

        public static bool operator !=(Customer firstCustomer, Customer secondCustomer)
        {
            return !firstCustomer.Equals(secondCustomer);
        }
    }
}
