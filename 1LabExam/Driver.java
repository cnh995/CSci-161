import java.util.*;
import java.io.*;

public class Driver
{
    public static void main(String[] args) throws FileNotFoundException
    {
	ArrayList<Pet> petList = new ArrayList<Pet>();

	File petFile = new File("Pets.txt");

	Scanner inputPets = new Scanner(petFile);

	String line;
	String[] parts;
	int totalEasy = 0;
	int totalCheap = 0;
	int totalExpensive = 0;
	int totalHard = 0;
	double totalPets = 0;

	while(inputPets.hasNext())
	    {
		//Read line
		line = inputPets.nextLine();
		//Split line
		parts = line.split(";");
		//Add pet to petList
		petList.add(new Pet(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
	    }

	inputPets.close();

	for(Pet eachPet : petList)
	    {
		System.out.println("Pet name: " + eachPet.getName());
		System.out.println("Pet ID: " + eachPet.REG_ID);

		if(eachPet.getHoursOfCare() < eachPet.getOwnerSatisfaction() - 2.5)
		    {
			System.out.println("This pet is easy to own.");
			totalEasy++;
		    }

		if(eachPet.getCostOfCare() < eachPet.getOwnerSatisfaction() - 1.5)
		    {
			System.out.println("This pet is cheap to own.");
			totalCheap++;
		    }

		if(eachPet.getCostOfCare() > eachPet.getOwnerSatisfaction() + 1.5)
		    {
			System.out.println("This pet is expensive to own.");
			totalExpensive++;
		    }

		if(eachPet.getHoursOfCare() > eachPet.getOwnerSatisfaction() + 2.5)
		    {
			System.out.println("This pet is hard to own.");
			totalHard++;
		    }

		totalPets++;

		System.out.println("\n");
	    }

	System.out.println("\n\nTotal pets: " + Math.round(totalPets));
	System.out.println("Total easy to own: " + totalEasy);
	System.out.println("Total cheap to own: " + totalCheap);
	System.out.println("Total expensive to own: " + totalExpensive);
	System.out.println("Total hard to own: " + totalHard + "\n");

	System.out.println("Percent easy to own: " + Math.round(((totalEasy / totalPets) * 100)) + "%");
	System.out.println("Percent cheap to own: " + Math.round(((totalCheap / totalPets) * 100)) + "%");
	System.out.println("Percent expensive to own: " + Math.round(((totalExpensive / totalPets) * 100)) + "%");
        System.out.println("Percent hard to own: " + Math.round(((totalHard / totalPets) * 100)) + "%");
    }
}
