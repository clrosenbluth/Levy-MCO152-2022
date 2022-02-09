public class Projectile
{
    static final double GRAVITATIONAL_CONSTANT = 9.8;

    private final double angleInDegrees;
    private final double initialVelocity;

    public Projectile(double angleInDegrees, double initialVelocity)
    {
        this.angleInDegrees = angleInDegrees;
        this.initialVelocity = initialVelocity;
    }

    public double getX(double time)
    {
        return initialVelocity * time * (Math.cos(Math.toRadians(angleInDegrees)));
    }

    public double getY(double time)
    {
        return initialVelocity * time * (Math.sin(Math.toRadians(angleInDegrees))) - .5 * GRAVITATIONAL_CONSTANT * time * time;
    }
}
