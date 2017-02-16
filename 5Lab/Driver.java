import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
	Month month1 = new Month();
	Month month2 = new Month(11);
	Month month3 = new Month("October");

	System.out.println("Month with no name or number given\n" + month1.toString());
	System.out.println("Month with number given\n" + month2.toString());
	System.out.println("Month with name given\n" + month3.toString());

	System.out.println("Comparing month with number given to month with name given: ");

	if(month2.compareTo(month3) > 0)
	    {
		System.out.println(month2.getMonthName() + " comes after " + month3.getMonthName());
	    }
	else if(month2.compareTo(month3) < 0)
	    {
		System.out.println(month2.getMonthName() + " comes before " + month3.getMonthName());
	    }
	else
	    {
		System.out.println(month2.getMonthName() + " and " + month3.getMonthName() + " are the same.");
	    }
    }
}
