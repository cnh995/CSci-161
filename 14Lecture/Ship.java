import java.util.*;

public class Ship extends Transporter
{
    private boolean isSunk = false;

    public void sink()
    {
	isSunk = true;
    }

    public boolean getSunk()
    {
	return isSunk;
    }

    public Ship(String inName, double inMax, int inSpeed, int inDist)
    {
	super(inName, inMax, inSpeed, inDist);
    }
    
    public Ship(String inName, double inMax, int inSpeed)
    {
	super(inName, inMax, inSpeed);
    }
    
    public Ship(String inName, double inMax)
    {
	super(inName, inMax);
    }
    
    public Ship(String inName)
    {
	super(inName);
    }
    
    public Ship()
    {
	super();
    }
}
