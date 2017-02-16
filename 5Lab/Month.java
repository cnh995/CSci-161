import java.util.*;

public class Month
{
    int monthNumber;
    static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    //Check if two months are the same
    public boolean equals(Month other)
    {
	if(getMonthNumber() == other.getMonthNumber())
	    return true;

	return false;
    }

    //Find which month comes first
    public int compareTo(Month other)
    {
	return getMonthNumber() - other.getMonthNumber();
    }

    //Default constructor
    public Month()
    {
	setMonthNumber(1);
    }

    //Constructor accepting month number
    public Month(int num)
    {
	if(num >= 1 && num <= 12)
	    setMonthNumber(num);
	else
	    setMonthNumber(1);
    }

    //Constructor accepting month name
    public Month(String name)
    {
	for(int i = 0; i < months.length; i++)
	    {
		if(name.equals(months[i]))
		    {
			setMonthNumber(i + 1);
		    }
	    }
    }
		      
    //Set month number to input
    public void setMonthNumber(int num)
    {
	if(num >= 1 && num <= 12)
	    monthNumber = num;
    }

    //Returns month number
    public int getMonthNumber()
    {
	return monthNumber;
    }


    //Returns month name
    public String getMonthName()
    {
     	return months[getMonthNumber() - 1];
    }

    //Gives a string output of what happens
    public String toString()
    {
	String output = "Month number: " + getMonthNumber() + "\n";
	output = output + "Month name: " + getMonthName() + "\n\n";

	return output;
    }
}
