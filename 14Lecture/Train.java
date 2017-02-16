import java.util.*;

public class Train extends Transporter
{
    private boolean derailed = false;
    private int engines = 1;

    public void setEngines(int num)
    {
	if(num > 0)
	    engines = num;
    }

    public int getEngines()
    {
	return engines;
    }

    public void derail()
    {
	derailed = true;
    }

    public boolean getDerailed()
    {
	return derailed;
    }

    public Train(String inName, double inMax, int inSpeed, int inDist)
    {
	super(inName, inMax, inSpeed, inDist);
    }
    
    public Train(String inName, double inMax, int inSpeed)
    {
	super(inName, inMax, inSpeed);
    }
    
    public Train(String inName, double inMax)
    {
	super(inName, inMax);
    }
    
    public Train(String inName)
    {
	super(inName);
    }
    
    public Train()
    {
	super();
    }
}
