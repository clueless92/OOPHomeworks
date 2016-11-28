package bg.softuni.pr06PlanckConstant;

class Calculation
{
    static final double planck = 6.62606896e-34;
    static final double pi = 3.14159;

    static double reducePlanckConstant()
    {
        return planck / (2 * pi);
    }
}

public class Pr06PlanckConstant {

    public static void main(String[] args) {
        System.out.println(Calculation.reducePlanckConstant());
    }
}
