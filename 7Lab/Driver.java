import java.io.*;
import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
	System.out.println("Enter a series of single digit numbers");
	System.out.println("Numbers can be separated by comma (1,2,3) or by nothing (123):");

	Scanner keyboardInput = new Scanner(System.in);
	String line = keyboardInput.nextLine();
	char [] numbers = line.toCharArray();
	ArrayList<Integer> numberList = new ArrayList<Integer>();
	int total = 0;
	int max = 0;
	int min = 1000000000;

	System.out.println("\n\nIndividual numbers:");

	for(int i = 0; i < numbers.length; i++)
	    {
		if(numbers[i] != (','))
		    {
			numberList.add(Character.getNumericValue(numbers[i]));

		    }
	    }

	for(int i = 0; i < numberList.size(); i++)
	    {
		System.out.println(numberList.get(i));

		total += numberList.get(i);

		if(numberList.get(i) < min)
		    {
			min = numberList.get(i);
		    }

		if(numberList.get(i) > max)
		    {
			max = numberList.get(i);
		    }
	    }

	System.out.println("\nThe final sum is: " + total);
	System.out.println("Highest: " + max);
	System.out.println("Lowest: " + min);
    }
}
