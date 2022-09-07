public record Projectile(
        double angleInDegrees,
        double initialVelocity
)
{
    static final double GRAVITATIONAL_CONSTANT = 9.8;

    public double getX(double time)
    {
        return initialVelocity * time * (Math.cos(Math.toRadians(angleInDegrees)));
    }

    public double getY(double time)
    {
        return initialVelocity * time * (Math.sin(Math.toRadians(angleInDegrees))) - .5 * GRAVITATIONAL_CONSTANT * time * time;
    }
}
