import java.util.*;
public class Port
{
    private String name = "";
    private ArrayList<Cargo> local = new ArrayList<Cargo>(); //Local Cargo
    private ArrayList<Cargo> outbound = new ArrayList<Cargo>(); //Outbound Cargo
    private Random gen = new Random();
    private int portNum;
    private static int currentPortNum = 0;

    private void setPortNumber()
    {
	portNum = currentPortNum++;
    }

    public int getPortNumber()
    {
	return portNum;
    }

    public int getCurrentPortNumber()
    {
	return currentPortNum;
    }

    public Port(String inName)
    {
         setName(inName);
	 setPortNumber();
    }
    
    public Port()
    {
	setPortNumber();
    }
    
    public String toString()
    {
	String output = "";
	output = "This Port object, #" + getPortNumber() + ", has the following attribute values:\n";
	output = output + "\tPort location: " + getName() + "\n";
	output = output + "\tLocal cargo: " + getLocalTonnage() + " tons\n";
	output = output + "\tOutbound cargo: " + getOutboundTonnage() + " tons\n";
	output = output + "\tNext valid port number will be " + getCurrentPortNumber() + "\n";

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
    
    public void load(Ship targetShip)
    {
         for (int x = outbound.size() - 1; x >=0 ; x--)
         {
              if (targetShip.load(outbound.get(x)))
              {
                   outbound.remove(x);
              }
         }
    }

    public void unload(Ship targetShip)
    {
         ArrayList<Cargo> unloaded = targetShip.unload(getName());
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

    
    public void unloadAll(Ship targetShip)
    {
         ArrayList<Cargo> unloaded = targetShip.unloadAll();
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
