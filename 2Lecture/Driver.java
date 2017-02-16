public class Driver
{
    public static void main(String[] args)
    {
	System.out.println("Hello world!");

	Ship ted = new Ship();
	System.out.println(ted.getCurrentCargo());
	System.out.println(ted.getMaxCargo());
	ted.setMax(25.0);
	System.out.println(ted.getMaxCargo());
    }
}
