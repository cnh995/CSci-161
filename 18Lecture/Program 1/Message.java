import java.io.*;
public class Message implements Serializable
{
     private String msg = "";
     
     public Message(String inMsg)
     {
          setMSG(inMsg);
     }
     
     public void setMSG(String input)
     {
          msg = input;
     }
     
     public String getMSG()
     {
          return msg;
     }
     
     public String toString()
     {
          return getMSG();
     }
     
}
