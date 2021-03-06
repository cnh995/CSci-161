import java.util.*;


public class PartitionProblem
{
     static Random rand = new Random();
     final static int SIZE = 3; //Change this value to adjust array and value range sizes!  
                                   //I suggest using 5 or 10 for debugging!
     
     public static void main(String[] args)
     {
          //Create a randomly sized array
          ArrayList<Integer> array = generateArray(rand.nextInt(SIZE) + SIZE);

          //Print list
          System.out.println(array);
          
          //Find best partition
          int diff = partition(array);
          
          //Print best difference
          System.out.println("For the given values, the closest the two partitions can get is: " + diff);
     }
     
     //This method takes IN an integer and
     //Returns a randomly filled ArrayList of the input's size
     public static ArrayList<Integer> generateArray(int size)
     {
          ArrayList<Integer> output = new ArrayList<Integer>();
          for (int x = 0; x < size; x++)
          {
               output.add(rand.nextInt(SIZE * 2) - SIZE);
          }
          return output;
     }
     
     
     //This method takes IN an ArrayList of integers and
     //returns the closest partition difference possible for that list
     public static int partition(ArrayList<Integer> list)
     {
          //One way to solve this problem is to
          //take each number in turn and put into 1 of 2 bags.
          //Once all the numbers are in a bag compare the sums.
          //Then try putting a value in a different bag.
          //Repeat until all combinations have been tried.
          
          //To do that, I need 2 more empty bags
          ArrayList<Integer> bag1 = new ArrayList<Integer>();
          ArrayList<Integer> bag2 = new ArrayList<Integer>();
          
          //Call partition trying method with all 3 lists
          return tryPartition(list, bag1, bag2);
     }
     
     
     public static int tryPartition(ArrayList<Integer> unBaggedValues, ArrayList<Integer> set1, ArrayList<Integer> set2)
     {
          //Do we have any unBaggedValues?
          //If NO, calculate the sum
          //If YES, bag a value!
          
          if (unBaggedValues.isEmpty())
          {
               return Math.abs(sum(set1) - sum(set2));
          }
          
          
          //Try bagging next value into set1
          set1.add(unBaggedValues.remove(unBaggedValues.size() - 1));
          //get difference if that value went into set1
          int diff1 = tryPartition(unBaggedValues, set1, set2);
          
          //Try bagging that value into set2 instead
          //Remember, that menas taking it from set1 and
          //adding it to set2 instead
          set2.add(set1.remove(set1.size() - 1));
          //get difference if that value went into set2
          int diff2 = tryPartition(unBaggedValues, set1, set2);
          
          //Compare the 2 outcomes and return the smaller
          if (diff1 < diff2)
          {
               return diff1;
          }
          return diff2;
     }
     
     //This method just sums the values provided in the INPUT ArrayList
     public static int sum(ArrayList<Integer> data)
     {
          int sum = 0;
          for (int x = 0; x < data.size(); x++)
          {
               sum += data.get(x);
          }
          return sum;
     }
          
     
}
