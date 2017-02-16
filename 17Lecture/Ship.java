import java.util.*;
public class Ship extends Transporter
{
     private boolean isSunk = false;
      
    public boolean broken()
    {
	return isSunk;
    }

    public void emergency() throws BrokeDownException
    {
	Random rng = new Random();
	int i = rng.nextInt(1000000) + 1;

	if(i == 1)
	    {
		sink();
		throw new BrokeDownException("Ship", "sunk");
	    }
    }

     public Traveller.RouteType getRouteType()
     {
          return RouteType.WATER;
     }
     
     public String toString()
     {
          return "This Transporter is a Ship\n" + super.toString() + "\tCurrently is sunk: \t" + getSunk();
     }
     
     public void sink()
     {
          isSunk = true;
     }
     
     public boolean getSunk()
     {
          return isSunk;
     } 
     
     public Ship(String inName, double inMax, int inSpeed, int inDist)
     {
          super(inName,inMax,inSpeed,inDist);
     }
     
     public Ship(String inName, double inMax, int inSpeed)
     {
          super(inName,inMax,inSpeed);
     }
     
     public Ship(String inName, double inMax)
     {
          super(inName,inMax);
     }
     
     public Ship(String inName)
     {
          super(inName);
     }
     
     public Ship()
     {
          super();
     }
     
}
