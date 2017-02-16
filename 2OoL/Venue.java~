/**
 *The venue class will store certain information about a Venue
 *
 *@author Christian Hansen
 */
public class Venue
{
     public enum VenueType {AQUATIC, TRACK, GYM, OUTDOOR}
     
     private String name = "";
     private VenueType type;
     private int maxA = 3;
     private int maxFans = 0;
     private int currFans = 0;
     
    /**
     *The compareTo method compares a venue to the input based on how many fans they can hold
     *
     *@return int This tells us which venue holds more fans
     */
    public int compareTo(Venue other)
    {
	return getMaxFans() - other.getMaxFans();
    }

    /**
     *The toString method returns a String containing information about the venue
     *
     *@return String This is information about the venue
     */
    public String toString()
    {
	String output = "";

	output += "Venue name: " + getName();
	output += "Venue type: " + getType();
	output += "Maximum athletes: " + getMaxAths();
	output += "Maximum fans: " + getMaxFans();

	return output;
    }

    /**
     *This constructor will set the given inputs to the appropriate variables
     *
     *@param inName This the the name of the venue
     *@param inType This is the type of the venue
     *@param inMaxA This is the maximum number of athletes that can participate
     *@param inMaxFans This is the maximum number of fans that can attend
     */
     //Venues probably don't have fans when created, so left that attribute out.
     public Venue(String inName, VenueType inType, int inMaxA, int inMaxFans)
     {
          setName(inName);
          setType(inType);
          setMaxAths(inMaxA);
          setMaxFans(inMaxFans);
     }
     
    /**
     *The setName method sets the name to the given input
     *
     *@param inName This is the venue name
     */
     public void setName(String inName)
     {
          name = inName;
     }
     
    /**
     *The getName method returns the name of the venue
     *
     *@return String This is the name of the venue
     */
     public String getName()
     {
          return name;
     }
     
    /**
     *The setType method sets the venue type to the given input
     *
     *@param inType This is the type of venue
     */
     //I suppose a venue could be remodelled, so leaving this public
     public void setType(VenueType inType)
     {
          type = inType;
     }
     
    /**
     *The getType method returns the venue type
     *
     *@return VenueType This is the venue type
     */
     public VenueType getType()
     {
          return type;
     }
     
    /**
     *The setMaxAths method sets the maximum number of athletes to the given input
     *
     *@param inMax This is the maximum number of athletes the venue can handle
     */
     public void setMaxAths(int inMax)
     {
          if (inMax >= 1)
          {
               maxA = inMax;
          }
     }
     
    /**
     *The getMaxAths method returns the maximum number of athletes the venue can handle
     *
     *@return int This is the maximum number of athletes the venue can handle
     */
     public int getMaxAths()
     {
          return maxA;
     }
     
    /**
     *The setMaxFans method sets the maximum number of fans to the given input
     *
     *@param inMax This is the maximum number of fans the venue can hold
     */
     public void setMaxFans(int inMax)
     {
          //Check that the new max won't kill off any fans currently in the Venue
          if (inMax >= currFans)
          {
               maxFans = inMax;
          }
     }
     
    /**
     *The getMaxFans method returns the maximum number of fans the venue can hold
     *
     *@return int This is the maximum number of fans the venue can hold
     */
     public int getMaxFans()
     {
          return maxFans;
     }
     
    /**
     *The changeFans method attempts to adjust the number of fans curently in the venue
     *
     *@param adjust This is the number of fans we are attempting to be added or removed
     */
     public void changeFans(int adjust)
     {
          if (currFans + adjust > maxFans)
          {
               System.out.println("Too many fans attempting to enter the Venue!");
          }
          else if (currFans + adjust < 0)
          {
               System.out.println("More fans trying to leave the Venue than were actually inside the Venue!");
          }
          else
          {
               currFans += adjust;
          }
     }
     
    /**
     *The getCurrFans method returns the current number of fans in the venue
     *
     *@return int This is the number of fans in the venue curently
     */
     public int getCurrFans()
     {
          return currFans;
     }
}