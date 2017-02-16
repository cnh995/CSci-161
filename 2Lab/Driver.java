public class Driver
{
    public static void main(String[] args)
    {
	Course course1 = new Course("Course 1 (Proper values)", 5, 8);
	Course course2 = new Course("Course 2 (Incorrect values)", 70, 500);
	Course course3 = new Course();
	int[] homeworkArray = new int[3];
	int[] classArray = new int[3];
	int totalHomeworkHours = 0;
	int totalClassHours = 0;

	homeworkArray[0] = course1.getHomeworkHours();
	homeworkArray[1] = course2.getHomeworkHours();
	homeworkArray[2] = course3.getHomeworkHours();

	for(int i = 0; i < homeworkArray.length; i++)
	    {
		totalHomeworkHours += homeworkArray[i];
	    }

	classArray[0] = course1.getClassHours();
	classArray[1] = course2.getClassHours();
	classArray[2] = course3.getClassHours();

	for(int i = 0; i < classArray.length; i++)
	    {
		totalClassHours += classArray[i];
	    }


	//Print set for course1
	System.out.println("Class name: " + course1.getName());
	System.out.println("Course hours: " + course1.getClassHours());
	System.out.println("Homework hours: " + course1.getHomeworkHours());
	System.out.println("\n");

	//Print set for course2
	System.out.println("Class name: " + course2.getName());
	System.out.println("Course hours: " + course2.getClassHours());
	System.out.println("Homework hours: " + course2.getHomeworkHours());
	System.out.println("\n");
	
	//Print set for course3
	System.out.println("Class name: " + course3.getName());
	System.out.println("Course hours: " + course3.getClassHours());
	System.out.println("Homework hours: " + course3.getHomeworkHours());
	System.out.println("\n");

	//Print total homework hours
	System.out.println("Total homework hours: " + totalHomeworkHours);
	System.out.println("\n");

	//Print total class hours
	System.out.println("Total class hours: " + totalClassHours);
	System.out.println("\n");
    }
}
