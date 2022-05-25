import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectileTest
{
    @Test
    public void getX()
    {
        // given - variables, conditions
        Projectile p = new Projectile(52, 17);

        // when - tests
        double x = p.getX(3);

        // then - check results
        assertEquals(31.3987, x, 0.0001);
    }

    @Test
    public void getY()
    {
        // given - variables, conditions
        Projectile p = new Projectile(52, 17);

        // when - tests
        double y = p.getY(3);

        // then - check results
        assertEquals(-3.9114, y, 0.0001);
    }

}