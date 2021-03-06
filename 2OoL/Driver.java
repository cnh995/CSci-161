import java.io.*;
import java.util.*;
public class Driver
{

     public static int[] convertMedals(int value)
     {
          //Making some assumptions that rather than medals being a total number
          //  that medals are recorded in GGSSBB format
          //Given that no one has one triple digit medals of a type, this _might_ be reasonable?
          int[] output = new int[3];
          if (value > 0 && value < 1000000)
          {
               for (int x = 2; x >= 0; x--)
               {
                    output[x] = value % 100;
                    value = value / 100;
               }
          }
          return output;
     }

     public static void main(String[] args) throws FileNotFoundException
    {
         File athFile = new File("Athlete.txt");
         Scanner readAth = new Scanner(athFile);
         ArrayList<Athlete> ath = new ArrayList<Athlete>();
         String line;
         String[] parts;
         
         while(readAth.hasNext())
         {
              line = readAth.nextLine();
              parts = line.split(",");
              ath.add(new Athlete(Venue.VenueType.valueOf(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
         }
         readAth.close();
         
	 File eventFile = new File("Event.txt");
	 Scanner readEvent = new Scanner(eventFile);
	 ArrayList<Event> eventsList = new ArrayList<Event>();

	 while(readEvent.hasNext())
	     {
		 line = readEvent.nextLine();
		 parts = line.split(",");
		 eventsList.add(new Event(parts[0], Double.parseDouble(parts[1]), Venue.VenueType.valueOf(parts[2])));
	     }
	 readEvent.close();

	 File venueFile = new File("Venue.txt");
	 Scanner readVenue = new Scanner(venueFile);
	 ArrayList<Venue> venueList = new ArrayList<Venue>();
	 while(readVenue.hasNext())
	     {
		 line = readEvent.nextLine();
		 parts = line.split(",");
		 venueList.add(new Venue(parts[0], Venue.VenueType.valueOf(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
	     }
	 readVenue.close();

	 ArrayList<Fan> fanList = new ArrayList<Fan>();
	 for(int i = 1; i <= 100000; i++)
	     {
		 fanList.add(new Fan());
	     }

	 System.out.println("************ WELCOME TO THE OLYMPICS ************\n\n");

         System.out.println("TESTING ATHELETES");
          for (Athlete a : ath)
          {
               System.out.println("ATHLETE " + a.getNumber() + ":");
               System.out.println("\tFavourite Venue:\t" + a.getFav());
               System.out.println("\tCurrent Stamina:\t" + a.getStam());
               System.out.println("\t\tAdding 10 Stam");
               a.changeStam(10);
               System.out.println("\tCurrent Stamina:\t" + a.getStam());
               System.out.println("\tSkill:\t" + a.getSkill());
               System.out.println("\tGold Medals:\t" + a.getMedals()[0]);
               System.out.println("\tSilver Medals:\t" + a.getMedals()[1]);
               System.out.println("\tBronze Medals:\t" + a.getMedals()[2]);
               System.out.println("-------------------\n");
          }
          
	  for(Event eachEvent : eventsList)
	      {

		  Random rng = new Random();
		  int randomVenue = rng.nextInt(venueList.size());

		  Venue v = venueList.get(randomVenue);

		  while(venueList.get(randomVenue).getType() != eachEvent.getType());
		  {
		      randomVenue = rng.nextInt(venueList.size());
		      v = venueList.get(randomVenue);
		  }

		  for(Fan eachFan : fanList)
		      {
			  if(eachFan.getPref() == eachEvent.getType())
			      {
				  int randTicketBuy = rng.nextInt(((int)eachEvent.getPopularity()));
				  if(randTicketBuy == 0)
				      {
					  if(eachFan.buyTicket())
					      {
						  v.changeFans(1);
					      }
				      }
			      }
			  if(eachFan.getPref() != eachEvent.getType())
			      {
				  double randTicketBuy = rng.nextDouble() * 2;
				  if(randTicketBuy == 0)
				      {
					  if(eachFan.buyTicket())
					      {
						  v.changeFans(1);
					      }
				      }
			      }
		      }

		  System.out.println("TESTING VENUE:");
		  System.out.println("\tName:\t" + v.getName());
		  System.out.println("\tType:\t" + v.getType());
		  System.out.println("\tMax Athletes:\t" + v.getMaxAths());
		  System.out.println("\tMax Fans:\t" + v.getMaxFans());
		  System.out.println("\tCurrent Fans:\t" + v.getCurrFans());
		  System.out.println("\t\tAdding Some Fans");
		  v.changeFans(100000);
		  System.out.println("\tMax Fans:\t" + v.getMaxFans());
		  System.out.println("\tCurrent Fans:\t" + v.getCurrFans());
		  System.out.println("\t\tTrying to shrink max");
		  v.setMaxFans(1000);
		  System.out.println("\tMax Fans:\t" + v.getMaxFans());
		  System.out.println("\tCurrent Fans:\t" + v.getCurrFans());
		  System.out.println("\t\tTrying to shrink max legally");
		  v.setMaxFans(100001);
		  System.out.println("\tMax Fans:\t" + v.getMaxFans());
		  System.out.println("\tCurrent Fans:\t" + v.getCurrFans());
		  System.out.println("\t\tTrying to let in too many fans");
		  v.changeFans(20);
		  System.out.println("\tMax Fans:\t" + v.getMaxFans());
		  System.out.println("\tCurrent Fans:\t" + v.getCurrFans());
		  System.out.println("\t\tTrying to let too many out");
		  v.changeFans(-123456);
		  System.out.println("\tMax Fans:\t" + v.getMaxFans());
		  System.out.println("\tCurrent Fans:\t" + v.getCurrFans());
		  System.out.println("\t\tTrying to let a few out");
		  v.changeFans(-1234);
		  System.out.println("\tMax Fans:\t" + v.getMaxFans());
		  System.out.println("\tCurrent Fans:\t" + v.getCurrFans());
		  System.out.println("-------------------\n");
		  
		  System.out.println("TESTING EVENT:");
		  System.out.println("\tName:\t" + eachEvent.getName());
		  System.out.println("\tVenue:\t" + eachEvent.getLoc().getName());
		  System.out.println("\tPopularity:\t" + eachEvent.getPopularity());
		  System.out.println("\tAthletes:");
		  for (Athlete a : eachEvent.getAthList())
		      {
			  System.out.println("\t\t" + a.getNumber());
		      }
		  System.out.println("\tStatus:\t" + eachEvent.getStatus());
		  System.out.println("\tResults:\t" + eachEvent.getResults());
		  System.out.println("\t\tRemoving an Athlete:");
		  eachEvent.removeAthlete(ath.get(0));
		  System.out.println("\tAthletes:");
		  for (Athlete a : eachEvent.getAthList())
		      {
			  System.out.println("\t\t" + a.getNumber());
		      }
		  System.out.println("\t\tTry Running Event:");
		  eachEvent.runEvent();
		  System.out.println("\t\tAdding Athelete back in:");
		  eachEvent.addAthlete(ath.get(0));
		  System.out.println("\tAthletes:");
		  for (Athlete a : eachEvent.getAthList())
		      {
			  System.out.println("\t\t" + a.getNumber());
		      }
		  System.out.println("\t\tTry Running Event:");
		  eachEvent.runEvent();
		  System.out.println("\tStatus:\t" + eachEvent.getStatus());
		  System.out.println("\tResults:\t" + eachEvent.getResults());
		  System.out.println("\tAthletes:");
		  for (Athlete a : eachEvent.getAthList())
		      {
			  System.out.println("\t\t" + a.getNumber());
			  System.out.println("\tGold Medals:\t" + a.getMedals()[0]);
			  System.out.println("\tSilver Medals:\t" + a.getMedals()[1]);
			  System.out.println("\tBronze Medals:\t" + a.getMedals()[2]);
		      }
	      }
          System.out.println("-------------------\n");
    }


}