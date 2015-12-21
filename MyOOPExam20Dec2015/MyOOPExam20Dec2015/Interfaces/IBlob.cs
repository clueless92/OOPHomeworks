namespace MyOOPExam20Dec2015.Interfaces
{
    public interface IBlob : IDestroyable, IUpdateable
    {
        int GetAttackDamage();
        string Name { get; }
        int Damage { get; }
    }
}
