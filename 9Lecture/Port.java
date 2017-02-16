import java.util.Random;
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
    
    public double getLocal()
    {
         return local; 
    }

    public double getOutbound()
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

    public void setOutbound(double moreOutbound)
    {
         if (moreOutbound >= 0)
         {
              outbound = moreOutbound;
         }
    }

    public void setName(String inName)
    {
         name = inName;
    }
    
    public double unload(Ship targetShip, double amount)
    {
         double actual = 0.0;
         actual = targetShip.unload(amount);
         local += actual;
         return actual;
         
    }

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