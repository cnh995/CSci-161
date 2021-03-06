import java.util.Random;

/**
 * This Course class will set and return the name of the course, how many open seats it has, and if the course is available.
 *
 * @author Christian Hansen
 */

public class Course
{
    private int openSeats = 0;
    private String name = "";

    /**
     * This constructor will accept a course name as input, and then generate a random number of open seats.
     *
     * @param inName This is the name of the course.
     */
    public Course(String inName)
    {
	Random rng = new Random();
	int open = rng.nextInt(21) + 10;

	setName(inName);
	setOpenSeats(open);
    }

    /**
     * The setOpenSeats method sets the number of open seats to the given input.
     *
     * @param inOpenSeats This input is the number of open seats.
     */
    public void setOpenSeats(int inOpenSeats)
    {
	openSeats = inOpenSeats;
    }

    /**
     * The setName method sets the name of the course to the given input.
     *
     * @param inName This input is the name of the course.
     */
    public void setName(String inName)
    {
	name = inName;
    }

    /**
     * The getOpenSeats method returns the number of open seats for the course.
     *
     * @return int This is the number of available seats.
     */
    public int getOpenSeats()
    {
	return openSeats;
    }

    /**
     * The getName method returns the name of the course.
     *
     * @return String This is the name of the course.
     */
    public String getName()
    {
	return name;
    }

    /**
     * The isAvailable method returns whether or not the course is available.
     *
     * @return boolean This is whether or not the class is open for students to join.
     */
    public boolean isAvailable()
    {
	if(openSeats > 0)
	    {
		return true;
	    }
	else
	    {
		return false;
	    }
    }
}
