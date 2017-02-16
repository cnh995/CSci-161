import java.util.*;

public class Cargo
{
    String destination = "";
    double tonnage = 0.0;

    public Cargo(String inDest, double inTonnage)
    {
	setDest(inDest);
	setTonnage(inTonnage);
    }

    private void setDest(String inDest)
    {
	destination = inDest;
    }

    private void setTonnage(double inTonnage)
    {
	if(inTonnage >= 0)
	    {
		tonnage = inTonnage;
	    }
	else
	    System.out.println("Error: cargo tonnage can't be negative.");
    }

    public String getDestination()
    {
	return destination;
    }

    public double getTonnage()
    {
	return tonnage;
    }
}
