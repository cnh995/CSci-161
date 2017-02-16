import java.util.Random;

/**
 * The Ship object simulates a ship for cargo transfers.
 *
 * @author Christian Hansen
 */

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
    
    /**
     *The setSpeed method allows the user to set the speed of the ship.
     *
     * @param inSpeed This input is the speed of the ship
     */
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
    
    /**
     *The getSpeed method returns the speed of the ship
     *
     * @return double This refers to the speed of the ship
     */
    public int getSpeed()
    {
         return speed;
    }
    
    /**
     *The getDistance method returns the distance the ship is away from its destination.
     *
     * @return double This refers to the distance the ship is away from the destination.
     */
    public int getDistance()
    {
         return dist;
    }

    /**
     * The getCurrentCargo method returns the amount of cargo currently on the ship, in tons.
     *
     * @return double referring to the amount of cargo currently on the ship.
     */
    public double getCurrentCargo()
    {
         return cct; 
    }

    /**
     * The getMax method returns the maximum amount of cargo the ship can hold, in tons.
     *
     * @return double referring to the maximum amount of cargo the ship can hold.
     */
    public double getMax()
    {
         return mct; 
    }

    /**
     * The getName method returns the name of the ship.
     *
     * @return String referring to the name of the ship.
     */
    public String getName()
    {
         return name;
    }

    /*
      This is stars inside
      it does multiple lines
     */

    /**
     * The setMax method allows the user to set the maximum amount of cargo that the ship can hold, in tons.
     *
     * @param inMax This input is the maximum amount of cargo the ship can hold, in tons.
     */
    public void setMax(double inMax)
    {
         if (inMax >= 0)
         {
              mct = inMax;
         }
    }

    /**
     * The setName method allows the user to set the name of a ship.
     *
     * @param inName This input is the name of a ship.
     */
    public void setName(String inName)
    {
         name = inName;
    }
    
    /**
     * The load method allows the user to say how much cargo they want to load onto the ship, in tons. If the desired amount is too high, the ship will just be filled to the max.
     *
     * @param amount This input refers to the amount of cargo in tons to be added to the ship.
     *
     * @return double referring to the amount of cargo that is now on the ship.
     */
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
    
    /**
     * This unload method will allow the user to say how much cargo they want to unload from the ship. If the number is less than 0, it will return 0. If the amount is higher than the cargo currently on the ship, it will remove all of the cargo.
     *
     * @param amount This input is the amount of cargo to be removed from the ship.
     *
     * @return double This refers to the amount of cargo that is now on the ship.
     */
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
    
    /**
     * The travel method will take the speed and distance of the ship and calculate how far it has traveled.
     */
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
