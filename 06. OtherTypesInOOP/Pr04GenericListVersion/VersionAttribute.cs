using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace Pr04GenericListVersion
{
    /// <summary>
    /// Provides version information
    /// </summary>
    [Version(1, 0)]
    [AttributeUsage(AttributeTargets.Struct 
        | AttributeTargets.Class 
        | AttributeTargets.Interface 
        | AttributeTargets.Enum 
        | AttributeTargets.Method)]
    public class VersionAttribute : Attribute
    {
        private int majorVersionNumber;
        private int minorVersionNumber;

        public VersionAttribute(int majorVersionNumber, int minorVersionNumber)
        {
            this.MajorVersionNumber = majorVersionNumber;
            this.MinorVersionNumber = minorVersionNumber;
        }

        public int MinorVersionNumber
        {
            get { return minorVersionNumber; }
            private set
            {
                if (value < 0)
                {
                    throw new ArgumentOutOfRangeException("Minor version number cannot be negative.");
                }
                minorVersionNumber = value;
            }
        }

        public int MajorVersionNumber
        {
            get { return majorVersionNumber; }
            private set
            {
                if (value < 0)
                {
                    throw new ArgumentOutOfRangeException("Major version number cannot be negative.");
                }
                majorVersionNumber = value;
            }
        }

        public override string ToString()
        {
            string versionString = String.Format("Version {0}.{1}", MajorVersionNumber, MinorVersionNumber);
            return versionString;
        }
    }
}
