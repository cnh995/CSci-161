import java.util.*; // Need Random
import java.io.*; //Need File IO Tools
public class Driver
{

    public static void main(String[] args) throws FileNotFoundException
    {
         //Create a link to an input file
         File portFile = new File("Ports.txt");
         
         //Open input file
         Scanner inputPorts = new Scanner(portFile);
         
         //Hopefully, you've noticed that most of parts from here on are repeated
         //So these should be done in a loop
         //However, to do that we need a for iterating objects
         //Arrays are one solution to this problem
         //final int NUM_PORTS = 6;
         ArrayList<Port>  myPorts = new ArrayList<Port>();
         String line;
         String[] parts;
         //int index = 0;
         
         //Okay, now lets get the loop going
         //We can use Scanner's hasNext() method to let us know when we run out of data
         while(inputPorts.hasNext())
         {
              //Read line
              line = inputPorts.nextLine();
              //Split line into parts
              parts = line.split("%");
              //Store Data
              myPorts.add(new Port(parts[0], Double.parseDouble(parts[1])));
              //index++;
         }
         //Close input file, we are done with the input file
         inputPorts.close();
         
         //Okay, lets check our data on the terminal screen
         //I'll use a regular for loop for this demo
         for (int i = 0; i < myPorts.size(); i++)
         {
              System.out.println("Port " + (i+1) +":");
              System.out.println("\tName:\t" + myPorts.get(i).getName());
              System.out.println("\tOutbound Cargo:\t" + myPorts.get(i).getOutbound());
              System.out.println("\n---------------------------\n");
         }
         
         //Okay, now lets try writing to a file from each of our objects
         //First we setup our file and PrintWriter
         File portOutputFile = new File("DescriptivePorts.txt");
         PrintWriter outPorts = new PrintWriter(portOutputFile);
         
         //Now we can loop...We could use a standard for loop...
         //But we can also use an enhanced for loop instead.
         //Let's try one
         for (Port eachPort : myPorts)
         {
              outPorts.println("Port:");
              outPorts.println("\tName:\t" + eachPort.getName());
              outPorts.println("\tOutbound Cargo:\t" + eachPort.getOutbound());
              outPorts.println("\n---------------------------\n");
         }
         //Close output file
         outPorts.close();
         
         //Your turn; Handle the Ships!
         //Create a link to an input file
         File shipFile = new File("Ships.txt");
         
         //Open input file
         Scanner inputShips = new Scanner(shipFile);
         
         //Hopefully, you've noticed that most of parts from here on are repeated
         //So these should be done in a loop
         //However, to do that we need a for iterating objects
         //Arrays are one solution to this problem
         ArrayList<Ship>  myShips = new ArrayList<Ship>();

	 //Okay, now lets get the loop going
         //We can use Scanner's hasNext() method to let us know when we run out of data
         while(inputShips.hasNext())
         {
              //Read line
              line = inputShips.nextLine();
              //Split line into parts
              parts = line.split("%");
              //Store Data
              myShips.add(new Ship(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
              //index++;
         }
         //Close input file, we are done with the input file
         inputShips.close();
         
         //Okay, lets check our data on the terminal screen
         //I'll use a regular for loop for this demo
         for (int i = 0; i < myShips.size(); i++)
         {
	        System.out.println("Ship " + (i + 1) + ":");
		System.out.println("\tName:\t" + myShips.get(i).getName());
		System.out.println("\tMax Cargo:\t" + myShips.get(i).getMax());
		System.out.println("\tSpeed:\t" + myShips.get(i).getSpeed());
		System.out.println("\tDistance to Destination:\t" + myShips.get(i).getDistance());
		System.out.println("\n---------------------------\n");
	 }

	 //Create a link to an output file
	 File shipOutputFile = new File("DescriptiveShips.txt");
         
	 //Open the output file
	 PrintWriter outShips = new PrintWriter(shipOutputFile);

	 //Enhanced for loop
	 for(Ship currShip : myShips)
	     {
		 outShips.println("Ship: ");
		 outShips.println("\tName:\t" + currShip.getName());
		 outShips.println("\tMax Cargo:\t" + currShip.getMax());
		 outShips.println("\tSpeed:\t" + currShip.getSpeed());
		 outShips.println("\tDistance to Destination:\t" + currShip.getDistance());
		 outShips.println("\n---------------------------\n");
	     }

	 //Close output file
	 outShips.close();
    }


}
