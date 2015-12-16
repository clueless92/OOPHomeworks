using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr01GalacticGPS
{
    struct Location
    {
        private double latitude;
        private double longitude;
        private Planet planet;

        public Location(double latitude, double longitude, Planet planet) : this()
        {
            this.Latitude = latitude;
            this.Longitude = longitude;
            this.Planet = planet;
        }

        public double Latitude
        {
            get { return latitude; }
            set
            {
                if (value > 90 || value < -90)
                {
                    throw new ArgumentOutOfRangeException("Latitude", "Value must be in range [-90, 90]");
                }
                this.latitude = value;
            }
        }

        public double Longitude
        {
            get { return longitude; }
            set
            {
                if (value > 180 || value < -180)
                {
                    throw new ArgumentOutOfRangeException("Longitude", "Value must be in range [-180, 180]");
                }
                this.longitude = value;
            }
        }

        public Planet Planet
        {
            get { return this.planet; }
            set { this.planet = value; }
        }

        public override string ToString()
        {
            string location = string.Format("{0}, {1} - {2}", this.Latitude, this.Longitude, this.Planet);
            return location;
        }
    }
}
