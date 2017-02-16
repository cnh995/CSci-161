import java.util.Scanner; 

public class Driver
{
    public static void main(String[] args)
    {
	Grader grade = new Grader();

	System.out.println("Please enter marks: ");

	Scanner in = new Scanner(System.in);
	int marks = in.nextInt();

	System.out.println("Your grade is " + grade.getGrade(marks));
    }
}
