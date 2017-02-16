import java.util.*; // Need Random
import java.io.*; //Need File IO Tools

public class Driver
{

    public static void main(String[] args) throws FileNotFoundException
    {
         //Create a link to an input file
         File portFile = new File("Ports.txt");
         File shipFile = new File("Ships.txt");
         
         //Open input file
         Scanner inputPorts = new Scanner(portFile);
         Scanner inputShips = new Scanner(shipFile);

         //Setup rest of reading tools and Array Lists
         ArrayList<Transporter> myPorters = new ArrayList<Transporter>();
         String line;
         String[] parts;
         
         //Okay, now lets get the loop going
         //We can use Scanner's hasNext() method to let us know when we run out of data
         //while(inputPorts.hasNext())
         //{
              //Read line
	 //    line = inputPorts.nextLine();
              //Split line into parts
         //     parts = line.split("%");
              //Store Data
	 //   myPorters.add(new Port(parts[0]));
         //}
         //Close input file, we are done with the input file
         inputPorts.close();
         
         while(inputShips.hasNext())
         {
              //Read line
              line = inputShips.nextLine();
              //Split line into parts
              parts = line.split("%");
              //Store Data
	      if(parts[0].equals("SHIP"))
		  {
		      myPorters.add(new Ship(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
		  }
	      else if(parts[0].equals("AIRPLANE"))
		  {
		      myPorters.add(new Airplane(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Boolean.parseBoolean(parts[5])));
		  }

         }
         //Close input file, we are done with the input file
         inputShips.close();

         //Add some cargo to each port
         Random rng = new Random();
         for (Transporter eachPorter : myPorters)
         {
              //Generate between 1 and 10 cargo objects per Port
              int objects = rng.nextInt(10);
              for (int x = 0; x <= objects; x++)
              {
                   //Generate tonnage
                   double tonnage = rng.nextDouble() * 100; //0 and 100ish
                   
                   //Generate destination
                   //A Port's outbound cargo can't be for that same Port
                   int dest = rng.nextInt(myPorters.size());
                   while(eachPorter.getName().equals(myPorters.get(dest).getName()))
                   {
                        dest = rng.nextInt(myPorters.size());
                   }
                   String target = myPorters.get(dest).getName();
                   
                   //Generate Cargo 
                   //(will need to use full parameter constructor once you write that method)
                   Cargo temp = new Cargo(target, tonnage);
                   

                   //Add Cargo to Port's Outbound load.
                   //You'll need a method in Port to do this
                   eachPorter.load(temp);
              }

         }
         
         //So, I've got:
         // A List of Ships (without cargo)
         //   and
         // A List of Ports (with cargo)
         
	 /*
         //Testing out New Transporters
         Airplane a = new Airplane("FLY BOY", 100.10, 123, 345, true);
         System.out.println(a);
         SemiTruck t = new SemiTruck("Long Hauler", 100.10, 123, 345, 2);
         System.out.println(t);
         Ship s = new Ship("Water Hog", 100.10, 123, 345);
         System.out.println(s);
         Train r = new Train("Iron Line", 100.10, 123, 345, 2);
         System.out.println(r);
	 */

	 for(Transporter t : myPorters)
	     {
		 //((Airplane)t).crash(); Check before setting
		 if(t instanceof Airplane)
		     {
			 ((Airplane)t).crash();
		     }

		 System.out.println(t);
	     }
         
    }


}
