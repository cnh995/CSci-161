public class BadDataException extends Exception
{
    public BadDataException()
    {
	super("Error: The data given as input is not valid.\n");
    }

    public BadDataException(String moreDetail)
    {
	super("Error: The input given for " + moreDetail  + " is invalid.\n");
    }
}
