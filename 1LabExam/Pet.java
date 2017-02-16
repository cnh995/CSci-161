import java.util.*;

public class Pet
{
     private static int ID = 0;
     protected Random rand = new Random();
     private String name;
     private double hours = 0.0;
     private double cost = 0.0;
     private double happy;
     private double reflex;
     public final int REG_ID = ID;
     
     public Pet()
     {
          setName("");
          setHoursOfCare(0);
          setCostOfCare(0);
          setOwnerSatisfaction(100);
          setReflex(100);
          ID++;
     }
     
     public Pet(String n, double h, double c, double s, double r)
     {
          setName(n);
          setHoursOfCare(h);
          setCostOfCare(c);
          setOwnerSatisfaction(s);
          setReflex(r);
          ID++;
     }
     
     public void setName(String input)
     {
          if (input.length() < 2)
               name = "Pet " + ID;
          else
               name = input;
     }
     
     public void setHoursOfCare(double input)
     {
          hours = input;
          while (hours <= 0.0 || hours > 5.0)
               hours = (rand.nextDouble() * 10) / 2;
     }

     public void setCostOfCare(double input)
     {
          cost = input;
          while (cost <= 0.0 || cost > 10.0)
               cost = (rand.nextDouble() * 10);
     }
     
     public void setOwnerSatisfaction(double input)
     {
          happy = input;
          while (happy < -10.0 || happy > 10.0)
               happy = (rand.nextDouble() * 20) - 10;     
     }

     public void setReflex(double input)
     {
          reflex = input;
          while (reflex < -5.0 || reflex > 10.0)
               reflex = (rand.nextDouble() * 15) - 5;     
     }
     
     public String getName()
     {
          return name;
     }
     
     public double getHoursOfCare()
     {
          return hours;
     }
     
     public double getCostOfCare()
     {
          return cost;
     }
     
     public double getOwnerSatisfaction()
     {
          return happy;
     }
     
     public double getReflex()
     {
          return reflex;
     }
     
     public String toString()
     {
          return getName() + "\n\tCare in Hours:\t" + getHoursOfCare() + "\n\tCost of Care:\t" + getCostOfCare() + "\n\tOwner Satisfaction:\t" + getOwnerSatisfaction() + "\n\tReflexes:\t" + getReflex();
     }
     
}

