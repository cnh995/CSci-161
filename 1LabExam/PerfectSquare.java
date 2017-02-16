import java.util.*; //Needed for using keyboard input

/**
 * The PerfectSquare class is used to check if a given number is a Perfect Square or not.
 * A PerfectSquare is a number who's squareroot has no decimal component.
 * <br><br>
 * @author Scott Kerlin
 * @version 1.0
 * @since 2/19/2015
 */
 
public class PerfectSquare {
 
     /**
      * main accepts user input for processing.
      * <br><br>
      * main prompts the user to enter a number to check or a -1 or zero to exit.
      * Any postitive int input value should produce a message indicating if that number was a perfect square or not
      * @param args is required for main methods, but not used by this method
      */  
      public static void main(String[] args) {
           boolean keepGoing = false;
           Scanner keyboard = new Scanner(System.in);

           while (keepGoing = true)
           {
	       //Added a prompt to let the user know what to do
	       System.out.println("Enter a number to see if it is a perfect square:");
	       System.out.println("(Enter 0 or a negative number to exit)");

                int value = keyboard.nextInt();
		//Fixed this loop to check if 0 is entered
                if (value <= 0 )
                {
                     keepGoing = false;
		     break; //Added break to end the program when incorrect input is given
                }
                else
                {
                     boolean yes = false;

		     //Used to loop forever with 0 <= value, changed to x <= value
                     for (int x = 0; x <= value; x++)
                     {
			 //.equals for strings only, changed to ==
                          if ((x * x) == value)
                          {
                               yes = true;
                          }
                     }
                     
                     if (yes)
                     {
			 System.out.println("Input is a PERFECT SQUARE\n"); //Added line break to make it easier to read
                     }
                     else
                     {
			 System.out.println("Input IS NOT a perfect square\n"); //Added line break to make it easier to read
                     }
                }
           }
      }
}
 
