import java.util.*;

/**
 *The Event class stores certain information about an event that is being held
 *
 *@author Christian Hansen
 */
public class Event
{
     //Using an enum...You could have used a String instead
     public enum Status {SCHEDULED, ACTIVE, COMPLETED}
     
     private String name = "";
     private Venue loc;
     private double pop = 0.0;
     private ArrayList<Athlete> aths = new ArrayList<Athlete>();
     private Status status;
     private String results = "TBD";
    private Venue.VenueType type;
     

    /**
     *The toString method gives some information about the Event
     *
     *@return String This is the information about the event
     */
    public String toString()
    {
	String output = "";

	output += "Event name: " + getName();
	output += "\nEvent location: " + getLoc();
	output += "\nEvent popularity: " + getPopularity();
	output += "Number of athletes paricipating: " + aths.size();
	output += "Event status: " + getStatus();
	output += "Venue type: " + getType();

	return output;
    }

    /**
     *The setType method sets the type of event to the given input
     *
     *@param inType This is the type of event
     */
    public void setType(Venue.VenueType inType)
    {
	type = inType;
    }

    /**
     *The getType method returns the type of event
     *
     *@return Venue.VenueType This is the type of event
     */
    public Venue.VenueType getType()
    {
	return type;
    }

     //Leaving status and results out of full parameter constructor since:
     //--Status will always start as SCHEDULED
     //--Results won't be known until Event concludes
    /**
     *This constructor takes the given inputs and assigns them to appropriate variables
     *
     *@param inName This is the name of the event
     *@param inLoc This is the location of the event
     *@param inAths This is the list of athletes that will be participating
     *@param inType This is the type of event
     */
    public Event(String inName, double inPop, Venue.VenueType inType)
     {
	 setType(inType);
          setName(inName);
          setPopularity(inPop);
          status = Status.SCHEDULED;
     }
     
    /**
     *The setName method sets the name of the event to the given input
     *
     *@param inName This is the name of the event
     */
     public void setName(String inName)
     {
          name = inName;
     }
     
    /**
     *The getName method returns the name of the event
     *
     *@return String This is the name of the event
     */
     public String getName()
     {
          return name;
     }
     
    /**
     *The setLoc method sets the location of the event to the given input
     *
     *@param inLoc This is the location of the venue
     */
     public void setLoc(Venue inLoc)
     {
          loc = inLoc;
     }
     
    /**
     *The getLoc method returns the location of the event
     *
     *@return Venue This is the location of the venue
     */
     public Venue getLoc()
     {
          return loc;
     }
     
    /**
     *The setPopularity method sets the populairty to the given input
     *
     *@param inPop This is the popularity of the event
     */
     public void setPopularity(double inPop)
     {
          if (inPop >= 0.0 && inPop <= 1.0)
          {
               pop = inPop;
          }

	  pop = 0.0;
     }
     
    /**
     *The getPopularity method returns the popularity of the event
     *
     *@return double This is the populairty of the event
     */
     public double getPopularity()
     {
          return pop;
     }
     
    /**
     *The setAthList method sets the list of athletes at the event to the given ArrayList input
     *
     *@param inAths This is the ArrayList of athletes at the event
     */
     public void setAthList(ArrayList<Athlete> inAths)
     {
          if (inAths.size() <= getLoc().getMaxAths())
          {
               aths.clear();
               aths.addAll(inAths);
          }
     }
     
    /**
     *The addAthlete method adds the given athlete to the ArrayList of participants
     *
     *@param inAth This is the athlete being added to the ArrayList
     */
     public void addAthlete(Athlete inAth)
     {
          if (aths.size() + 1 <= getLoc().getMaxAths())
          {
               aths.add(inAth);
          }
     }
     
    /**
     *The removeAthlete method removes the given athlete from the ArrayList of athletes
     *
     *@param inAth This is the athlete being removed from the ArrayList
     */
     public void removeAthlete(Athlete inAth)
     {
          aths.remove(inAth);
     }
     
    /**
     *The getAthList method returns the ArrayList of athletes in the event
     *
     *@return ArrayList<Athlete> This is the ArrayList of athletes in the event
     */
     public ArrayList<Athlete> getAthList()
     {
          return aths;
     }
     
    /**
     *The advanceStatus method changes the status of the event
     */
     private void advanceStatus()
     {
          if(status == Status.SCHEDULED)
          {
               status = Status.ACTIVE;
          }
          else if (status == Status.ACTIVE)
          {
               status = Status.COMPLETED;
          }
     }
     
    /**
     *The getStatus method returns the status of the event (active, completed, etc)
     *
     *@return Status This is the status of the event
     */
     public Status getStatus()
     {
          return status;
     }
     
    /**
     *The setResults method sets the event results to the given input
     *
     *@param inResults These are the results of the event
     */
     private void setResults(String inResults)
     {
          results = inResults;
     }
     
    /**
     *The getResults method returns the event results
     *
     *@return String These are the results of the event
     */
     public String getResults()
     {
          return results;
     }
     
    /**
     *The runEvent method attempts to run the event, simulating which athlete won, how much stamina they lost, etc
     *
     *@return boolean This is whether the event has been run or not
     */ 
     public boolean runEvent()
     {
          if (aths.size() < 3)
          {
               System.out.println("CANNOT RUN EVENT! Too few athletes");
               return false;
          }
          
          //advance status
          advanceStatus();
          Random rng = new Random();
          //Clone Athlete List so I have a copy I can play with
          ArrayList<Athlete> tmp = new ArrayList<Athlete>();
          tmp.addAll(aths);
               
	  for(int i = 0; i < tmp.size(); i++)
	      {
		  if(getType() == tmp.get(i).getFav())
		      {
			  int stamChange = -(rng.nextInt(10) + 1);
			  tmp.get(i).changeStam(stamChange);
			  System.out.println("Removing " + stamChange + " Stam from athlete number " + tmp.get(i).getNumber());
		      }
		  else
		      {
			  int stamChange = -(rng.nextInt(16) + 5);
			  tmp.get(i).changeStam(stamChange);
			  System.out.println("Removing " + stamChange + " Stam from athlete number " + tmp.get(i).getNumber());
		      }

		  if(tmp.get(i).getStam() == 0)
		      {
			  tmp.remove(i);
		      }
	      }

	  int score = 0;
	  int maxScore;
	  int maxIndex;
	  int j = 0;

	  Athlete[] places = new Athlete[3];

	  while(j < 2)
	      {
		  maxScore = 0;
		  maxIndex = 0;

		  for(int i = 0; i < tmp.size(); i++)
		      {
			  if(tmp.get(i).getCheat())
			      {
				  score = rng.nextInt(16) + 5 + tmp.get(i).getSkill();
			      }
			  else
			      {
				  score = rng.nextInt(20) + 1 + tmp.get(i).getSkill();
			      }

			  if(score > maxScore)
			      {
				  maxScore = score;
				  maxIndex = i;
			      }

			  if(i == tmp.size())
			      {
				  places[j] =  tmp.get(maxIndex);
				  tmp.remove(maxIndex);
			      }
		      }

		  j++;
	      }


          setResults("Results:\n");

          setResults(getResults() + "\tGOLD:\t" + places[0].getNumber() + "\n");
          places[0].addMedal(1);

          setResults(getResults() + "\tSILVER:\t" + places[1].getNumber() + "\n");
          places[1].addMedal(2);

          setResults(getResults() + "\tBRONZE:\t" + places[2].getNumber() + "\n");
          places[2].addMedal(3);

          //advance status
          advanceStatus();
          return true;
     }
     
}