import java.util.Random;

/**
 * The Port object simulates a port for cargo transfer.
 *
 * @author Christian Hansen
 */

public class Port
{
    private String name = "";
    private double local = 0.0; //Local Cargo
    private double outbound = 0.0; //Outbound Cargo
    private Random gen = new Random();

    public Port(String inName, double inCargo)
    {
         setName(inName);
         setOutbound(inCargo);
    }
    
    public Port(String inName)
    {
         setName(inName);
         
         double rand = gen.nextDouble() * 10000;
         setOutbound(rand);
    }
    
    public Port(double inCargo)
    {
         setOutbound(inCargo);
    }
    
    public Port()
    {
         double rand = gen.nextDouble() * 10000;
         setOutbound(rand);
    }
    
    /**
     * The getLocal method returns the current amount of local cargo that the port has.
     *
     * @return double referring to cargo in terms of tons.
     */
    public double getLocal()
    {
         return local; 
    }

    /**
     * The getOutbound method returns the total amount of outbound cargo the port is giving to a ship.
     *
     * @return double referring the amount of outbound cargo in tons.
     */
    public double getOutbound()
    {
         return outbound; 
    }

    /**
     * The getName method returns the name of the ship that cargo is going to be added to.
     * 
     * @return String referring the name of the ship.
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
     * This setOutbound method allows for the setting of cargo that needs to leave the port and go to some other port
     *
     * @param moreOutbound This input is the amount of outbound cargo that should be located at this port.
     */
    public void setOutbound(double moreOutbound)
    {
         if (moreOutbound >= 0)
         {
              outbound = moreOutbound;
         }
    }

    /**
     * This setName method allows the user to set the name of the ship.
     *
     * @param inName This input is the name of the ship that is having cargo loaded onto it.
     */
    public void setName(String inName)
    {
         name = inName;
    }
    
    /**
     * This unload method will allow the user to remove a certain amount of cargo from a named ship.
     *
     * @param targetShip This input is the target ship that cargo is being taken from.
     * @param amount This input gives the amount of cargo that is being taken off of the ship.
     *
     * @return double referring to the actual amount of cargo unloaded from the ship.
     */
    public double unload(Ship targetShip, double amount)
    {
         double actual = 0.0;
         actual = targetShip.unload(amount);
         local += actual;
         return actual;
         
    }

    /**
     * This load method will allow the user to add add a given amount of cargo to a certain ship.
     *
     * @param targetShip This input is the ship that cargo will be given to.
     * @param amount This input is the amount of cargo being given to the named ship.
     *
     * @return double referring to the actual amount of cargo that has been loaded onto the ship.
     */
    public double load(Ship targetShip, double amount)
    {
         double actual = 0.0;
         
         if (amount > getOutbound())
         {
              amount = getOutbound();
         }
         
         actual = targetShip.load(amount);
         outbound -= actual;
         return actual;
         
    }

}
