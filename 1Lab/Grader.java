/**
 * This Grader object will take an input from the user, and will return the letter grade based on the input given.
 *
 * @author Christian Hansen
 */

public class Grader
{
    String letterGrade = "Error";

    /**
     * This grade method will take marks as an input and will return the letter grade.
     *
     * @param marks This input refers to the number of marks earned by the student.
     *
     * @return String This refers to the letter grade that correlates to the marks given by the user.
     */
    public String getGrade(int marks)
    {
	if(marks >= 90)
	    letterGrade =  "A";
	else if(marks >= 80)
	    letterGrade =  "B";
	else if(marks >= 70)
	    letterGrade = "C";
	else
	    letterGrade = "F";

	return letterGrade;
    }
}
