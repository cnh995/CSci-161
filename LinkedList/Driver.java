import java.util.*; // Need Random
import java.io.*; //Need File IO Tools
public class Driver
{

    public static void main(String[] args)
    {
         //Create a link to an input file
         File transFile = new File("Transporters.txt");
         
         
         Scanner inputPorter = null;
         try
         {
              inputPorter = new Scanner(transFile);
         }
         catch (FileNotFoundException e)
         {
              System.err.println(e.getMessage());
              System.err.println("The Transporters.txt file is not in the current directory!  Exiting Program!");
         }

         //Setup rest of reading tools and Array Lists
         ArrayList<Transporter> myPorters = new ArrayList<Transporter>();
         String line;
         String[] parts;
	 SLL single = new SLL(); 
	 DLL doubleList = new DLL();
	 CSLL circularSingle = new CSLL();
	 CDLL circularDouble = new CDLL();

         while(inputPorter.hasNext())
         {
              //Read line
              line = inputPorter.nextLine();
              //Split line into parts
              parts = line.split("%");
              //Store Data
              try
              {
                   if (parts[0].equals("SHIP"))
		       {
			   single.add(new Ship(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
			   doubleList.add(new Ship(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
			   circularSingle.add(new Ship(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
			   circularDouble.add(new Ship(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
		       }
                   else if (parts[0].equals("AIRPLANE"))
		       {
			   single.add(new Airplane(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Boolean.parseBoolean(parts[5])));
			   doubleList.add(new Airplane(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Boolean.parseBoolean(parts[5])));
			   circularSingle.add(new Airplane(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Boolean.parseBoolean(parts[5])));
			   circularDouble.add(new Airplane(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Boolean.parseBoolean(parts[5])));
		       }
                   else if (parts[0].equals("TRAIN"))
                       {
			   single.add(new Train(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
			   doubleList.add(new Train(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
			   circularSingle.add(new Train(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
			   circularDouble.add(new Train(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
		       }
                   else if (parts[0].equals("SEMITRUCK"))
		       {
			   single.add(new SemiTruck(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
			   doubleList.add(new SemiTruck(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
			   circularSingle.add(new SemiTruck(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
			   circularDouble.add(new SemiTruck(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
		       }
              }
              catch (BadDataException e)
              {
                   System.err.println(e.getMessage());
              }
//              else
//                   myPorters.add(new Transporter(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));

         }
         //Close input file, we are done with the input file
         inputPorter.close();
         
	 System.out.println(single);

         Collections.sort(myPorters);
         Collections.reverse(myPorters);
         
         for(Transporter t : myPorters)
              System.out.println(t);
         
         Collections.reverse(myPorters);
         System.out.println ("\n\n----------------------------\n\n");
         for(Transporter t : myPorters)
         {
              if (t instanceof SemiTruck)
                   System.out.println(t);
         }
         
         System.out.println ("\n\n----------------------------\n\n");
         for(Transporter t : myPorters)
         {
              if (t instanceof Train)
                   System.out.println(t);
         }
    }
}
