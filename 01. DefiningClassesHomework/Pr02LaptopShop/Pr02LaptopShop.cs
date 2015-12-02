using System;

namespace Pr02LaptopShop
{
    public class Battery
    {
        private string batteryModel;
        public string BatteryModel
        {
            get
            {
                return this.batteryModel;
            }
            set
            {
                if (value == "")
                {
                    throw new ArgumentException("Argument cannot be empty or negative");
                }
                this.batteryModel = value;
            }
        }
        public Battery(string batteryModel)
        {
            BatteryModel = batteryModel;
        }
    }
    class Laptop
    {
        private string model;
        private string manufacturer;
        private string processor;
        private string ram;
        private string graphicsCard;
        private string hdd;
        private string screen;
        private Battery battery;
        private int batteryLife;
        private double price;
        public string Model
        {
            get
            {
                return this.model;
            }
            set
            {
                if (value == "")
                {
                    throw new ArgumentException("Argument cannot be empty or negative");
                }
                this.model = value;
            }
        }
        public string Manufacturer
        {
            get { return this.manufacturer; }
            set
            {
                if (value == "")
                {
                    throw new ArgumentException("Argument cannot be empty or negative");
                }
                this.manufacturer = value;
            }
        }
        public string Processor
        {
            get { return this.processor; }
            set
            {
                if (value == "")
                {
                    throw new ArgumentException("Argument cannot be empty or negative");
                }
                this.processor = value;
            }
        }
        public string RAM
        {
            get { return this.ram; }
            set
            {
                if (value == "")
                {
                    throw new ArgumentException("Argument cannot be empty or negative");
                }
                this.ram = value;
            }
        }
        public string GraphicsCard
        {
            get { return this.graphicsCard; }
            set
            {
                if (value == "")
                {
                    throw new ArgumentException("Argument cannot be empty or negative");
                }
                this.graphicsCard = value;
            }
        }
        public string HDD
        {
            get { return this.hdd; }
            set
            {
                if (value == "")
                {
                    throw new ArgumentException("Argument cannot be empty or negative");
                }
                this.hdd = value;
            }
        }
        public string Screen
        {
            get { return this.screen; }
            set
            {
                if (value == "")
                {
                    throw new ArgumentException("Argument cannot be empty or negative");
                }
                this.screen = value;
            }
        }
        public Battery BatteryProp { get; set; }
        public int BatteryLife
        {
            get
            {
                return this.batteryLife;
            }
            set
            {
                if (value < 0)
                {
                    throw new ArgumentException("Argument cannot be empty or negative");
                }
                this.batteryLife = value;
            }
        }
        public double Price {
            get
            {
                return this.price;
            }
            set
            {
                if (value < 0.0d)
                {
                    throw new ArgumentException("Argument cannot be empty or negative");
                }
                this.price = value;
            }
        }

        public Laptop(string model, double price)
        {
            this.Model = model;
            this.Price = price;
        }
        public Laptop(string model, double price, string manufacturer, string processor, string ram,
            string graphicsCard, string hdd, string screen, Battery battery, int batteryLife) : this(model, price)
        {
            this.Manufacturer = manufacturer;
            this.RAM = ram;
            this.GraphicsCard = graphicsCard;
            this.HDD = hdd;
            this.Screen = screen;
            this.BatteryProp = battery;
            this.BatteryLife = batteryLife;
        }

        public override string ToString()
        {
            string info = string.Format("Laptop model: {0}, Price: {1}", this.Model, this.Price);
            return info;
        }
        
    }
    class Pr02LaptopShop
    {
        static void Main(string[] args)
        {
            Laptop lenovo = new Laptop("Yoga", 45.45);
            Console.WriteLine(lenovo);
            lenovo.Model = "ThinkPad";
            Console.WriteLine(lenovo.Model);
            lenovo.BatteryProp = new Battery("six cell battery");
            Laptop pravetz = new Laptop("Pravetz 64M", 1000.24, "Pravetz", "Intel Core i5 5200", "16GB", "NVidia GTX 980M",
                "512GB SSD", "14.1'", new Battery("8 cell battery"), 4);
            Console.WriteLine(pravetz);
            pravetz.Price = -0.1d;
        }
    }
}
