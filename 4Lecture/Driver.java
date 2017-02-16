import java.util.*;

public class Driver
{

    public static void main(String[] args)
    {
         Ship ted = new Ship(); //Create a Ship Object
         
         System.out.println("TESTING SHIP");
         System.out.println("Testing Get Current Cargo:");
         System.out.println("\tShould be \"0.0\": " + ted.getCurrentCargo());
         
         System.out.println("\n\nTesting Max Cargo:");
         System.out.println("\tShould be \"0.0\": " + ted.getMax());
         ted.setMax(13.1);
         System.out.println("\tShould be \"13.1\": " + ted.getMax());
         
         System.out.println("\n\nTesting Name:");
         System.out.println("\tShould be \"XX\": X" + ted.getName() + "X");
         ted.setName("USS Minnow");
         System.out.println("\tShould be \"XUSS MinnowX\": X" + ted.getName() + "X");
         System.out.println("\n---------------------\n\n");
 
         Port gf = new Port(); //Create a Port Object
         
         System.out.println("TESTING PORT");
         System.out.println("Testing Get Local Cargo:");
         System.out.println("\tShould be \"0.0\": " + gf.getLocal());
         
         System.out.println("\n\nTesting Outbound Cargo:");
         System.out.println("\tShould be \"0.0\": " + gf.getOutbound());
         gf.setOutbound(24.5);
         System.out.println("\tShould be \"24.5\": " + gf.getOutbound());
         
         System.out.println("\n\nTesting Name:");
         System.out.println("\tShould be \"XX\": X" + gf.getName() + "X");
         gf.setName("Grand Forks");
         System.out.println("\tShould be \"XGrand ForksX\": X" + gf.getName() + "X");
         System.out.println("\n---------------------\n\n");
         
         System.out.println("TESTING LOAD/UNLOAD");
         double truth = 0.0;

         truth = gf.load(ted, 5.3);
         System.out.println("\tTesting valid load:\n\t\tShip should have \"5.3\": " + ted.getCurrentCargo() + "\n\t\tPort should have outbound cargo \"19.2\": " + gf.getOutbound() + "\n\t\tAmount actually loaded should be \"5.3\": " + truth);
         truth = gf.load(ted, 16.1);
         System.out.println("\tTesting overloading the Ship:\n\t\tShip should have \"13.1\": " + ted.getCurrentCargo() + "\n\t\tPort should have outbound cargo \"11.4\": " + gf.getOutbound() + "\n\t\tAmount actually loaded should be \"7.8\": " + truth);

         truth = gf.unload(ted, 4.4);
         System.out.println("\tTesting valid unload:\n\t\tShip should have \"8.7\": " + ted.getCurrentCargo() + "\n\t\tPort should have local cargo \"4.4\": " + gf.getLocal() + "\n\t\tAmount actually unloaded should be \"4.4\": " + truth);
         truth = gf.unload(ted, 10.5);
         System.out.println("\tTesting trying to unload more than the Ship has on board:\n\t\tShip should have \"0.0\": " + ted.getCurrentCargo() + "\n\t\tPort should have outbound cargo \"13.1\": " + gf.getLocal() + "\n\t\tAmount actually unloaded should be \"8.7\": " + truth);

         truth = gf.unload(ted, -7.1);
         System.out.println("\tTesting a negative unload:\n\t\tShip should have \"0.0\": " + ted.getCurrentCargo() + "\n\t\tPort should have local cargo \"13.1\": " + gf.getLocal() + "\n\t\tAmount actually unloaded should be \"0.0\": " + truth);

         
         truth = gf.load(ted, 12.1);
         System.out.println("\tTesting trying to load more than is in the Port's outbound:\n\t\tShip should have \"11.4\": " + ted.getCurrentCargo() + "\n\t\tPort should have outbound cargo \"0.0\": " + gf.getOutbound() + "\n\t\tAmount actually loaded should be \"11.4\": " + truth);

         truth = gf.load(ted, -1.3);
         System.out.println("\tTesting a negative load:\n\t\tShip should have \"11.4\": " + ted.getCurrentCargo() + "\n\t\tPort should have outbound cargo \"0.0\": " + gf.getOutbound() + "\n\t\tAmount actually loaded should be \"0.0\": " + truth);

	 Random rng = new Random();

	 int randSpeed = rng.nextInt(9) + 1;
	 int randDist = rng.nextInt(901) + 100;
	 int difference = 0;

	 ted.setSpeed(randSpeed);
	 ted.setDistance(randDist);

	 while(ted.getDistance() > 0)
	 {
	     ted.travel(ted.getSpeed(), ted.getDistance());
	     difference = ted.getDistance() - ted.getSpeed();

	     ted.setDistance(difference);
	 }
	 
    }


}
