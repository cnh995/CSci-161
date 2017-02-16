import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
   The BinarySearchTreeDemo class builds 2 BST's from the same random int list.
   User may then compare the two trees.
*/

public class BinarySearchTreeDemo extends JFrame
{

  private static Random rand = new Random();
  
    
    public BinarySearchTreeDemo(int[] array, boolean optimize)
    {
        if (optimize)
          setTitle("Optimized Tree");
        else
          setTitle("Normal Tree");
        BinarySearchTree binTree = new BinarySearchTree(array, optimize);   

        
        // Display BST
        if (view != null)
          remove(view);
        view = binTree.getView();            
        add(view);
        pack();
        validate(); 


        
        // Set up the frame
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
    }
    
    JPanel view = null;
    
   
  
   /**
      The main method creates 2 instances of the 
    BinarySearchTreeDemo class which causes them 
      to build their BSTs and display thoses trees in windows.
   */

  public static void main(String[ ]args)
  { 
    //Generate a randomized array
    int[] array = genArray(31);
    //Build Normal
     new BinarySearchTreeDemo(array, false);  
     //Build Optimized
     new BinarySearchTreeDemo(array, true); 
  }
  
  public static int[] genArray(int size)
  {
    int[] output = new int[size];
    for (int x=0; x < size; x++)
    {
      output[x] = rand.nextInt();
    }
    return output;
  }
  
  
  
}