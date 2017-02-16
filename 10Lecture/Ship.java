import java.util.*;
public class Ship
{
    private String name = "";
    private double mct = 0.0; //Max Cargo Tonnage
    private ArrayList<Cargo>  cct = new ArrayList<Cargo>(); //Current Cargo List
    private int speed = 0; //Speed of Ship
    private int dist = 0; //Distance between Ship and its current destination
    private Random gen = new Random();
    
    public Ship(String inName, double inMax, int inSpeed, int inDist)
    {
         setName(inName);
         setMax(inMax);
         setSpeed(inSpeed);
         setDistance(inDist);
    }
    
    public Ship(String inName, double inMax, int inSpeed)
    {
         setName(inName);
         setMax(inMax);
         setSpeed(inSpeed);
         int tmp = gen.nextInt(900)+101;
         setDistance(tmp);
    }
    
    public Ship(String inName, double inMax)
    {
         setName(inName);
         setMax(inMax);
         int tmp = gen.nextInt(51)+10;
         setSpeed(tmp);
         tmp = gen.nextInt(900)+101;
         setDistance(tmp);
    }
    
    public Ship(String inName)
    {
         setName(inName);
         double temp = (gen.nextDouble() * 700) + 50;
         setMax(temp);
         int tmp = gen.nextInt(51)+10;
         setSpeed(tmp);
         tmp = gen.nextInt(900)+101;
         setDistance(tmp);
    }
    
    public Ship()
    {
         double temp = (gen.nextDouble() * 700) + 50;
         setMax(temp);
         int tmp = gen.nextInt(51)+10;
         setSpeed(tmp);
         tmp = gen.nextInt(900)+101;
         setDistance(tmp);
    }
    
    public void setSpeed(int inSpeed)
    {
         if (inSpeed >= 0)
         {
              speed = inSpeed;
         }
    }

    public void setDistance(int inDist)
    {
         if (inDist >= 0)
         {
              dist = inDist;
         }
    }
    
    public int getSpeed()
    {
         return speed;
    }
    
    public int getDistance()
    {
         return dist;
    }

    public ArrayList<Cargo>  getCurrentCargo()
    {
         return cct; 
    }

    public double getMax()
    {
         return mct; 
    }

    public String getName()
    {
         return name;
    }

    /*
      This is stars inside
      it does multiple lines
     */

    public void setMax(double inMax)
    {
         if (inMax >= 0)
         {
              mct = inMax;
         }
    }

    public void setName(String inName)
    {
         name = inName;
    }

    public double getCurrentCargoTonnage()
    {
	double total = 0.0;

	for(Cargo unit : cct)
	    {
		total += unit.getTonnage();
	    }

	return total;
    }
    
    public boolean load(Cargo inCargo)
    {
	if(inCargo.getTonnage() < 0)
	    return false;

	if(inCargo.getTonnage() + getCurrentCargoTonnage() > getMax())
            return false;
         
	cct.add(inCargo);
        return true;
    }
    
    public ArrayList<Cargo>  unload(String portName)
    {
	//Need
	//Temp ArrayList for output
	//Loop to check what cargo should transfer to output ArrayList
	//And might want to transfer Cargo at that time ^
	//Make sure to remove the cargo from the ship's ArrayList ^

	ArrayList<Cargo> tempCargo = new ArrayList<Cargo>();

	for(int i = 0; i < cct.size(); i++)
	    {
		if(cct.get(i).getDestination().equals(portName))
		    {
			tempCargo.add(cct.get(i));
			cct.remove(cct.get(i));
		    }
	    }

	return tempCargo;
    }

    public ArrayList<Cargo>  unloadAll()
    {
	ArrayList<Cargo> tempCargo = new ArrayList<Cargo>();

	for(int i = 0; i < cct.size(); i++)
	    {
		tempCargo.add(cct.get(i));
		cct.remove(cct.get(i));
	    }

	return tempCargo;
    }
    
    public void travel()
    {
         int traveled = 0;
         
         if (getDistance() == 0)
         {
              System.out.println("Ship is already in port or has no destination");
         }
         else if (getDistance() > getSpeed())
         {
              traveled = getDistance() - getSpeed();
              setDistance(traveled);
              System.out.println("Ship traveled " + getSpeed() + " units and is now " + getDistance() + " units from destination");
         }
         else if (getDistance() <= getSpeed())
         {
              setDistance(traveled);
              System.out.println("The Ship: " + getName() + " has arrived at its destination");
         }
    }

}
