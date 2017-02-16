import java.io.*; //Need File IO Tools
import java.util.*;

public class Driver
{

    public static void main(String[] args) throws FileNotFoundException
    {
	Event myEvent = new Event("Weightlifting", "Civic Center", 10.1);
	Venue myVenue = new Venue("Civic Center", "Gym", 10, 1000, 100);

	//Create link to input file
	File athleteFile = new File("athlete.txt");

	//Open input file
	Scanner inputAths = new Scanner(athleteFile);

	ArrayList<Athlete> myAths = new ArrayList<Athlete>();
	String line;
	String[] parts;

	while(inputAths.hasNext())
	    {
		//Read line
		line = inputAths.nextLine();
		//Split line into parts
		parts = line.split(",");
		//Store new data
		myAths.add(new Athlete(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]))); 
	    }
	
        //Close input file
	inputAths.close();

	myEvent.setAthlete0(myAths.get(0).getNum(), myAths.get(0).getPrefType(), myAths.get(0).getStamina(), myAths.get(0).getSkill(),  myAths.get(0).getMedals());
	myEvent.setAthlete1(myAths.get(1).getNum(), myAths.get(1).getPrefType(), myAths.get(1).getStamina(), myAths.get(1).getSkill(),  myAths.get(1).getMedals());
	myEvent.setAthlete2(myAths.get(2).getNum(), myAths.get(2).getPrefType(), myAths.get(2).getStamina(), myAths.get(2).getSkill(),  myAths.get(2).getMedals());



    System.out.println("ATHLETE 1");
    System.out.println("Athlete jersey number: " + myEvent.getAthlete0().getNum());
    System.out.println("Athlete preferred event type: " + myEvent.getAthlete0().getPrefType());
    System.out.println("Athlete stamina: " + myEvent.getAthlete0().getStamina());
    System.out.println("Athlete skill: " + myEvent.getAthlete0().getSkill());
    System.out.println("Athlete medals: " + myEvent.getAthlete0().getMedals() + "\n");

    System.out.println("ATHLETE 2");
    System.out.println("Athlete jersey number: " + myEvent.getAthlete1().getNum());
    System.out.println("Athlete preferred event type: " + myEvent.getAthlete1().getPrefType());
    System.out.println("Athlete stamina: " + myEvent.getAthlete1().getStamina());
    System.out.println("Athlete skill: " + myEvent.getAthlete1().getSkill());
    System.out.println("Athlete medals: " + myEvent.getAthlete1().getMedals() + "\n");

    System.out.println("ATHLETE 3");
    System.out.println("Athlete jersey number: " + myEvent.getAthlete2().getNum());
    System.out.println("Athlete preferred event type: " + myEvent.getAthlete2().getPrefType());
    System.out.println("Athlete stamina: " + myEvent.getAthlete2().getStamina());
    System.out.println("Athlete skill: " + myEvent.getAthlete2().getSkill());
    System.out.println("Athlete medals: " + myEvent.getAthlete2().getMedals() + "\n");

    System.out.println("\n---------------------------\n");

    System.out.println("VENUE");
    System.out.println("Name: " + myVenue.getName());
    System.out.println("Type: " + myVenue.getType());
    System.out.println("Max athletes: " + myVenue.getMaxAthletes());
    System.out.println("Max fans: " + myVenue.getMaxFans());
    System.out.println("Current fans: " + myVenue.getCurrFans() + "\n");

    System.out.println("\n---------------------------\n");

    System.out.println("EVENT");
    System.out.println("Name: " + myEvent.getName());
    System.out.println("Venue: " + myEvent.getVenue());
    System.out.println("Popularity rating: " + myEvent.getPop() + "\n");

    System.out.println("\n---------------------------\n");


    if(myAths.size() < 3)
    {
	System.out.println("There are not enough athletes to run the event.");
    }
    else
    {
	System.out.println("Running event");
	myEvent.runEvent();
    }

   }

}