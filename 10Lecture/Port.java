import java.util.*;
public class Port
{
    private String name = "";
    private ArrayList<Cargo> local = new ArrayList<Cargo>(); //Local Cargo
    private ArrayList<Cargo> outbound = new ArrayList<Cargo>(); //Outbound Cargo
    private Random gen = new Random();

    public Port(String inName, ArrayList<Cargo> inCargo)
    {
         setName(inName);

	 for(int i = 0; i < inCargo.size(); i++)
	     {
		 addOutbound(inCargo.get(i));
	     }
    }
    
    public Port(String inName)
    {
         setName(inName);
    }
     
    public ArrayList<Cargo> getLocal()
    {
         return local; 
    }

    public ArrayList<Cargo> getOutbound()
    {
         return outbound; 
    }

    public double getLocalTonnage()
    {
	double total = 0.0;

	for(int i = 0; i < local.size(); i++)
	    {
		total += local.get(i).getTonnage();
	    }

	return total;
    }

    public double getOutboundTonnage()
    {
	double total = 0.0;

	for(int i = 0; i < outbound.size(); i++)
	    {
		total += local.get(i).getTonnage();
	    }

	return total;
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
	outbound.add(inCargo);
    }

    public void setName(String inName)
    {
         name = inName;
    }
    
    public void unload(Ship targetShip)
    {
        targetShip.unload(name);
    }

    public void load(Ship targetShip)
    {
	for(int i = 0; i < outbound.size(); i++)
	    {
		targetShip.load(outbound.get(i));
	    }
    }

    public void unloadAll(Ship targetShip)
    {
	for(int i = 0; i < outbound.size(); i++)
	    {
		targetShip.unloadAll();
	    }
    }

}
