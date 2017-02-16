import java.util.*;
public class Port
{
    private String name = ""; //Order by name
    private ArrayList<Cargo> local = new ArrayList<Cargo>(); //Local Cargo
    private ArrayList<Cargo> outbound = new ArrayList<Cargo>(); //Outbound Cargo
    private Random gen = new Random();
    private int myID; //equals()
    private static int nextID = 0;
    private boolean[] access = {false, false, false, false}; //0-Harbour//1-Airport//2-TrainDepot//3-TruckYard
    
    public boolean getMatch(Traveller.RouteType input)
    {
         if (input == Traveller.RouteType.WATER && access[0])
         {
              return true;
         }
         else if (input == Traveller.RouteType.AIR && access[1])
         {
              return true;
         }
         else if (input == Traveller.RouteType.RAIL && access[2])
         {
              return true;
         }
         else if (input == Traveller.RouteType.ROAD && access[3])
         {
              return true;
         }
         return false;
    }
     
    public boolean[] getAccess()
    {
         return access;
    }
    
    public boolean equals(Port other)
     {
          if (getID() == other.getID())
               return true;
          return false;
     }
     
     public int compareTo(Port other)
     {
          return getName().compareTo(other.getName()); 
     }
     
    public Port(String inName, boolean inHarbour, boolean inAirport, boolean inDepot, boolean inYard)
    {
         setName(inName);
         access[0] = inHarbour;
         access[1] = inAirport;
         access[2] = inDepot;
         access[3] = inYard;
         setID();
    }
    
    public Port()
    {
         setID();
    }
    
    private void setID()
    {
         myID = nextID++;
    }
    
    public int getID()
    {
         return myID;
    }
    
    public String toString()
    {
         String output = "";
         output = "This is " +getName()+ ":\n";
         output = output + "\tPort Number: " + getID() + "\n*****LOCAL CARGO*********\n";
         for (Cargo unit : local)
         {
              output = output + unit;
         }
         output = output + "*****END LOCAL CARGO*********\n\tTotal Tonnage of Local Cargo: " + getLocalTonnage() + "\n*****OUTBOUND CARGO*********\n";
         for (Cargo unit : outbound)
         {
              output = output + unit;
         }
         output = output + "*****END OUTBOUND CARGO*********\n\tTotal Tonnage of Outbound Cargo: " + getOutboundTonnage() + "\n";
         return output;
    }
    
    public ArrayList<Cargo> getLocal()
    {
         return local; 
    }

    public ArrayList<Cargo> getOutbound()
    {
         return outbound; 
    }

    public String getName()
    {
         return name;
    }

    /*
      This is stars inside
      it does multiple lines
     */

    public void addOutbound(Cargo inCargo)
    {
         if (inCargo.getTonnage() >= 0)
         {
              outbound.add(inCargo);
         }
    }
    
    public double getLocalTonnage()
    {
         double total = 0.0;
         for (Cargo unit : local)
         {
              total += unit.getTonnage();
         }
         return total;
    }
    
    public double getOutboundTonnage()
    {
         double total = 0.0;
         for (Cargo unit : outbound)
         {
              total += unit.getTonnage();
         }
         return total;
    }

    public void setName(String inName)
    {
         name = inName;
    }

    public void load(Transporter targetTransporter, String target) throws FacilitiesMismatchException
    {
         //Verify type of Transporter
         //Can only load Transporters which Port has loading facilities for
         if (!getMatch(targetTransporter.getRouteType()))
         {
              throw new FacilitiesMismatchException(this,targetTransporter);
         }
         
         
         for (int x = outbound.size() - 1; x >=0 ; x--)
         {
              if (outbound.get(x).getDest().equals(target) && targetTransporter.load(outbound.get(x)))
              {
                   outbound.remove(x);
              }
         }
    }
    
    public void load(Transporter targetTransporter) throws FacilitiesMismatchException
    {
         //load(targetTransporter, targetTransporter.getDest());
         
         //Verify type of Transporter
         //Can only load Transporters which Port has loading facilities for
         if (!getMatch(targetTransporter.getRouteType()))
         {
              throw new FacilitiesMismatchException(this,targetTransporter);
         }
         
         
         for (int x = outbound.size() - 1; x >=0 ; x--)
         {
              if (targetTransporter.load(outbound.get(x)))
              {
                   outbound.remove(x);
              }
         }
         
    }

    public void unload(Transporter targetTransporter) throws FacilitiesMismatchException
    {
         //Verify type of Transporter
         //Can only unload Transporters which Port has loading facilities for ... Excepting AirDrops!
         if ((!getMatch(targetTransporter.getRouteType())) && !((targetTransporter.getRouteType() == Traveller.RouteType.AIR) && ((Airplane) targetTransporter).getCanAirDrop()))
         {
              throw new FacilitiesMismatchException(this,targetTransporter);
         }
         
         ArrayList<Cargo> unloaded = targetTransporter.unload(getName());
         for (Cargo unit : unloaded)
         {
              if (getName().equals(unit.getDest()))
              {
                   local.add(unit);
              }
              else
              {
                   outbound.add(unit);
              }
         }
         
    }

    
    public void unloadAll(Transporter targetTransporter) throws FacilitiesMismatchException
    {
         //Verify type of Transporter
         //Can only unload Transporters which Port has loading facilities for ... Excepting AirDrops!
         if ((!getMatch(targetTransporter.getRouteType())) && !((targetTransporter.getRouteType() == Traveller.RouteType.AIR) && ((Airplane) targetTransporter).getCanAirDrop()))
         {
              throw new FacilitiesMismatchException(this,targetTransporter);
         }
         
         ArrayList<Cargo> unloaded = targetTransporter.unloadAll();
         for (Cargo unit : unloaded)
         {
              if (getName().equals(unit.getDest()))
              {
                   local.add(unit);
              }
              else
              {
                   outbound.add(unit);
              }
         }
         
    }
}