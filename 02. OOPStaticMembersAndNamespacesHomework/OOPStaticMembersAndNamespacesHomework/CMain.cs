using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr01to03
{
    class CMain
    {
        static void Main(string[] args)
        {
            Point3D A = new Point3D(1.0, 2.4, 3d);
            Console.WriteLine(A);
            Console.WriteLine(Point3D.StartingPoint);
            double distanceOtoA = DistanceCalculator.CalculateDistance(A, Point3D.StartingPoint);
            Console.WriteLine("{0:f2}", distanceOtoA);
            Path3D<Point3D> path = new Path3D<Point3D>();
            path.PointList.Add(Point3D.StartingPoint);
            path.PointList.Add(A);
            Console.WriteLine(path);
            Storage.SavePath3D("paths.txt", path);
            path.PointList.Clear();
            Console.WriteLine(path);
            path = Storage.LoadPath3D("paths.txt");
            Console.WriteLine(path);
        }
    }
}
