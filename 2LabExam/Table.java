import java.util.*;

/**
 *The Table class stores information about table objects
 *
 *@author Christian Hansen
 */

public class Table implements Repairable
{
    private int weightCapacity = 0;
    private int currentWeight = 0;
    private double loadPercent = 0.0;
    private int daysToFix = 0;
    private boolean fixed = true;

    /**
     *This constructor sets the capacity to a random number
     */
    public Table()
    {
	Random rng = new Random();
	int capacity = rng.nextInt(476) + 25;
	setCapacity(capacity);
    }

    /**
     *The toString method gives some information about the current Table object
     */
    public String toString()
    {
	String output = "";
	output += "The capacity of this table is " +  getCapacity() + ".\n";
	output += "The current weight on the table is " + getCurrentWeight() + ".\n";
	output += "The percentage of current weight compared to capacity is " + percent() + "%.\n";

	return output;
    }

    /**
     *The getCapacity method returns how much weight the table can hold
     *
     *@return int This is the capacity of the table
     */
    public int getCapacity()
    {
	return weightCapacity;
    }

    /**
     *The getCurrentWeight method returns how much weight is currently on the table.
     *
     *@return int This is the weight that is currently on the table
     */
    public int getCurrentWeight()
    {
	return currentWeight;
    }

    /**
     *The setCapacity method sets the capacity to the given input
     *
     *@param inCapacity This is how much weight the table can hold
     */
    public void setCapacity(int inCapacity)
    {
	weightCapacity = inCapacity;
    }

    /**
     *The setCurrentWeight method sets the current weight on the table to the given input
     *
     *@param inCurrent This is the weight currently on the table
     */
    public void setCurrentWight(int inCurrent)
    {
	currentWeight = inCurrent;
    }

    /**
     *The percent method calculates and then returns the percentage of weight on the table compared to its capacity
     *
     *@return double This is the percentage of weight on the table compared to its capacity
     */
    public double percent()
    {
	loadPercent = ((double)(currentWeight) / (double)(weightCapacity)) * 100;
	return loadPercent;
    }

    /**
     *The add method attempts to add more weight to the table, but if adding the weight breaks the table, it throws the BrokenTableException
     *
     *@param inWeight This is how much weight we want to try to add to the table
     *
     *@exception BrokenTableException This occurs when adding weight to the table causes the table to break
     */
    public void add(int inWeight) throws BrokenTableException
    {
	try
	    {
		if(currentWeight + inWeight <= weightCapacity)
		    {
			currentWeight += inWeight;
		    }
		else
		    {
			fixed = false;
			throw new BrokenTableException(weightCapacity, currentWeight + inWeight);
		    }
	    }
	catch(BrokenTableException bte)
	    {
		Random rng = new Random();
		daysToFix = rng.nextInt(9) + 1;
		System.err.println(bte.getMessage());
		fix();
	    }
    }

    /**
     *The daysUntilFixed method will return how many days are left in the repair
     *
     *@return int This is how many days are left until the table is fixed
     */
    public int daysUntilFixed()
    {
	return daysToFix;
    }

    /**
     *The fix method will fix the table, showing how many days a left until it is fixed, then printing out when it is fixed
     */
    public void fix()
    {
	while(daysToFix != 0)
	    {
		System.out.println("This table will take " + daysToFix + " more days to fix.");
		daysToFix -= 1;
	    }

	if(daysToFix == 0)
	    {
		System.out.println("The table is fixed!\n");
		fixed = true;
	    }
    }
}
