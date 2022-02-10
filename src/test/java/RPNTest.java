import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPNTest
{
    @Test
    public void evaluateSimple()
    {
        // given
        RPN rpnTester = new RPN();
        String test = "2 3 4 + *";

        // where
        String result = rpnTester.evaluate(test);

        // then
        assertEquals("14.0", result);
    }

    @Test
    public void evaluateComplex()
    {
        // given
        RPN rpnTester = new RPN();
        String test = "5 4 3 / /";

        // where
        String result = rpnTester.evaluate(test);

        // then
        assertEquals("3.75", result);
    }

    @Test
    public void evaluateError()
    {
        // given
        RPN rpnTester = new RPN();
        String test = "2 3 4 +";
        String errorMsg = "Error: stack is too big. The expression is likely malformed.";

        // where
        String result = rpnTester.evaluate(test);

        // then
        assertEquals(errorMsg, result);
    }

}