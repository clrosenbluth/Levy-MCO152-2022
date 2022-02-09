public class QuadraticEquationMain
{
    public static void main(String[] args)
    {
        QuadraticEquation q = new QuadraticEquation(1, 5, 6);
        double[] xVals = q.getX();
        System.out.println("x values: " + xVals[0] + ", " + xVals[1]);
    }
}
