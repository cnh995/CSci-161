public class FacilitiesMismatchException extends Exception
{
    public FacilitiesMismatchException()
    {
	super("Error: The Port you are using to unload or load your transporter does not have the correct facilities.\n");
    }

    public FacilitiesMismatchException(String moreDetail)
    {
	super("Error: The Port you are using to unload or load your transporter does not have the correct facilities. This happened during a " + moreDetail + ".\n");
    }
}
