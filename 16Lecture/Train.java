import java.util.*;
public class Train extends Transporter
{
     private boolean derailed = false;
     private int engines = 1;
     
    public Traveller.RouteType getRouteType()
    {
	return RouteType.RAIL;
    }

     public String toString()
     {
          return "This Transporter is a Train\n" + super.toString() + "\tHas " + getEngines() + " engines pulling.\n\tCurrently is derailed: \t" + getDerailed();
     }
     
     public void setEngines(int num)
     {
          if (num > 0)
          {
               engines = num;
          }
     }
     
     public int getEngines()
     {
          return engines;
     } 
     
     public void derail()
     {
          derailed = true;
     }
     
     public boolean getDerailed()
     {
          return derailed;
     }
     
     public Train(String inName, double inMax, int inSpeed, int inDist, int inEngines)
     {
          super(inName,inMax,inSpeed,inDist);
          setEngines(inEngines);
     }
     
     public Train(String inName, double inMax, int inSpeed, int inDist)
     {
          super(inName,inMax,inSpeed,inDist);
     }
     
     public Train(String inName, double inMax, int inSpeed)
     {
          super(inName,inMax,inSpeed);
     }
     
     public Train(String inName, double inMax)
     {
          super(inName,inMax);
     }
     
     public Train(String inName)
     {
          super(inName);
     }
     
     public Train()
     {
          super();
     }
     
}
