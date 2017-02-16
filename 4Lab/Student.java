import java.util.*;

/**
 *The Student class will set and store information about a student taking classes.
 *
 * @author Christian Hansen
 */

public class Student
{
    private String name = "";
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private int creditHours = 0;

    /**
     * This constructor will accept inputs for the student and then set the appropriate variables to those inputs.
     *
     * @param inName This is the name of the student.
     */
    public Student(String inName)
    {
	setName(inName);
    }

    /**
     * The setName method sets the name of the student to the given input.
     *
     * @param inName This is the name of the student.
     */
    public void setName(String inName)
    {
	name = inName;
    }

    /**
     * The getName method returns the name of the student.
     *
     * @return String This is the name of the student.
     */
    public String getName()
    {
	return name;
    }

    /**
     * The addCourse method will attempt to add a course to the student's course list.
     *
     * @param inCourse This course is the course that is trying to be added.
     *
     * @return boolean This is whether or not the class was able to be added.
     */
    public boolean addCourse(Course inCourse)
    {
	creditHours = 0;

	for(Course eachCourse : courseList)
	    {
		creditHours += 3;
	    }

	if(inCourse.isAvailable() == true && creditHours + 3 <= 21)
	    {
		courseList.add(inCourse);
		inCourse.setOpenSeats(inCourse.getOpenSeats() - 1);

		return true;
	    }
	else
	    {
		return false;
	    }
    }

    public int getCreditHours(Course inCourse)
    {
	return creditHours;
    }

    /**
     * The getCourseList method returns the ArrayList of courses for a given student.
     *
     * @return ArrayList<Course> This the the ArrayList of courses that the student is taking.
     */
    public ArrayList<Course> getCourseList()
    {
	return courseList;
    }

}
