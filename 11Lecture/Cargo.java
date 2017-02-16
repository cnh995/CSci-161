import java.util.*;
public class Cargo
{
     private String dest = "";
     private double tons = 0.0;
     private int orderNum = 0;
     private static int currentOrderNum = 0;

    private void setOrderNumber()
    {
	orderNum = currentOrderNum++;
    }

    public int getOrderNumber()
    {
	return orderNum;
    }

    public int getCurrentOrderNumber()
    {
	return currentOrderNum;
    }

    public Cargo(String inDest, double inTons)
    {
         setDest(inDest);
         setTonnage(inTons);
         setOrderNumber();
    }
     
    public String toString()
    {
	String output = "";
	output = "This Cargo object, #" + getOrderNumber()  + ", has the following attribute values:\n";
        output = output + "\t" + getTonnage() + " tons of cargo\n";
        output = output + "\tAnd is heading to " + getDest() + "\n";
	output = output + "\tNext valid order number will be " + getCurrentOrderNumber() + "\n";

	return output;
    }

     public String getDest()
     {
          return dest;
     }
     
     public double getTonnage()
     {
          return tons;
     }
     
     private void setDest(String inDest)
     {
          dest = inDest;
     }
     
     private void setTonnage(double inTons)
     {
          if (inTons >= 0)
          {
               tons = inTons;
          }
     }
     
}
