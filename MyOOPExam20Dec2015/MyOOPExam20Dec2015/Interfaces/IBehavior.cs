namespace MyOOPExam20Dec2015.Interfaces
{
    public interface IBehavior
    {
        // Behavior can effect both health and damage.
        // For further extensivbility when implementing behaviors -
        // return both health and damage respectivly in the 0 and 1 element of int[]
        int[] InnitialBehavior(int health, int damage);
        int[] ConsecutiveBehavior(int health, int damage);
    }
}
