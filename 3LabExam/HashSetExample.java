import java.util.*;

public class HashSetExample 
{
    public static void main(String[] args)
    {
	Set<String> myHash = new HashSet<String>();

	String[] names = {"John", "Steve", "Bob", "Mary", "Tina"};

	System.out.println("Adding the following names to HashSet:");

	for(String name : names)
	    {
		System.out.println(name);
		myHash.add((String)name);
	    }

	System.out.println("\nHashSet size: " + myHash.size());

	System.out.println("\nIs HashSet empty? " + myHash.isEmpty());

	System.out.println("\nIs the name John in the HashSet? " + myHash.contains("John"));

	System.out.println("\nCurrent status of HashSet: " + myHash.toString());

	String[] newNames = myHash.toArray(new String[myHash.size()]);
	String removeName = newNames[newNames.length - 1];

	System.out.println("\nRemoving value from the back...");
	myHash.remove(removeName);
	System.out.println("Current status of HashSet after removing: " + myHash.toString());
	System.out.println("\nIs the name John in the HashSet now? " + myHash.contains("John"));

    }   
}
