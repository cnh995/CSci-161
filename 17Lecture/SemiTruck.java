import java.util.*;
public class SemiTruck extends Transporter, Repairable
{
    private boolean flatTire = false;
    private int trailers = 1;
    private int daysToFix = 0;

    public boolean broken()
    {
	return flatTire;
    }

    public void emergency() throws BrokeDownException
    {
	Random rng = new Random();
	int i = rng.nextInt(2840) + 1;

	if(i == 1)
	    {
		gotFlat();
		daysToFix = rng.nextInt(9) + 1;
		throw new BrokeDownException("Semi truck", "a flat tire");
	    }
    }

    public int daysUntilFixed()
    {
	return daysToFix;
    }

     public Traveller.RouteType getRouteType()
     {
          return RouteType.ROAD;
     }

     public String toString()
     {
          return "This Transporter is a SemiTruck\n" + super.toString() + "\tHas " + getTrailers() + " trailers in tow.\n\tCurrently has a flat tire: \t" + getFlatTire();
     }

     public void setTrailers(int num)
     {
          if (num >= 0)
          {
               trailers = num;
          }
     }
     
     public int getTrailers()
     {
          return trailers;
     } 
     
     public void fixFlat()
     {
          flatTire = false;
     } 
     
     public void gotFlat()
     {
          flatTire = true;
     }
     
     public boolean getFlatTire()
     {
          return flatTire;
     }

     public SemiTruck(String inName, double inMax, int inSpeed, int inDist, int inTrailers)
     {
          super(inName,inMax,inSpeed,inDist);
          setTrailers(inTrailers);
     }
     
     public SemiTruck(String inName, double inMax, int inSpeed, int inDist)
     {
          super(inName,inMax,inSpeed,inDist);
     }
     
     public SemiTruck(String inName, double inMax, int inSpeed)
     {
          super(inName,inMax,inSpeed);
     }
     
     public SemiTruck(String inName, double inMax)
     {
          super(inName,inMax);
     }
     
     public SemiTruck(String inName)
     {
          super(inName);
     }
     
     public SemiTruck()
     {
          super();
     }
     
}
