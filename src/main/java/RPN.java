import java.util.Stack;

public class RPN
{
    private final Stack<Double> rpnStack;

    public RPN ()
    {
        this.rpnStack = new Stack<>();
    }

    /**
     * A method to evaluate a string, presumably an RPN (Reverse Polish Notation) expression
     * Explanation of RPN: https://en.wikipedia.org/wiki/Reverse_Polish_notation
     * @param userInput the string typed by the user, presumably an RPN expression
     * @return a string, either the answer or an appropriate error message
     */
    public String evaluate(String userInput)
    {
        String answer = "Ended with error";
        boolean hasError = false;

        try
        {
            String[] splitExpression = userInput.split("\\s+");

            for (String element : splitExpression)
            {
                if (isNumber(element))
                {
                    rpnStack.add(Double.parseDouble(element));
                }
                else if (isOperator(element))
                {
                    try
                    {
                        Double secondNumber = rpnStack.pop();
                        Double firstNumber = rpnStack.pop();
                        doOperation(rpnStack, element, firstNumber, secondNumber);
                    }
                    catch (Exception e)
                    {
                        answer = "Error: syntax error encountered";
                        hasError = true;
                        break;
                    }
                }
                else    // token is neither a double nor an operator
                {
                    answer = "Error: invalid token encountered.";
                    hasError = true;
                    break;
                }
            }

            if (!hasError)
            {
                answer = rpnStack.pop().toString();
            }

            if (!rpnStack.isEmpty())
            {
                answer = "Error: stack is too big. The expression is likely malformed.";
            }
        }
        catch (Exception e)
        {
            answer = e.getMessage();
        }

        return answer;
    }

    /**
     * A method to do an operation in an RPN stack
     * @param rpnStack the stack that the answer will be pushed to
     * @param element the operator (in String form)
     * @param firstNumber the first number do be used in the operation
     * @param secondNumber the second number do be used in the operation
     */
    private void doOperation(Stack<Double> rpnStack, String element, Double firstNumber, Double secondNumber)
    {
        double answer;

        switch (element) {
            case "+":
                answer = firstNumber + secondNumber;
                break;
            case "-":
                answer = firstNumber - secondNumber;
                break;
            case "/":
                answer = firstNumber / secondNumber;
                break;
            default:
                answer = firstNumber * secondNumber;
                break;
        }

        rpnStack.push(answer);
    }

    /**
     * A method to determine if an element in an RPN expression is a double
     * @param element the element to be checked
     * @return true or false (if the element is or is not a double)
     */
    private boolean isNumber(String element)
    {
        try
        {
            Double.parseDouble(element);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * A method to determine if an element in an RPN expression is an operator
     * @param element the element to be checked
     * @return true or false (if the element is or is not an operator)
     */
    private boolean isOperator(String element)
    {
        return (element.equals("+") || element.equals("-") || element.equals("/") || element.equals("*"));
    }
}
