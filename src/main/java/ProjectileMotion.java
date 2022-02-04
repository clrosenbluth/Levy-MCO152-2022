public class ProjectileMotion
{
    public static void main(String[] args)
    {
        Projectile p = new Projectile(52, 43);

        System.out.println("x = " + p.getX(7));
        System.out.println("y = " + p.getY(7));
    }
}
