/**
 *The TooManyAthletesException occurrs when too many athletes are present at an event
 *
 *@author Christian Hansen
 */

public class TooManyAthletesException extends Exception
{
    public TooManyAthletesException()
    {
	super("Error: Too many athletes present for this event.");
    }

    public TooManyAthletesException(Event inEvent)
    {
	super(inEvent.getName() + " has too many athletes trying to participate.");
    }
}