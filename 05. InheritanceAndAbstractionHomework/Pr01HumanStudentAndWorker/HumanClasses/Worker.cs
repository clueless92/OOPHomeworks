using System;

namespace Pr01HumanStudentAndWorker.HumanClasses
{
    class Worker : Human
    {
        private double weekSalary;
        private int workHoursPerDay;

        public Worker(string firstName, string lastName, double weekSalary, int workHoursPerDay) : base(firstName, lastName)
        {
            this.WeekSalary = weekSalary;
            this.WorkHoursPerDay = workHoursPerDay;
        }

        public double WeekSalary
        {
            get { return weekSalary; }
            set
            {
                if (value < 0.0d)
                {
                    throw new ArgumentOutOfRangeException("Week salary cannot be negative.");
                }
                weekSalary = value;
            }
        }

        public int WorkHoursPerDay
        {
            get { return workHoursPerDay; }
            set
            {
                if (value < 0)
                {
                    throw new ArgumentOutOfRangeException("Week salary cannot be negative.");
                }
                workHoursPerDay = value;
            }
        }

        public double MoneyPerHour()
        {
            return weekSalary / (7 * workHoursPerDay);
        }
        public override string ToString()
        {
            string info = base.ToString() + string.Format(", Money per hour: {0:F2}", MoneyPerHour());
            return info;
        }
    }
}
