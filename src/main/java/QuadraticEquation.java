public class QuadraticEquation
{
    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] getX()
    {
        double[] xVals = new double[2];

        double sqrt = Math.sqrt(b * b - 4 * a * c);
        xVals[0] = (-b - sqrt) / (2 * a);
        xVals[1] = (-b + sqrt) / (2 * a);

        return xVals;
    }
}
