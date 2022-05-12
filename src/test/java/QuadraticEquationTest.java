import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuadraticEquationTest
{
    @Test
    public void getX()
    {
        // given
        QuadraticEquation q1 = new QuadraticEquation(6, -11, -35.5);

        // when
        double[] xVals1 = q1.getX();

        // then
        assertEquals(-1.683, xVals1[0], .001);
        assertEquals(3.516, xVals1[1], .001);
    }

    public void getXNaN()
    {
        // given
        QuadraticEquation q2 = new QuadraticEquation(6, -11, 35.5);

        // when
        double[] xVals2 = q2.getX();

        // then
        assertArrayEquals(new double[] {Double.NaN, Double.NaN}, xVals2);
    }
}