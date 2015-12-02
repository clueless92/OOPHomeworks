using System;
using System.Text;

namespace Pr01to03
{
    class DistanceCalculator
    {
        public static double CalculateDistance(Point3D p1, Point3D p2)
        {
            double xSquare = (p1.X - p2.X) * (p1.X - p2.X);
            double ySquare = (p1.Y - p2.Y) * (p1.Y - p2.Y);
            double zSquare = (p1.Z - p2.Z) * (p1.Z - p2.Z);
            double distance = Math.Sqrt(xSquare + ySquare + zSquare);
            return distance;
        }
    }
}
