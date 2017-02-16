import java.util.*;

/**
 * The Event object will store and give information about a specific event.
 *
 * @author Christian Hansen
 */

public class Event
{
    private String name;
    private String venue;
    private double popularity;
    private String hasOccurred = "No";
    private String position = "TBD";
    Random rng = new Random();
    final int NUM_ATHLETES = 3;

    Athlete[] myAths = new Athlete[NUM_ATHLETES];

    /**
     * This constructor will assign the given inputs to their respective variables.
     *
     * @param inName This input is the name of the event.
     * @param inVenue This input is the venue where the event is taking place.
     * @param inPop This input is the popularity rating of the event.
     */
    public Event(String inName, String inVenue, double inPop)
    {
	setName(inName);
	setVenue(inVenue);
	setPop(inPop);
    }

    /**
     * This setName method will set the name of the event to the input given.
     *
     * @param inName This input is the name of the event.
     */
    public void setName(String inName)
    {
	name = inName;
    }

    /**
     * This setVenue method will set the venue the given input.
     *
     * @param inVenue This input is the venue where the event is taking place.
     */
    public void setVenue(String inVenue)
    {
	venue = inVenue;
    }

    /**
     * This setPop method will set the popularity rating to the given input.
     *
     * @param inPop This input is the popularity rating given to this event.
     */
    public void setPop(double inPop)
    {
	popularity = inPop;
    }

    /**
     * This setAthlete1 method sets up the first athlete who will be competing.
     *
     * @param inNum This input is the athlete's number.
     * @param inPrefType This input is the athlete's preferred event type.
     * @param inStamina This input is the athlete's stamina.
     * @param inSkill This input is the skill level of the athlete.
     * @param inMedals This input is the number of medals the athlete has won.
     */
    public void setAthlete0(int inNum, String inPrefType, int inStamina, int inSkill, int inMedals)
    {
	myAths[0] = new Athlete(inNum, inPrefType, inStamina, inSkill, inMedals);
    }

    /**
     * This setAthlete2 method sets up the first athlete who will be competing.
     *
     * @param inNum This input is the athlete's number.
     * @param inPrefType This input is the athlete's preferred event type.
     * @param inStamina This input is the athlete's stamina.
     * @param inSkill This input is the skill level of the athlete.
     * @param inMedals This input is the number of medals the athlete has won.
     */
    public void setAthlete1(int inNum, String inPrefType, int inStamina, int inSkill, int inMedals)
    {
	myAths[1] = new Athlete(inNum, inPrefType, inStamina, inSkill, inMedals);
    }

    /**
     * This setAthlete3 method sets up the first athlete who will be competing.
     *
     * @param inNum This input is the athlete's number.
     * @param inPrefType This input is the athlete's preferred event type.
     * @param inStamina This input is the athlete's stamina.
     * @param inSkill This input is the skill level of the athlete.
     * @param inMedals This input is the number of medals the athlete has won.
     */
    public void setAthlete2(int inNum, String inPrefType, int inStamina, int inSkill, int inMedals)
    {
	myAths[2] = new Athlete(inNum, inPrefType, inStamina, inSkill, inMedals);
    }

    /**
     * This getName method will return the name of the event.
     *
     * @return String This is the name of the current event.
     */
    public String getName()
    {
	return name;
    }

    /**
     * This getVenue method will return the name of the venue at which the event is taking place.
     *
     * @return String This is the name of the venue.
     */
    public String getVenue()
    {
	return venue;
    }

    /**
     * This getPop method will return the population of the event.
     *
     * @return double This is the popularity rating of the event.
     */
    public double getPop()
    {
	return popularity;
    }

    /**
     * This getAthlete1 method will return information about Athlete1.
     *
     * @return Athlete This is the information for athlete1.
     */
    public Athlete getAthlete0()
    {
	return myAths[0];
    }

    /**
     * This getAthlete2 method will return information about Athlete2.
     *
     * @return Athlete This is the information for athlete2.
     */
    public Athlete getAthlete1()
    {
	return myAths[1];
    }

    /**
     * This getAthlete2 method will return information about Athlete3.
     *
     * @return Athlete This is the information for athlete3.
     */
    public Athlete getAthlete2()
    {
	return myAths[2];
    }

    /**
     * This runEvent method will simulate the running of the event.
     */
    public void runEvent()
    {
	hasOccurred = "Event in progress";
	System.out.println(hasOccurred);

	int finisher;
	
	finisher = rng.nextInt(6);

	if(finisher == 0)
	    {
		position = "Athlete 1 - First, Athlete 2 - Second, Athlete 3 - Third";
	    }
	else if(finisher == 1)
	    {
		position = "Athlete 1 - First, Athlete 3 - Second, Athlete 2 - Third";
	    }
	else if(finisher == 2)
	    {
		position = "Athlete 2 - First, Athlete 1 - Second, Athlete 3 - Third";
	    }
	else if(finisher == 3)
	    {
		position = "Athlete 2 - First, Athlete 3 - Second, Athlete 1 - Third";
	    }
	else if(finisher == 4)
	    {
		position = "Athlete 3 - First, Athlete 1 - Second, Athlete 2 - Third";
	    }
	else if(finisher == 5)
	    {
		position = "Athlete 3 - First, Athlete 2 - Second, Athlete 1 - Third";
	    }

	hasOccurred = "Event finished";
	System.out.println(hasOccurred + "\n");
	System.out.println("Results: " + position);
    }
}