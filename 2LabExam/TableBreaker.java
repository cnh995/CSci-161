import java.util.Random;
public class TableBreaker
{
     public static void main(String[] args)
     {
          Random gen = new Random();
          
          //Create an array of tables
          Table[] myTables = new Table[100];
          
          //For each table:
          for (int x = 0; x < myTables.length; x++)
          {
               //Create Table
               //Print Table Data
               //Add weights
               //Print Table Data
               myTables[x] = new Table();
               System.out.println(myTables[x]);
               try
               {
                    myTables[x].add(gen.nextInt(500) + 5);
               }
               catch (BrokenTableException e)
               {
                    System.err.println(e.getMessage());
               }
               System.out.println(myTables[x]);
               System.out.println("----------------");
          }
          
     }
}