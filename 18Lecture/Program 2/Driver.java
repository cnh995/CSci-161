import java.io.*;
import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
	FileInputStream binaryInput;
	DataInputStream binaryInFile;
	String binaryMessage = "";

	try
	    {
		binaryInput = new FileInputStream("BinaryMessage.dat");
		binaryInFile = new DataInputStream(binaryInput);

	        binaryMessage = binaryInFile.readUTF();
		System.out.println("Binary mesage: " + binaryMessage);

		binaryInFile.close();
	    }
	catch(FileNotFoundException e)
	    {
		System.out.println("Error: File not found.");
	    }
	catch(IOException i)
	    {
		System.out.println("Error: Invalid input.");
	    }


	RandomAccessFile randomMessage;
	String randomCharMessage = "";
	try
	    {
		randomMessage = new RandomAccessFile("RandomCharMessage.dat", "r");
		
		for(int i = 0; i < randomMessage.length(); i+=6)
		    {
				randomMessage.seek(i);
				randomCharMessage = randomCharMessage + randomMessage.readChar();
				System.out.println(randomMessage.readChar());
		    }
		
		System.out.println("Random Access message: " + randomCharMessage);

		randomMessage.close();
	    }
	catch(FileNotFoundException e)
	    {
		System.out.println("Error: Random file not found.");
	    }
	catch(IOException i)
	    {
		System.out.println("Error: Invalid input for random file.");
	    }

	FileInputStream serializedFile;
	ObjectInputStream serializedObj;
	Message myMessage;
	String serializedMessage = "";
	try
	    {
		serializedFile = new FileInputStream("SerializedMessage.dat");
		serializedObj = new ObjectInputStream(serializedFile);

		myMessage = (Message)
		    serializedObj.readObject();

		serializedMessage = myMessage.getMSG();
		System.out.println("Serialized message: " + serializedMessage);

		serializedFile.close();
	    }
	catch(FileNotFoundException e)
	    {
		System.out.println("Error: Serialized file not found.");
	    }
	catch(IOException i)
	    {
		System.out.println("Error: Invalid input for serialized file.");
	    }
	catch(ClassNotFoundException c)
	    {
		System.out.println("Error: readObject class not found when reading serialized file.");
	    }

	System.out.println("\n");

	if(binaryMessage.equals(serializedMessage) && serializedMessage.equals(randomCharMessage))
	    {
		System.out.println("All messages match!");
	    }
    }
}
