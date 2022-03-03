public class InsufficientTilesException extends Exception
{
    InsufficientTilesException()
    {
        super("Word cannot be formed from current tiles.");
    }
}
