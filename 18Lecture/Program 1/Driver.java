import java.io.*;
import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
	String binaryMessage = "";
	String randomCharMessage = "";
	String serializedMessage = "";
	char[] charArray;

	FileOutputStream binaryOutFile;
	RandomAccessFile randomCharOutFile;
	FileOutputStream serializedOutFile;

	DataOutputStream outBinary;
	ObjectOutputStream outSerialized;

	try
	    {
		binaryOutFile = new FileOutputStream("BinaryMessage.dat");
		randomCharOutFile = new RandomAccessFile("RandomCharMessage.dat", "rw");
		serializedOutFile = new FileOutputStream("SerializedMessage.dat");

		outBinary = new DataOutputStream(binaryOutFile);
		outSerialized = new ObjectOutputStream(serializedOutFile);

		Scanner keyboardInput = new Scanner(System.in);
		System.out.println("Enter a message to be encrypted:");
		String messageInput = keyboardInput.nextLine();
		Message myMessage = new Message(messageInput);

		outBinary.writeUTF(myMessage.getMSG());
		outBinary.close();

		charArray = myMessage.getMSG().toCharArray();

		for(int i = 0; i < charArray.length; i++)
		    {
			randomCharMessage = randomCharMessage + charArray[i] + "c" + "f";
		    }

		randomCharOutFile.writeUTF(randomCharMessage);
		randomCharOutFile.close();

		outSerialized.writeObject(myMessage);
		outSerialized.close();
	    }
	catch(FileNotFoundException e)
	    {
		System.out.println("Error: File not found.");
	    }
	catch(IOException i)
	    {
		System.out.println("Error: Invalid input.");
	    }
    }
}
