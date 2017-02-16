/**
 * The ObjArray object contains a way to store the name of an object, as well as the quantity available. It also has a refill method if an item needs to be refilled.
 *
 * @author Christian Hansen
 */
public class ObjArray
{
    private String name;
    private int quantity;

    /**
     *This constructor assigns the name and quantity of an item in a vending machine
     *
     * @param inName This input is the name of the item.
     * @param inQuantity This input is the quantity of the item.
     */
    public ObjArray(String inName, int inQuantity)
    {
	name = inName;
	quantity = inQuantity;
    }

    /**
     *The getName method returns the name of an item.
     *
     * @return String This string is the name of the item.
     */
    public String getName()
    {
	return name;
    }

    /**
     *The refill method refills the quantity of an item in the machine.
     */
    public void refill()
    {
	quantity += 5;
    }

    /**
     *The getQuantity method returns the quantity of an item in the machine.
     *
     * @return int This is the amount of an item in the machine.
     */
    public int getQuantity()
    {
	return quantity;
    }
}
