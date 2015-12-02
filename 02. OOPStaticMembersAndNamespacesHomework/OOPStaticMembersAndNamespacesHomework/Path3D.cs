using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr01to03
{
    class Path3D<Point3D>
    {
        private List<Point3D> pointList;

        public Path3D(List<Point3D> pointList = null)
        {
            this.PointList = pointList;
        }

        public Path3D()
        {
            this.PointList = new List<Point3D>();
        }

        public List<Point3D> PointList
        {
            get { return pointList; }
            set { pointList = value; }
        }

        public override string ToString()
        {
            StringBuilder pathBuilder = new StringBuilder();
            foreach (Point3D point3D in PointList)
            {
                pathBuilder.AppendLine(point3D.ToString());
            }
            return pathBuilder.ToString();
        }
    }
}
