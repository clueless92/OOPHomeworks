namespace MyOOPExam20Dec2015.Interfaces
{
    public interface IBlobFactory
    {
        IBlob CreateBlob(string name, int health, int damage,
            IAttackFactory attackFactory, IBehaviorFactory behaviorFactory,
            string attackType, string behaviorType);
    }
}
