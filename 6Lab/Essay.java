/**
 *The Essay class allows the teacher to assign an essay.
 *
 *@author Christian Hansen
 */

public class Essay extends GradedActivity
{
    int grammar;
    public int spelling;
    public int correctLength;
    public int content;
    
    /**
     *This constructor assigns the inputs to the corresponding values
     *
     *@param grammar This input is the score for the grammar in the essay.
     *@param spelling This input is the score for the spelling in the essay.
     *@param correctLength This input is the score for the essay being the correct length.
     *@param content This input is the score for the content in the essay.
     */
    public Essay(int grammar, int spelling, int correctLength, int content)
    {
    	this.grammar = grammar;
    	this.spelling = spelling;
    	this.correctLength = correctLength;
    	this.content  = content;	
    }
 
    /**
     *The setScore method sets the total score of the essay by adding together the individual scores.
     */
    public void setScore()
    {
	score = this.grammar + this.spelling + this.correctLength + this.content;
	if (score < 0 || score > 100)
	    {
		System.out.println("Sorry!! Invalid Score. You will fail because of this!!");
		score = 0;
	    }
    }
}
