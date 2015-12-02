using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pr01Shapes.ShapeClasses
{
    internal class Rhombus : BasicShape
    {
        public Rhombus(double diagWidth, double diagHeight)
            : base(diagWidth, diagHeight)
        {
        }

        public override double CalculateArea()
        {
            return this.Height * this.Width / 2.0d;
        }

        public override double CalculatePerimeter()
        {
            double perimeter = Math.Sqrt(this.Height*this.Height + this.Width*this.Width) * 2;
            return perimeter;
        }
    }
}
