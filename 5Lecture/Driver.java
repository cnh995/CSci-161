import java.util.*;

public class Driver
{

    public static void main(String[] args)
    {
	Ship thisShip = new Ship();
	System.out.println("Name of ship: " + thisShip.getName());
	System.out.println("Max cargo: " + thisShip.getMax());
	System.out.println("Speed : " + thisShip.getSpeed());
	System.out.println("Distance : " + thisShip.getDistance());
    }
}
