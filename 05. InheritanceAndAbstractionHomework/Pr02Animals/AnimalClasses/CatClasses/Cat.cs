namespace Pr02Animals.AnimalClasses.CatClasses
{
    class Cat : Animal, ISoundProducible
    {
        public Cat(string name, int age, Gender gender) : base(name, age, gender)
        {
        }

        public string ProduceSound()
        {
            return "Meow";
        }
    }
}
