/**
 *The NotEnoughAthletesException occurrs when there aren't enough athletes to participate in an event
 *
 *@author Christian Hansen
 */

public class NotEnoughAthletesException extends Exception
{
    public NotEnoughAthletesException()
    {
	super("Error: not enough athletes for this event.");
    }

    public NotEnoughAthletesException(Event inEvent)
    {
	super("Error: " + inEvent.getName() + " doesn't have enough athletes.");
    }
}