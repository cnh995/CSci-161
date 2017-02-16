import java.util.*;


public class SearchDemo
{
     public static void main(String[] args)
     {
          int[] array = genArray(0, 10000);
          
          long startTime = System.nanoTime();
          for (int num : array)
               Search.bogoSearch(array, num);
          long endTime = System.nanoTime();
          System.out.println("BogoSearch took " + (endTime - startTime) + " nano seconds to find every number in the array.");
                             
          startTime = System.nanoTime();
          for (int num : array)
               Search.sequentialSearch(array, num);
          endTime = System.nanoTime();
          System.out.println("SequentialSearch took " + (endTime - startTime) + " nano seconds to find every number in the array.");
                             
 
          startTime = System.nanoTime();
          Arrays.sort(array);
          for (int num : array)
               Search.binarySearch(array, num);
          endTime = System.nanoTime();
          System.out.println("BinarySearch took " + (endTime - startTime) + " nano seconds to find every number in the array.");
     }
     
     
     public static int[] genArray (int items, int max)
     {
          if (items > max)
               return null;
          
          ArrayList<Integer> seed = new ArrayList<Integer>();
          for (int x = 0; x <= max; x++)
               seed.add(x);
          
          int[] output = new int[items];
          Random gen = new Random();
          for (int x = 0; x < items; x++)
               output[x] = seed.remove(gen.nextInt(seed.size()));
          
          return output;
     }
     
}
