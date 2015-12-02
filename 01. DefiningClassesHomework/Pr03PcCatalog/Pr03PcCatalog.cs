using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr03PcCatalog
{
    class Component
    {
        private string name;
        private string details;
        private double price;

        public string Name
        {
            get { return this.name; }
            set
            {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("Name cannot be empty");
                }
                this.name = value;
            }
        }
        public double Price
        {
            get { return this.price; }
            set
            {
                if (value < 0.0d)
                {
                    throw new ArgumentException("Price cannot be negative");
                }
                this.price = value;
            }
        }
        public string Details
        {
            get { return this.details; }
            set
            {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("Details cannot be empty");
                }
                this.details = value;
            }
        }

        public Component(string name, double price)
        {
            this.Name = name;
            this.Price = price;
        }

        public Component(string name, double price, string details) : this(name, price)
        {
            this.Details = details;
        }
        
    }
    class Computer
    {
        private string name;
        private double price;
        private Component processor;
        private Component motherboard;

        public Computer (string name, double price, Component processor, Component motherboard)
        {
            this.Name = name;
            this.Price = price;
            this.Processor = processor;
            this.Motherboard = motherboard;
        }


        public Component Motherboard { get; set; }
        public Component Processor { get; set; }

        public double Price
        {
            get { return this.price; }
            set
            {
                if (value < 0.0d)
                {
                    throw new ArgumentException("Price cannot be negative");
                }
                this.price = value;
            }
        }


        public string Name
        {
            get { return this.name; }
            set
            {
                if (string.IsNullOrEmpty(value) || string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("Name cannot be empty");
                }
                this.name = value;
            }
        }

        public double GetTotalPrice()
        {
            return this.Price + this.Motherboard.Price + this.Processor.Price;
        }

        public override string ToString()
        {
            string info = string.Format(CultureInfo.CreateSpecificCulture("bg-BG"),
                "Computer: {0}\nMotherboard: {1}; price: {2:c}\nProcessor: {3}; price: {4:c}\nTotal price: {5:c}",
                this.Name, this.Motherboard.Name, this.Motherboard.Price,
                this.Processor.Name, this.Processor.Price, this.GetTotalPrice());
            return info;
        }

    }
    class Pr03PcCatalog
    {
        static void Main(string[] args)
        {
            Computer pravetz = new Computer("Pravetz 64", 999.99, new Component("Intel i5", 499.99),
                new Component("Gygabite", 99.99));
            Computer dell = new Computer("Dell Workstation", 1099.99, new Component("AMD R9", 599.99),
                new Component("Assrock", 109.99));
            Computer hp = new Computer("HP Tower", 1099.99, new Component("Xeon Q4", 699.99),
                new Component("Asus", 119.99));
            Computer[] computers = new Computer[3];
            computers[0] = dell;
            computers[1] = hp;
            computers[2] = pravetz;
            computers = computers.OrderBy(c => c.GetTotalPrice()).ToArray();
            foreach (Computer computer in computers) {
                Console.WriteLine(computer);
            }
        }
    }
}
