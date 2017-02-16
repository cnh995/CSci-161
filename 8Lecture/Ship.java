import java.util.Random;
public class Ship
{
    private String name = "";
    private double mct = 0.0; //Max Cargo Tonnage
    private double cct = 0.0; //Current Cargo Tonnage
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

    public double getCurrentCargo()
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
    
    public double load(double amount)
    {
         if (amount < 0)
              return 0.0;
         
         if (amount > getMax() - getCurrentCargo())
         {
              amount = getMax() - getCurrentCargo();
         }

         cct += amount;
         return amount;
    }
    
    public double unload(double amount)
    {
         if (amount < 0)
              return 0.0;
         
         if (amount > getCurrentCargo())
         {
              amount = getCurrentCargo();
         }         
         
         cct -= amount;
         return amount;
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