import java.util.Random;

/**
 * The Course object contains information about a course, including name, class hours, and homework hours.
 *
 * @author Christian Hansen
 */

public class Course
{
    String courseName = "";
    int classHours = 0;
    int homeworkHours = 0;

    /**
     * This constructor gives default values to course name, in class hours, and homework hours.
     */
    public Course()
    {
	Random rng = new Random();
	int randClassHours = rng.nextInt(5) + 1;
	int randHomeworkHours = rng.nextInt(16) + 5;

	setName("classname");
	setClassHours(randClassHours);
	setHomeworkHours(randHomeworkHours);
    }

    /**
     * This constructor takes input of class name, in class hours, and homework hours and assigns those values to the correct variables.
     *
     * @param inName This input is the name of the course.
     * @param inClassHours This input is the number of in class hours per week.
     * @param inHomeworkHours This input is the number of hours of homework per week.
     */
    public Course(String inName, int inClassHours, int inHomeworkHours)
    {
	setName(inName);

	if(inClassHours > 0 && inClassHours < 6)
	    {	
		setClassHours(inClassHours);
	    }
	else
	    {
		setClassHours(0);
	    }

	if(inHomeworkHours > 4 && inHomeworkHours < 21)
	    {
		setHomeworkHours(inHomeworkHours);
	    }
	else
	    {
		setHomeworkHours(0);
	    }
    }

    /**
     * The setName method allows the user to set the name of the course.
     *
     * @param inName This input is the name of the course.
     */
    public void setName(String inName)
    {
	courseName = inName;
    }

    /**
     * The setClassHours method allows the user to enter the number of class hours per week.
     *
     * @param inClassHours This input is the number of in class hours per week.
     */
    public void setClassHours(int inClassHours)
    {
	classHours = inClassHours;
    }

    /**
     * The setHomeworkHours method allows the user to set the number of hours of homework perweek.
     *
     * @param inHomeworkHours This input is the number of hours of homework per week.
     */
    public void setHomeworkHours(int inHomeworkHours)
    {
	homeworkHours = inHomeworkHours;
    }

    /**
     * The getName method returns the course name.
     *
     * @return String This refers to the name of the course.
     */
    public String getName()
    {
	return courseName;
    }

    /**
     * The getClassHours method returns the number of in class hours.
     *
     * @return int This refers to the number of in class hours.
     */
    public int getClassHours()
    {
	return classHours;
    }

    /**
     * The getHomeworkHours method returns the number of homework hours.
     *
     * @return int This refers to the number of hours of homework per week.
     */
    public int getHomeworkHours()
    {
	return homeworkHours;
    }
}
