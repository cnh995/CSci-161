/**
 *The TooManyFansExcpetion occurrs when the number of fans entering a venue would bring it over the capacity
 *
 *@author Christian Hansen
 */

public class TooManyFansException extends Exception
{
    public TooManyFansException()
    {
	super("Error: Too many fans entering the venue! Attempting to move to a larger venue.");
    }

    public TooManyFansException(int inMax, Venue inVenue)
    {
	super("Error: too many fans! The max at " + inVenue.getName() + " is " + inMax + ". Attempting to move to a larger venue..."); 
    }
}