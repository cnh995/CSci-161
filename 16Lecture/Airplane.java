import java.util.*;
public class Airplane extends Transporter
{
     private boolean crashed = false;
     private boolean canAirDrop = false;
     
    public Traveller.RouteType getRouteType()
    {
	return RouteType.AIR;
    }

     public String toString()
     {
          return "This Transporter is an Airplane\n" + super.toString() + "\tHas the ability to Air Drop: \t" + getCanAirDrop() + "\n\tIs currently crashed: \t" + getCrashed();
     }
     
     public void changeDropType()
     {
          canAirDrop = !canAirDrop;
     }
     
     public boolean getCanAirDrop()
     {
          return canAirDrop;
     }
     
     public void crash()
     {
          crashed = true;
     }
     
     public boolean getCrashed()
     {
          return crashed;
     } 
     
     public Airplane (String inName, double inMax, int inSpeed, int inDist, boolean inAirDrop)
     {
          super(inName,inMax,inSpeed,inDist);
          canAirDrop = inAirDrop;
          
     }
     
     public Airplane (String inName, double inMax, int inSpeed, int inDist)
     {
          super(inName,inMax,inSpeed,inDist);
          
     }
     
     public Airplane(String inName, double inMax, int inSpeed)
     {
          super(inName,inMax,inSpeed);
     }
     
     public Airplane(String inName, double inMax)
     {
          super(inName,inMax);
     }
     
     public Airplane(String inName)
     {
          super(inName);
     }
     
     public Airplane()
     {
          super();
     }
     
}
