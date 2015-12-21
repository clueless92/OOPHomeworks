using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyOOPExam20Dec2015.Interfaces
{
    public interface IDestroyable
    {
        int Health { get; }

        void RespondToAttack(int damageTaken);
    }
}
