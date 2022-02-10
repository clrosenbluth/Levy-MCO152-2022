import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest
{
    @Test
    public void getX()
    {
        // given
        QuadraticEquation q = new QuadraticEquation(6, -11, -35.5);

        // when
        double[] xVals = q.getX();

        // then
        assertEquals(-1.683, xVals[0], .001);
        assertEquals(3.516, xVals[1], .001);
    }
}