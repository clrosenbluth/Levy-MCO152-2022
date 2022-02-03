public class ProjectileMotion
{
    public static void main(String[] args)
    {
        Projectile p = new Projectile(52, 43);

//        System.out.println("x = " + p.getX(7));
//        System.out.println("y = " + p.getY(7));

        QuadraticEquation q = new QuadraticEquation(1, 5, 6);
        double[] xVals = q.getX();
        System.out.println("x values: " + xVals[0] + ", " + xVals[1]);
    }
}
