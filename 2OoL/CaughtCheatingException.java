/**
 *The CaughtCheatingException occurrs when an athlete gets caught cheating. He or she is then shamed for those actions.
 *
 *@author Christian Hansen
 */

public class CaughtCheatingException extends Exception
{
    public CaughtCheatingException()
    {
	super("An athlete has been caught cheating! Shame on them! Stripping all medals and endorsements, and giving a lifetime ban.");
    }

    public CaughtCheatingException(int inNum)
    {
	super("Athlete number " + inNum + " has been caught cheating! All medals and endorsements will be stripped, and a lifetime ban has been received.");
    }

}