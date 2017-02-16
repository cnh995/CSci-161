import java.util.*;

/**
 * The Ship object simulates a ship for cargo transfers.
 *
 * @author Christian Hansen
 */

public class Ship
{
    String name = "";
    double mct = 0.0; //Max Cargo Tonnage
    double cct = 0.0; //Current Cargo Tonnage
    int speed = 0; //Ship speed
    int distance = 0; //Distance from destination

    public Ship(String inName, double inMax, int inSpeed, int inDistance)
    {
	setName(inName);
	setMax(inMax);
	setSpeed(inSpeed);
	setDistance(inDistance);
    }

    public Ship(String inName, double inMax, int inSpeed)
    {
	Random rng = new Random();
	int randDistance = rng.nextInt(900) + 101;

	setName(inName);
	setMax(inMax);
	setSpeed(inSpeed);
	setDistance(randDistance);
    }

    public Ship(String inName, double inMax)
    {
	Random rng = new Random();
	int randSpeed = rng.nextInt(51) + 10;
	int randDistance = rng.nextInt(900) + 101;

	setName(inName);
	setMax(inMax);
	setSpeed(randSpeed);
	setDistance(randDistance);
    }

    public Ship(String inName)
    {
	Random rng = new Random();
	double randMax = (rng.nextDouble() * 700) + 50;
	int randSpeed = rng.nextInt(51) + 10;
	int randDistance = rng.nextInt(900) + 101;

	setName(inName);
	setMax(randMax);
	setSpeed(randSpeed);
	setDistance(randDistance);
    }

    public Ship()
    {
	Random rng = new Random();
	double randMax = (rng.nextDouble() * 700) + 50;
	int randSpeed = rng.nextInt(51) + 10;
	int randDistance = rng.nextInt(900) + 101;

	setMax(randMax);
	setSpeed(randSpeed);
	setDistance(randDistance);
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
	return distance;
    }

    /**
     * The setDistance method allows the user to set the distance away from the destination.
     *
     * @param inDistance This input is the distance the ship is away from the destination.
     */
    public void setDistance(int inDistance)
    {
	distance = inDistance;
    }

    /**
     *The setSpeed method allows the user to set the speed of the ship.
     *
     * @param inSpeed This input is the speed of the ship
     */
    public void setSpeed(int inSpeed)
    {
	speed = inSpeed;
    }

    /**
     * The setMax method allows the user to set the maximum amount of cargo that the ship can hold, in tons.
     *
     * @param inMax This input is the maximum amount of cargo the ship can hold, in tons.
     */
    public void setMax(double inMax)
    {
         mct = inMax;
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
	if(amount < 0)
	    {
		return 0.0;
	    }

	if(amount > getMax() - getCurrentCargo())
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
	if (amount < 0.0)
	    {
		return 0.0;
	    }

	if (amount > getCurrentCargo())
	    {
		amount = getCurrentCargo();
	    }

	cct -= amount;
	
	return amount;
    }

    public void travel(int speed, int distance)
    {
	if (distance == 0.0)
	    {
		System.out.println("Ship is already in port or has no destination.");
	    }

	if(distance > speed)
	    {
		distance -= speed;
		System.out.println("Ship traveled " + speed + " and is now " + distance + " units from destination.");
	    }

	if(distance < speed)
	    {
		System.out.println("Ship has reached its destination.");
	    }
    }
}
