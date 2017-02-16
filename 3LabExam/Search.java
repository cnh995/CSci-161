 import java.util.*;


public class Search
{
     static Random rand = new Random();
     
     public static boolean bogoSearch(int[] input, int search)
     {
          while (true)
          {
               if (input[rand.nextInt(input.length)] == search)
                    return true;
          }
     }
     
     public static boolean sequentialSearch(int[] input, int search)
     {
          for (int x : input)
          {
               if (x == search)
                    return true;
          }
          
          return false;
     }
          
     public static boolean binarySearch(int[] input, int search)
     {
          if (input.length == 0)
               return false;
               
          int low = 0;
          int high = input.length-1;
          int middle;
          
          while(low <= high ) 
          {
               middle = (low+high) /2;
               if (search > input[middle] )
                    low = middle +1;
               else if (search < input[middle])
                    high = middle -1;
               else
                    return true;
          }
          return false;
     }
}