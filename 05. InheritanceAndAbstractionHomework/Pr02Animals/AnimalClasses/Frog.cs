namespace Pr02Animals.AnimalClasses
{
    class Frog : Animal, ISoundProducible
    {
        public Frog(string name, int age, Gender gender)
            : base(name, age, gender)
        {
        }

        public string ProduceSound()
        {
            return "Ribbit, ribbit";
        }
    }
}
