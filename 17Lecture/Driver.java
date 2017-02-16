import java.util.*; // Need Random
import java.io.*; //Need File IO Tools
public class Driver
{
    public static void main(String[] args)
    {
         //Create a link to an input file
         File portFile = new File("Ports.txt");
         File transFile = new File("Transporters.txt");
         
         //Open input file
         Scanner inputPorts = null;
         Scanner inputPorter = null;

	 try
	     {
		 inputPorts = new Scanner(portFile);
		 inputPorter = new Scanner(transFile);
	     }

	 catch(FileNotFoundException e)
	     {
		 System.err.println("Error: ");
		 System.exit(0);
	     }

         //Setup rest of reading tools and Array Lists
         ArrayList<Port> myPorts = new ArrayList<Port>();
         ArrayList<Transporter> myPorters = new ArrayList<Transporter>();
         String line;
         String[] parts;
         
         //Okay, now lets get the loop going
         //We can use Scanner's hasNext() method to let us know when we run out of data
         while(inputPorts.hasNext())
         {
              //Read line
              line = inputPorts.nextLine();
              //Split line into parts
              parts = line.split("%");
              //Store Data
              myPorts.add(new Port(parts[0], Boolean.parseBoolean(parts[1]), Boolean.parseBoolean(parts[2]), Boolean.parseBoolean(parts[3]), Boolean.parseBoolean(parts[4])));
         }
         //Close input file, we are done with the input file
         inputPorts.close();
         
         while(inputPorter.hasNext())
         {
              //Read line
              line = inputPorter.nextLine();
              //Split line into parts
              parts = line.split("%");
              //Store Data
              if (parts[0].equals("SHIP"))
                   myPorters.add(new Ship(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
              else if (parts[0].equals("AIRPLANE"))
                   myPorters.add(new Airplane(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Boolean.parseBoolean(parts[5])));
              else if (parts[0].equals("TRAIN"))
                   myPorters.add(new Train(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
              else if (parts[0].equals("SEMITRUCK"))
                   myPorters.add(new SemiTruck(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
//              else
//                   myPorters.add(new Transporter(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));

         }
         //Close input file, we are done with the input file
         inputPorter.close();
         
         Random rng = new Random();
         
         //Setup distance map
         int[][] map = new int[myPorts.size()][myPorts.size()];
         for (int x = 0; x < map.length; x++)
         {
              for (int y = 0; y < map[x].length; y++)
              {
                   if ( x == y )
                   {
                        map[x][y] = 0;
                   }
                   else if ( x > y )
                   {
                        map[x][y] = map[y][x];
                   }
                   else
                   {
                        map[x][y] = rng.nextInt(11450) + 100;
                   }
              }
         }
         
         //Add some cargo to each port
         for (Port eachPort : myPorts)
         {
              
              
              //Generate between 1 and 10 cargo objects per Port
              int objects = rng.nextInt(10);
              for (int x = 0; x <= objects; x++)
              {
                   //Generate tonnage
                   double tonnage = rng.nextDouble() * 100; //0 and 100ish
                   
                   //Generate destination
                   //A Port's outbound cargo can't be for that same Port
                   int dest = rng.nextInt(myPorts.size());
                   while(eachPort.getName().equals(myPorts.get(dest).getName()))
                   {
                        dest = rng.nextInt(myPorts.size());
                   }
                   String target = myPorts.get(dest).getName();
                   
                   //Generate Cargo 
                   //(will need to use full parameter constructor once you write that method)
                   Cargo temp = new Cargo(target, tonnage);
                   

                   //Add Cargo to Port's Outbound load.
                   //You'll need a method in Port to do this
                   eachPort.addOutbound(temp);
              }

         }
         
         //Set transporter destinations
         for (Transporter t : myPorters)
         {
              t.setDest(myPorts.get(rng.nextInt(myPorts.size())).getName());
         }
         
         //So, I've got:
         // A List of Transporters (without cargo)
         //   and
         // A List of Ports (with cargo)
         int day = 0;
         while (!allCargoDelivered(myPorts, myPorters))
         {
              System.out.println("\n----------------------- Day" + day + " ----------------------------------\n");
              //Move porters
              for (Transporter t : myPorters)
              {
                   String output = t.travel();

                   //Process port if needed
                   if (t.getDistance() == 0)
                   {
                        for (int p = 0; p < myPorts.size(); p++)
                        {
                             if (myPorts.get(p).getName().equals(t.getDest()) && t.getDistance() == 0)
                             {
                                  //Unload
                                  boolean[] checkTypes = myPorts.get(p).getAccess();
                                  boolean hasAll = true;
                                  for (boolean b : checkTypes)
                                  {
                                       if (!b)
                                       {
                                            hasAll = false;
                                       }
                                  }
                                  
				  try
				      {
					  if (hasAll)
					      {
						  myPorts.get(p).unloadAll(t);
					      }
					  else
					      {
						  myPorts.get(p).unload(t);
					      }
				      }
				  catch(FacilitiesMismatchException e)
				      {
					  System.err.println("An unload was not performed.");
					  System.err.println(e.getMessage());
				      }
                                  
                                  //Redirect
                                  int target = 0;
                                  boolean badOption = true;
                                  while(badOption)
                                  {
                                       target = rng.nextInt(myPorts.size());
                                       if (target != p)
                                       {
                                            if ((myPorts.get(target).getMatch(t.getRouteType())) || (t instanceof Airplane && ((Airplane) t).getCanAirDrop()))
                                            {
                                                 badOption = false;
                                            }
                                            
                                       }

                                  }
                                  t.setDest(myPorts.get(target).getName());
                             
                                  
                                  //reset distance
                                  t.setDistance(map[p][target]);
                                  
                                  //Load
                                  try
				      {
					  if(hasAll)
					      {
						  myPorts.get(p).load(t,t.getDest());
					      }
					  else
					      {
						  myPorts.get(p).load(t);
					      }
				      }
				  catch(FacilitiesMismatchException e)
				      {
					  System.err.println("A load was not performed.");
					  System.err.println(e.getMessage());
				      }
                             }
                        }
                        
                   }
                   System.out.println(output);
                   System.out.println(t + "\n");


              }
              
              //Display Port info
              for (Port p : myPorts)
              {
                   System.out.println(p);
              }
              
              
              day++;
         }
         System.out.println("\nIt took " + day + " days to deliver all cargo.");
    }
    

    public static boolean allCargoDelivered(ArrayList<Port> ports, ArrayList<Transporter> porters)
    {
         for (Port p : ports)
         {
              if (p.getOutboundTonnage() > 0 && !p.getName().equals("St. Theresa Point"))
                   return false;
         }
         
         for (Transporter t : porters)
         {
              if (t.getCurrentCargoTonnage() > 0)
                   return false;
         }
         
         return true;
    }
}
