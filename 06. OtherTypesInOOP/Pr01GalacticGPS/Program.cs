using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr01GalacticGPS
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Location home = new Location(18.037986, 28.870097, Planet.Earth);
                Console.WriteLine(home);
                Location mars = new Location(91, 60, Planet.Mars);
            }
            catch (ArgumentOutOfRangeException aoore)
            {
                Console.WriteLine(aoore.Message);
            }
        }
    }
}
