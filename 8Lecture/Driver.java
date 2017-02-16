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
         
	 String line;
	 String parts[];
	 final int NUM_PORTS = 6;
	 Port[] myPorts = new Port[NUM_PORTS];
	 int index = 0;

	 //Loop
	 while(inputPorts.hasNext())
	     {
		 line = inputPorts.nextLine();
		 parts = line.split("%");
		 myPorts[index] = new Port(parts[0], Double.parseDouble(parts[1])); //Index 0 has first part (which is name); Index 1 has Outbound, which needs to be converted to a double
		 
		 index++;
	     }
         
         //Close input file
         inputPorts.close();

         //Check that the input data was correctly transfered to the object
	 //Going through the array with a for loop
	 for(int i = 0; i < NUM_PORTS; i++)
	     {
		 System.out.println("Port " + (i + 1)  + ":");
		 System.out.println("\tName:\t" + myPorts[i].getName());
		 System.out.println("\tOutbound Cargo:\t" + myPorts[i].getOutbound());
		 System.out.println("\n---------------------------\n");
	     }
         
	 //Create a link to ship file
	 File shipFile = new File("Ships.txt");
	 //Open input file
	 Scanner inputShips = new Scanner(shipFile);

	 final int NUM_SHIPS = 6;
	 Ship [] myShips = new Ship[NUM_SHIPS];

	 index = 0;

	 while(inputShips.hasNext())
	     {
		 line = inputShips. nextLine();
		 parts = line.split("%");
		 myShips[index] = new Ship(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));

		 index++;
	     }

	 for(int i = 0; i < NUM_SHIPS; i++)
	     {
		 //Your turn, deal with Ship!
		 System.out.println("Ship " + (i + 1) + ":");
		 System.out.println("\tName:\t" + myShips[i].getName());
		 System.out.println("\tMax Cargo:\t" + myShips[i].getMax());
		 System.out.println("\tSpeed:\t" + myShips[i].getSpeed());
		 System.out.println("\tDistance to Destination:\t" + myShips[i].getDistance());
		 System.out.println("\n---------------------------\n");
	     }

	 inputShips.close();
         
         //Write-to-File-Section
         //Create a link to an output file
         File portOutputFile = new File("DescriptivePorts.txt");
         
         //Open the output file
         PrintWriter outPorts = new PrintWriter(portOutputFile);
         
	 //Loop this now
	 //Enhanced for loop
	 for(Port currPort : myPorts)
	     {
		 outPorts.println("Port: ");
		 outPorts.println("\tName:\t" + currPort.getName());
		 outPorts.println("\tOutbound Cargo:\t" + currPort.getOutbound());
		 outPorts.println("\n---------------------------\n");
	     }
         
         //Close output file
         outPorts.close();
         
         //Your turn; write the 3 ships' data to a different output file
	 //Create a link to an output file
	 File shipOutputFile = new File("DescriptiveShips.txt");
         
	 //Open the output file
	 PrintWriter outShips = new PrintWriter(shipOutputFile);

	 //Enhanced for loop
	 for(Ship currShip : myShips)
	     {
		 outShips.println("Ship 1:");
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
