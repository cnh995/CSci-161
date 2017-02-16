/**
 * The Venue object will store and give information about a specific venue.
 *
 * @author Christian Hansen
 */

public class Venue
{
    private String name = "";
    private String type = "";
    private int maxAthletes;
    private int maxFans;
    private int currFans;

    /**
     * This constructor will take inputs about a venue and assign them to the correct variables.
     *
     * @param inName This is the name of the venue.
     * @param inType This is the type of venue.
     * @param inMaxAthletes This input is the maximum number of athletes who can participate at once.
     * @param inMaxFans This input is the maximum number of fans who can attend.
     * @param inCurrFans This input is the nubmer of fans currently attending.
     */
    public Venue(String inName, String inType, int inMaxAthletes, int inMaxFans, int inCurrFans)
    {
	setName(inName);
	setType(inType);
	setMaxAthletes(inMaxAthletes);
	setMaxFans(inMaxFans);
	setCurrFans(inCurrFans);
    }

    /**
     * This setName method sets the name of the venue to the given input.
     *
     * @param inName This input is the name of the venue.
     */
    public void setName(String inName)
    {
	name = inName;
    }

    /**
     * This setType method sets the type of venue (Aquatic, Track, Gym, Outdoor)
     * 
     * @param inType This input is the type of venue.
     */
    public void setType(String inType)
    {
	type = inType;
    }

    /**
     * This setMaxAthletes method will set the maximum number of athletes who can participate in an event at this venue.
     *
     * @param inMaxAthletes This input is the maximum number of athletes who can participate at this venue.
     */
    public void setMaxAthletes(int inMaxAthletes)
    {
	maxAthletes = inMaxAthletes;
    }

    /**
     * This setMaxFans method will set the maximum number of fans who can fit into the venue
     *
     * @param inMaxFans This input is the maximum number of fans who can fit into the venue.
     */
    public void setMaxFans(int inMaxFans)
    {
	maxFans = inMaxFans;
    }

    /**
     * This setCurrFans method will set the current number of fans in the venue
     *
     * @param inCurrFans This input is the current number of fans in the venue.
     */
    public void setCurrFans(int inCurrFans)
    {
	currFans = inCurrFans;
    }

    /**
     * This getName method returns the name of the venue.
     *
     * @return String This is the name of the venue.
     */
    public String getName()
    {
	return name;
    }

    /**
     * This getType method returns the type of venue.
     * 
     * @return String This is the type of venue.
     */
    public String getType()
    {
	return type;
    }

    /**
     * This getMaxAthletes method will return the maximum number of athletes who can participate in an event at this venue.
     *
     * @return int This is the maximum number of athletes who can participate at this venue.
     */
    public int getMaxAthletes()
    {
	return maxAthletes;
    }

    /**
     * This getMaxFans method will return the maximum number of fans who can fit into the venue
     *
     * @return int This is the maximum number of fans who can fit into the venue.
     */
    public int getMaxFans()
    {
	return maxFans;
    }

    /**
     * This getCurrFans method will return the current number of fans in the venue
     *
     * @return int This is the current number of fans in the venue.
     */
    public int getCurrFans()
    {
	return currFans;
    }
}