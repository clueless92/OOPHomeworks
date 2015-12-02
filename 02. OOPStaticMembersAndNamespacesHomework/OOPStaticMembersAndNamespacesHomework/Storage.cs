using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr01to03
{
    class Storage
    {
        public static void SavePath3D(string filePath, Path3D<Point3D> path)
        {
            try
            {
                File.WriteAllText(filePath, path.ToString());
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }

        public static Path3D<Point3D> LoadPath3D(string filePath)
        {
            try
            {
                Path3D<Point3D> path = new Path3D<Point3D>();
                foreach (string line in File.ReadAllLines(filePath))
                {
                    string[] lineVals = line.Split(new char[] {',', ' ', '(', ')'}, StringSplitOptions.RemoveEmptyEntries);
                    double x = double.Parse(lineVals[0]);
                    double y = double.Parse(lineVals[1]);
                    double z = double.Parse(lineVals[2]);
                    path.PointList.Add(new Point3D(x, y, z));
                }
                return path;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return null;
            }
        }
    }
}
