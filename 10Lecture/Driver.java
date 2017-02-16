import java.util.*; // Need Random
import java.io.*; //Need File IO Tools
public class Driver
{

    public static void main(String[] args) throws FileNotFoundException
    {
         //Create a link to an input file
         File portFile = new File("Ports.txt");
         File shipFile = new File("Ships.txt");
	 File cargoFile = new File("Cargo.txt");
         
         //Open input file
         Scanner inputPorts = new Scanner(portFile);
         Scanner inputShips = new Scanner(shipFile);
	 Scanner inputCargo = new Scanner(cargoFile);

         //Setup rest of reading tools and Array Lists
         ArrayList<Port> myPorts = new ArrayList<Port>();
         ArrayList<Ship> myShips = new ArrayList<Ship>();
	 ArrayList<Cargo> myCargo = new ArrayList<Cargo>();
         String line;
         String[] parts;
         

	 while(inputCargo.hasNext())
	     {
		 line = inputCargo.nextLine();
		 parts = line.split("%");
		 myCargo.add(new Cargo(parts[0], Integer.parseInt(parts[1])));
	      }

	  inputCargo.close();

         //Okay, now lets get the loop going
         //We can use Scanner's hasNext() method to let us know when we run out of data
         while(inputPorts.hasNext())
         {
              //Read line
              line = inputPorts.nextLine();
              //Split line into parts
              parts = line.split("%");
              //Store Data
              myPorts.add(new Port(parts[0], myCargo));
         }
         //Close input file, we are done with the input file
         inputPorts.close();
         
         while(inputShips.hasNext())
         {
              //Read line
              line = inputShips.nextLine();
              //Split line into parts
              parts = line.split("%");
              //Store Data
              myShips.add(new Ship(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
         }
         //Close input file, we are done with the input file
         inputShips.close();


         //Add some cargo to each port
         Random rng = new Random();
         for (Port eachPort : myPorts)
         {
              //Generate between 1 and 10 cargo objects per Port
              int objects = rng.nextInt(10);
              for (int x = 0; x <= objects; x++)
              {
                   //Generate tonnage
                   double tonnage = rng.nextDouble() * 1000;
                   
                   //Generate destination
                   //A Port's outbound cargo can't be for that same Port
                   int dest = rng.nextInt(myPorts.size());
                   while(eachPort.getName().equals(myPorts.get(dest).getName()))
                   {
                        dest = rng.nextInt(myPorts.size());
                   }
                   
                   //Generate Cargo 
                   //(will need to use full parameter constructor once you write that method)
                   Cargo temp = new Cargo(eachPort.getName(), tonnage);
                   
                   //Add Cargo to Port's Outbound load.
                   //You'll need a method in Port to do this
		   eachPort.addOutbound(temp);
              }
         }
         
         //Might want to test:
         //1) Can you see the Cargo data you saved in each Port?
         //2) Can you load Cargo from Port to Ship?  
         //  2A) What happens if tonnage would cause a problem?
         //3) Can you unload Cargo from Ship to Port? 
         //  3A) What happens if tonnage would cause a problem?  
         //  3B) If cargo isn't for the Port you are unloading at, does cargo correctly go to outbound instead of local?
         

	 //1
	 for(Port eachPort : myPorts)
	     {
		 System.out.println("Port local cargo: " + eachPort.getLocalTonnage());
	     }

	 //2

    }


}
