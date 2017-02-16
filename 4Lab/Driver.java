import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
	Random rng = new Random();
	ArrayList<Course> courseList = new ArrayList<Course>();
	ArrayList<Student> studentList = new ArrayList<Student>();

	studentList.add(new Student("Bob"));
	studentList.add(new Student("Steve"));
	studentList.add(new Student("Joe"));

	for(int i = 0; i < 20; i++)
	    {
		courseList.add(new Course("Class " + (i + 1)));
	    }

	for(Student eachStudent : studentList)
	    {
		boolean add = true;
		int index = 0;
		
		while(add && eachStudent.getCreditHours(courseList.get(index)) <= 21)
		    {
			add = eachStudent.addCourse(courseList.get(index));
			index++;
		    }

	        System.out.println("\nStudent name: " + eachStudent.getName());
		for(int i = 0; i < eachStudent.getCourseList().size(); i++)
		    {
			System.out.println(eachStudent.getCourseList().get(i).getName());
		    }
	    }
    }
}
