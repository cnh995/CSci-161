public class BrokeDownException extends Exception
{
    public BrokeDownException()
    {
	super("Error: Transporter has broken down.\n");
    }

    public BrokeDownException(String transporterType, String moreDetail)
    {
	super("Error: " + transporterType + " has " + moreDetail + ".\n");
    }
}
