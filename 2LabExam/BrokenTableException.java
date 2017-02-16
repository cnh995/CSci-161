/**
 *The BrokenTableException class handles an error when a table tries to hold a weight higher than its capacity
 *
 *@author Christian Hansen
 */
public class BrokenTableException extends Exception
{
    /**
     * This constructor will give a standard message
     */
    public BrokenTableException()
    {
	super("Error: too much weight was added to the table and it broke.\n");
    }

    /**
     *This constructor takes in some inputs to give a more specific reason why the error happened
     */
    public BrokenTableException(int inMax, int inWeightAdded)
    {
	super("Error: the maximum weight the table can hold is " + inMax + " and adding " + inWeightAdded + " was too much.\n");
    }
}
