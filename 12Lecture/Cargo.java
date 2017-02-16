import java.util.*;

public class Cargo
{
    private static int trackNumber = 0;
    private int orderNum; //equals
    private String dest = "";
    private double tons = 0.0; //order by weight
     
    public int compareTo(Cargo other)
    {
	if(tons < other.getTonnage())
	    return -1;
	else if(tons > other.getTonnage())
	    return 1;

	return 0;
    }

    public boolean equals(Cargo other)
    {
	if(orderNum == other.getOrderNumber())
	    {
		return true;
	    }

	return false;
    }

     public Cargo(String inDest, double inTons)
     {
          setDest(inDest);
          setTonnage(inTons);
          setOrderNumber();
     }
     
     private void setOrderNumber()
     {
          orderNum = trackNumber++;
     }
     
     public int getOrderNumber()
     {
          return orderNum;
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
     
     public String toString()
     {
          String output = "Cargo object #" + getOrderNumber() + " has the following information:\n";
          output = output + "\t" + getTonnage() + " tons\n\tTo be delivered to: " + getDest() + "\n";
          return output;
     }
     
}
