using System;
using Pr01Shapes.Interfaces;
using Pr01Shapes.ShapeClasses;

namespace Pr01Shapes
{
    class Program
    {
        static void Main(string[] args)
        {
            IShape[] shapes = {
                new Circle(5d),
                new Rectangle(5d, 1d),
                new Rhombus(5d, 1d)
            };

            foreach (IShape s in shapes)
            {
                Console.WriteLine(s.GetType().ToString().Split('.')[2]);
                Console.WriteLine("Area: {0:f2}", s.CalculateArea());
                Console.WriteLine("Perimeter: {0:f2}", s.CalculatePerimeter());
                Console.WriteLine();
            }
        }
    }
}
