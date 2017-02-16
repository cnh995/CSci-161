/**
 *The AthleteFaintedException occurrs when an athlete's stamina reaches 0
 *
 *@author Christian Hansen
 */

public class AthleteFaintedException extends Exception
{
    public AthleteFaintedException()
    {
	super("An athlete has fainted!");
    }

    public AthleteFaintedException(int inNum)
    {
	super("Athlete number " + inNum + " has fainted! He/she will rest for 3 events.");
    }
}