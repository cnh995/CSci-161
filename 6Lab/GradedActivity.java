/**
 *The GradedActivity class contains information about graded activities.
 *
 *@author Christian Hansen
 */

public class GradedActivity
{
    protected int score;

    /**
     *The setScore method will set the score of the activity to the given input.
     *
     *@param s This input is the score of the activity.
     *
     *@exception InvalidScoreException This occurrs when a score is outside of the acceptable range.
     */
    public void setScore(int s)
    {
	try
	{
	    if(score >= 100 || score <= 0)
		{
	    throw new InvalidScoreException("Score is invalid.");
		}
	    else {
		score=s;
	    }
	}
	catch(InvalidScoreException ex)
	{
	     System.out.println("Sorry!! Invalid Score. You will fail because of this!!");
	     score = 0;
	}		
    }
    
    /**
     *The getScore method will return the score of the activity.
     *
     *@return int This integer is score of the activity.
     */
    public int getScore()
    {
	return score;
    }
    
    /**
     *The getGrade method will return the letter grade of the activity.
     *
     *@return char This character is the letter grade of the activity.
     */
    public char getGrade()
    {
	char letterGrade;
	if(score>=90)
		letterGrade='A';
	else if (score >=80)
		letterGrade='B';
	else if (score >=70)
		letterGrade='C';
	else if (score >=60)
		letterGrade='D';
	else
		letterGrade='F';

	return letterGrade;
    }
}
