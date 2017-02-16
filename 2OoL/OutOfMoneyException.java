/**
 *The OutOfMoneyException occurrs when a fan doesn't have enough money to enter an event
 *
 *@author Christian Hansen
 */

public class OutOfMoneyException extends Exception
{
    public OutOfMoneyException()
    {
	super("Error: This fan doesn't have enough money to enter this event. He/She is being shown the door.");
    }
}