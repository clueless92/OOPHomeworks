namespace Pr02Animals.AnimalClasses
{
    class Dog : Animal, ISoundProducible
    {
        public Dog(string name, int age, Gender gender)
            : base(name, age, gender)
        {
        }

        public string ProduceSound()
        {
            return "Woof, woof";
        }
    }
}
