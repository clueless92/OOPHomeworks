using System;

namespace Pr01to03
{
    class Point3D
    {
        private static readonly Point3D STARTING_POINT = new Point3D(0d, 0d, 0d);

        private double x;
        private double y;
        private double z;

        public Point3D(double x, double y, double z)
        {
            this.X = x;
            this.Y = y;
            this.Z = z;
        }

        public double X
        {
            get { return x; }
            set { x = value; }
        }

        public double Y
        {
            get { return y; }
            set { y = value; }
        }

        public double Z
        {
            get { return z; }
            set { z = value; }
        }

        public static Point3D StartingPoint
        {
            get { return STARTING_POINT; }
        }

        public override string ToString()
        {
            string toReturn = String.Format("({0:f2}, {1:f2}, {2:f2})", X, Y, Z);
            return toReturn;
        }
    }
}
