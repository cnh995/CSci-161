/**
 * The Athlete object will store and give information about a specific athlete.
 *
 * @author Christian Hansen
 */

public class Athlete
{
    private int athNum;
    private String prefType;
    private int stamina;
    private int skill;
    private int medals;

    /**
     * This constructor will take the given inputs and assign them to the proper variables.
     *
     * @param inNum This is the athlete's number.
     * @param inPrefType This is the athlete's preferred type of event.
     * @param inStamina This is the stamina of the athlete.
     * @param inSkill This is the athlete's skill.
     * @param inMedals This is the number of medals the athlete has won.
     */
    public Athlete(int inNum, String inPrefType, int inStamina, int inSkill, int inMedals)
    {
	setNum(inNum);
	setPrefType(inPrefType);
	setStamina(inStamina);
	setSkill(inSkill);
	setMedals(inMedals);
    }

    /**
     * This setNum method will set the athlete's number to the given input.
     *
     * @param inNum This is the athlete's number.
     */
    public void setNum(int inNum)
    {
	athNum = inNum;
    }

    /**
     * This setPrefType method will set the athlete's preffered type of event.
     *
     * @param inPrefType This is the athlete's preferred type.
     */
    public void setPrefType(String inPrefType)
    {
	prefType = inPrefType;
    }

    /**
     * This setStamina method will set the athlete's stamina from 0-100.
     *
     * @param inStamina This is the athlete's stamina.
     */
    public void setStamina(int inStamina)
    {
	if(inStamina >= 0 && inStamina <= 100)
	    {
		stamina = inStamina;
	    }
	else if(inStamina < 0)
	    {
		stamina = 0;
		System.out.println("The athlete has 0 stamina and has fainted.");
	    }
	else
	    {
		stamina = 100;
		System.out.println(inStamina - 100 + " stamina has been wasted.");
	    }
    }

    /**
     * This setSkill method will set the athlete's skill level from 0-10.
     *
     * @param inSkill This is the athlete's skill level.
     */
    public void setSkill(int inSkill)
    {
	if(inSkill >= 0 && inSkill <= 10)
	    {
		skill = inSkill;
	    }
	else if(inSkill < 0)
	    {
		skill = 0;
	    }
	else
	    {
		skill = 10;
	    }
    }

    /**
     * This setMedals method will set the athlete's number of medals won.
     *
     * @param inMedals This is the number of medals the athlete has won.
     */
    public void setMedals(int inMedals)
    {
	medals = inMedals;
    }

    /**
     * This getNum method will return the athlete's number to the given input.
     *
     * @return int This is the athlete's number.
     */
    public int getNum()
    {
	return athNum;
    }

    /**
     * This getPrefType method will return the athlete's preffered type of event.
     *
     * @return String This is the athlete's preferred type.
     */
    public String getPrefType()
    {
	return prefType;
    }

    /**
     * This getStamina method will return the athlete's stamina.
     *
     * @return int This is the athlete's stamina.
     */
    public int getStamina()
    {
	return stamina;
    }

    /**
     * This getSkill method will return the athlete's skill level.
     *
     * @return int This is the athlete's skill level.
     */
    public int getSkill()
    {
	return skill;
    }

    /**
     * This getMedals method will return the athlete's number of medals won.
     *
     * @return int This is the number of medals the athlete has won.
     */
    public int getMedals()
    {
	return medals;
    }

	    
}