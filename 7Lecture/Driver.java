import java.util.*; // Need Random
import java.io.*; //Contains input/output for files

public class Driver
{

    public static void main(String[] args) throws FileNotFoundException
    {
         //Create a link to an input file
         File portFile = new File("Ports.txt");
         
         //Open input file
         Scanner inputPorts = new Scanner(portFile); 
         
         //Read a line
	 String line = inputPorts.nextLine();
         
         //Break the line into its components
         String [] parts = line.split("%");
         //Index 0 = name
	 //Index 1 = outbound

         //Use the data to make the first port
         Port port1 = new Port(parts[0], Double.parseDouble(parts[1]));
         
         //Check that the input data was correctly transfered to the object
         System.out.println("Port 1:");
         System.out.println("\tName:\t" + port1.getName());
         System.out.println("\tOutbound Cargo:\t" + port1.getOutbound());
         System.out.println("\n---------------------------\n");

         //Read next line
         line = inputPorts.nextLine();
         
         //Break the line into its components
	 parts = line.split("%");
         
         //Use the data to make the first port         
         Port port2 = new Port(parts[0], Double.parseDouble(parts[1]));
         
         //Check that the input data was correctly transfered to the object
         System.out.println("Port 2:");
         System.out.println("\tName:\t" + port2.getName());
         System.out.println("\tOutbound Cargo:\t" + port2.getOutbound());
         System.out.println("\n---------------------------\n");

         //Read next line
         line = inputPorts.nextLine();
         
         //Break the line into its components
         parts = line.split("%");
         
         //Use the data to make the first port         
         Port port3 = new Port(parts[0], Double.parseDouble(parts[1]));
         
         //Check that the input data was correctly transfered to the object
         System.out.println("Port 3:");
         System.out.println("\tName:\t" + port3.getName());
         System.out.println("\tOutbound Cargo:\t" + port3.getOutbound());
         System.out.println("\n---------------------------\n");

         //Close input file
	 inputPorts.close();         

         //Your turn, deal with Ship!
         //Create a link to an input file
         File shipFile = new File("Ships.txt");
         
         //Open input file
         Scanner inputShips = new Scanner(shipFile); 
         
         //Read a line
	 line = inputShips.nextLine();
         
         //Break the line into its components
         parts = line.split("%");
         //Index 0 = name
	 //Index 1 = max cargo
	 //Index 2 = speed
	 //Index 3 = distance

         //Use the data to make the first ship
         Ship ship1 = new Ship(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
         System.out.println("Ship 1:");
         System.out.println("\tName:\t" + ship1.getName());
         System.out.println("\tMax Cargo:\t" + ship1.getMax());
         System.out.println("\tSpeed:\t" + ship1.getSpeed());
         System.out.println("\tDistance to Destination:\t" + ship1.getDistance());
         System.out.println("\n---------------------------\n");
         
         //Read next line
         line = inputShips.nextLine();
         
         //Break the line into its components
	 parts = line.split("%");

         Ship ship2 = new Ship(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
         System.out.println("Ship 2:");
         System.out.println("\tName:\t" + ship2.getName());
         System.out.println("\tMax Cargo:\t" + ship2.getMax());
         System.out.println("\tSpeed:\t" + ship2.getSpeed());
         System.out.println("\tDistance to Destination:\t" + ship2.getDistance());
         System.out.println("\n---------------------------\n");

         //Read next line
         line = inputShips.nextLine();
         
         //Break the line into its components
	 parts = line.split("%");

         Ship ship3 = new Ship(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
         System.out.println("Ship 3:");
         System.out.println("\tName:\t" + ship3.getName());
         System.out.println("\tMax Cargo:\t" + ship3.getMax());
         System.out.println("\tSpeed:\t" + ship3.getSpeed());
         System.out.println("\tDistance to Destination:\t" + ship3.getDistance());
         System.out.println("\n---------------------------\n");

         //Close input file
	 inputShips.close(); 

         
         //Write-to-File-Section
         //Create a link to an output file
         File portOutput = new File("DescriptivePorts.txt");
         
         //Open the output file
         PrintWriter outPorts = new PrintWriter(portOutput);
         
         //Write port1's data to output file
         outPorts.println("Port 1:");
         outPorts.println("\tName:\t" + port1.getName());
         outPorts.println("\tOutbound Cargo:\t" + port1.getOutbound());
         outPorts.println("\n---------------------------\n");
         
         //Write port2's data to output file
         outPorts.println("Port 2:");
         outPorts.println("\tName:\t" + port2.getName());
         outPorts.println("\tOutbound Cargo:\t" + port2.getOutbound());
         outPorts.println("\n---------------------------\n");         
         
         //Write port3's data to output file
         outPorts.println("Port 3:");
         outPorts.println("\tName:\t" + port3.getName());
         outPorts.println("\tOutbound Cargo:\t" + port3.getOutbound());
         outPorts.println("\n---------------------------\n");         
         
         //Close output file
         outPorts.close();
         
         //Your turn; write the 3 ships' data to a different output file
         //Create a link to an output file
         File shipOutput = new File("DescriptiveShips.txt");
         
         //Open the output file
         PrintWriter outShips = new PrintWriter(shipOutput);
         
         //Write ship1's data to output file
         outShips.println("Ship 1:");
         outShips.println("\tName:\t" + ship1.getName());
         outShips.println("\tMax Cargo:\t" + ship1.getMax());
         outShips.println("\tSpeed:\t" + ship1.getSpeed());
         outShips.println("\tDistance to Destination:\t" + ship1.getDistance());
         outShips.println("\n---------------------------\n");

         //Write ship2's data to output file
         outShips.println("Ship 2:");
         outShips.println("\tName:\t" + ship2.getName());
         outShips.println("\tMax Cargo:\t" + ship2.getMax());
         outShips.println("\tSpeed:\t" + ship2.getSpeed());
         outShips.println("\tDistance to Destination:\t" + ship2.getDistance());
         outShips.println("\n---------------------------\n");

         //Write ship3's data to output file
         outShips.println("Ship 3:");
         outShips.println("\tName:\t" + ship3.getName());
         outShips.println("\tMax Cargo:\t" + ship3.getMax());
         outShips.println("\tSpeed:\t" + ship3.getSpeed());
         outShips.println("\tDistance to Destination:\t" + ship3.getDistance());
         outShips.println("\n---------------------------\n");

         //Close output file
         outShips.close();
    }


}
