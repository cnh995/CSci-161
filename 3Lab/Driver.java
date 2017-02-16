import java.io.*;
import java.util.*;

public class Driver
{
    public static void main(String[] args) throws FileNotFoundException
    {
	ObjArray[] items = new ObjArray[4];
	File inFile = new File("data.txt");
	Scanner inputItems = new Scanner(inFile);

	int index = 0;
	String line;
	String parts[];

	while(inputItems.hasNext())
	    {
		line = inputItems.nextLine();
		parts = line.split(",");
		items[index] = new ObjArray(parts[0], Integer.parseInt(parts[1]));

		index ++;
	    }

	inputItems.close();


	System.out.println("Old file contents");
	for(int i = 0; i < items.length; i++)
	    {
		System.out.println(items[i].getName());
		System.out.println(items[i].getQuantity());
	    }

	//Updating the file
	for(int i = 0; i < items.length; i++)
	    {
		while(items[i].getQuantity() < 10)
		    {
			items[i].refill();
		    }
	    }


	System.out.println("\n");
	System.out.println("New file contents");
	for(int i = 0; i < items.length; i++)
	    {
		System.out.println(items[i].getName());
		System.out.println(items[i].getQuantity());
	    }

	//Printing output to a file
	BufferedWriter writer = null;
	    try
		{
		    writer = new BufferedWriter(new FileWriter("outdata.txt"));
		    for(int i = 0; i < items.length; i++)
			{
			    writer.write(items[i].getName() + "," + items[i].getQuantity());
			    writer.newLine();
			    writer.flush();
			}
		}
	    catch(IOException ex)
		{
		    ex.printStackTrace();
		}

    }
}
