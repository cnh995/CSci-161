import java.util.*;

/**
 *The Athlete class stores information about an athlete
 *
 *@author Christian Hansen
 */
public class Athlete
{
     //I'm using an enum as the type prefered venue.  You don't have to.  You can use a String.
     //The benifit of enum is that only valid Strings will be allowed.
     //So I don't have to check for:
     //--Bad inputs
     //--Different Capitalizations
     private Venue.VenueType fav;
     private int stam = 100;
     private int skill = 5;
     //Using an array since I want exactly 3 boxes for medals
     //0 -> Gold
     //1 -> Silver
     //2 -> Bronze
    private int[] medals = {0, 0, 0};
    private int number;
    private static int nextNum = 0;
    private int cheatRating = 0;
    private int numEndorsements = 0;

    /**
     *The getEndorsements method returns the number of endorsements the athlete has
     *
     *@return int This is how many endorsements the athlete has
     */
    public int getEndorsements()
    {
	return numEndorsements;
    }

    /**
     *The setEndorsements method sets the number of endorsements the athlete has to the given input, so long as the input is above 0
     *
     *@param inEndorsements This is the number of endorsements the athlete has
     */
    public void setEndorsements(int inEndorsements)
    {
	if(inEndorsements > 0)
	    {
		numEndorsements = inEndorsements;
	    }
    }

    /**
     *The setCheat method sets whether or not an athlete is a cheater
     *
     *@param cheater This is whether or not the athlete will cheat
     */
    public boolean setCheat(int cheater)
    {
	if(cheater == 1)
	    {
		return true;
	    }

	return false;
    }

    /**
     *The getCheat method returns the cheat rating of the athlete
     *
     *@return boolean This is whether or not the athlete is going to cheat
     */
    public boolean getCheat()
    {
	if(cheatRating >= 5)
	    {
		return true;
	    }

	return false;
    }

    /**
     *The equals method will check to see if the given athlete is the same as the current athlete
     *
     *@param other This is the other athlete being compared to
     *
     *@return boolean This is whether or not the two athletes are the same
     */
    public boolean equals(Athlete other)
    {
	if(number == other.getNumber())
	    {
		return true;
	    }

	return false;
    }

    /**
     *The compareTo method compares the skill levels of two athletes
     *
     *@param other This is the athlete being compared to
     *
     *@return int This determines which athlete has a higher skill level
     */
    public int compareTo(Athlete other)
    {
	return getSkill() - other.getSkill();
    }

    /**
     *The setNumber method sets a unique number to each athlete
     */
    public void setNumber()
    {
	number = nextNum++;
    }

    /**
     *The toString method returns a string containing information about the athlete
     */
    public String toString()
    {
	String output = "";

	output += "Athlete number: " + getNumber();
	output += "\nPreferred venue type: " + getFav();
	output += "\nStamina: " + getStam();
	output += "\nSkill: " + getSkill();

	return output;
    }

    /**
     *This constructore will take in several pieces of data and assign them to the appropriate variables
     *
     *@param inNumber This is the number of the athlete
     *@param inFav This is the favored type of venue
     *@param inStam This is how much stamina the athlete has
     *@param inSkill This is the athlete's skill level
     *@param inMedals This is an array of all the medals the athlete has won
     */
     public Athlete(Venue.VenueType inFav, int inStam, int inSkill, int cheater)
     {
	 setCheat(cheater);
          setNumber();
          setFav(inFav);
          setStam(inStam);
          setSkill(inSkill);
     }
     
    /**
     *The getNumber method returns the athlete's number
     *
     *@return int This is the number of the athlete
     */
     public int getNumber()
     {
          return number;
     }

    /**
     *The setFav method sets the athlete's preferred venue
     *
     *@param inFav This is the athlete's favored venue
     */
     public void setFav(Venue.VenueType inFav)
     {
          fav = inFav;
     }
     
    /**
     *The getFav returns the athlete's favorite type of venue
     *
     *@return Venue.VenueType This is the type of venue the athlete likes
     */
     public Venue.VenueType getFav()
     {
          return fav;
     }
     
    /**
     *The setStam method sets the athlete's stamina to the given input
     *
     *@param inStam This is the athletes's stamina
     */
     private void setStam(int inStam)
     {
          if (inStam > 100)
          {
               inStam = 100;
          }
          else if (inStam < 0)
          {
               inStam = 0;
          }
          stam = inStam;
     }
     
    /**
     *The changeStam method changes the athlete's stamina by a given amount
     *
     *@param adjust This is how much the stamina of the athlete increases by
     */
     public void changeStam(int adjust)
     {
          if (adjust + stam > 100)
          {
               System.out.println("Athlete " + getNumber() + " is at full Stamina and wasted " + (adjust + stam - 100) + " units of recovered Stamina in the process.");
               stam = 100;
          }
          else if (adjust + stam <= 0)
          {
               System.out.println("Athlete " + getNumber() + " fainted.");
               stam = 0;
          }
          else
          {
               stam += adjust;
          }
     }
     
    /**
     *The getStam method returns the amount of stamina the athlete has left
     *
     *@return int This is how much stamina the athlete has left
     */
     public int getStam()
     {
          return stam;
     }
     
    /**
     *The setSkill method sets the athlete's skill level to the given input
     *
     *@param inSkill This is the skill level of the athlete
     */
     private void setSkill(int inSkill)
     {
          if (inSkill >= 0 && inSkill <= 10)
          {
               skill = inSkill;
          }
     }
     
    /**
     *The getSkill method returns the skill level of the athlete
     *
     *@return int This is the skill level of the athlete
     */
     public int getSkill()
     {
          return skill;
     }
     
    /**
     *The setMedals method sets the medals of an athlete to the given array input
     *
     *@param inMedals This is an array of the medals the athlete has won
     */
     private void setMedals(int[] inMedals)
     {
          if (inMedals.length == 3 && inMedals[0] >= 0 && inMedals[1] >= 0 && inMedals[2] >= 0)
          {
               medals = inMedals;
          }
     }
     
    /**
     *The addMedal method adds a medal to the athlete's array of medals
     *
     *@param rank This is the placement of the athlete, and the type of medal the athlete will receive
     */
     public void addMedal(int rank)
     {
          if (rank < 4 && rank > 0)
          {
               medals[rank-1]++;
          }
     }
     
    /**
     *The getMedals method returns the array of medals the athlete has won
     *
     *@return int[] This is the array of medals won by the athlete
     */
     public int[] getMedals()
     {
          return medals;
     }
}