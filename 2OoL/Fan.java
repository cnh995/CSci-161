import java.util.*;

/**
 *The Fan class builds and stores information about Fan objects
 *
 *@author Christian Hansen
 */

public class Fan
{
    private int wallet = 0;
    Venue.VenueType pref;

    public String toString()
    {
	String output = "";

	output += "The fan has $" + getWallet() + " in his/her wallet.";
	output += "The fan prefers " + getPref() + " venues.";

	return output;
    }

    /**
     *This constructor takes inputs and assigns them to the correct variable
     */
    public Fan()
    {
	setWallet();
	setPref();
    }

    /**
     *The setPref method sets the fan's preferred venue type to the given input
     */
    public void setPref()
    {
	Random rng = new Random();
	int randVenue = rng.nextInt(4);

	if(randVenue == 0)
	    {
		pref = Venue.VenueType.AQUATIC;
	    }
	else if(randVenue == 1)
	    {
		pref = Venue.VenueType.TRACK;
	    }
	else if(randVenue == 2)
	    {
		pref = Venue.VenueType.GYM;
	    }
	else
	    {
		pref = Venue.VenueType.OUTDOOR;
	    }
    }

    /**
     *The setWallet method sets the amount of money the fan has to some multiple of 10 (up to 500)
     */
    public void setWallet()
    {
	Random rng = new Random();
	wallet = rng.nextInt(500) + 1;

	while(wallet % 10 != 0)
	    {
		wallet = rng.nextInt(500) + 1;
	    }
    }

    /**
     *The getPref method returns the fan's preferred venue type
     *
     *@return Venue.VenueType This is the fan's preferred venue type
     */
    public Venue.VenueType getPref()
    {
	return pref;
    }

    /**
     *The getWallet method returns how much money is in a fan's wallet
     *
     *@return int This is how much money is in the fan's wallet
     */
    public int getWallet()
    {
	return wallet;
    }

    /**
     *The buyTicket method attempts to have a fan buy a ticket for an event
     */
    public boolean buyTicket()
    {
	try
	    {
		if(getWallet() > 10)
		    {
			wallet -= 10;
			return true;
		    }
		else
		    {
			throw new OutOfMoneyException();
		    }
	    }
	catch(OutOfMoneyException oome)
	    {
		System.err.println(oome.getMessage());
	    }

	return false;
    }
}