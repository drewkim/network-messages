import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

/*****************************************************************
 * Description: Sends an array of Strings to a computer on the
 * same network.
 * 
 * @author Drew Kim
 *
 *****************************************************************/
public class Sender 
{
	private static String receiverIP;
	private static int port;
	private static String[] arrayOfStrings;
	
	public Sender(String receiverIPIn, int portIn, String[] arrayIn)
	{
		receiverIP = receiverIPIn;
		port = portIn;
		arrayOfStrings = arrayIn;
	}
	
	/**
	 * Establish a connection to the receiving computer and send the data
	 */
	public void doClientConnection() 
	{
		   Socket connection;
		   OutputStream out;
		   try 
		   {
			  //Establish the connection to receiving computer
		      connection = new Socket(receiverIP, port);
		      out = connection.getOutputStream();
		      out.write(arrayOfStrings.length);
		     
		      //Send over the strings byte by byte
		      for(int i = 0; i < arrayOfStrings.length; i++)
		      {
		    	  byte[] b = encodeString(arrayOfStrings[i]);
		    	  out.write(b.length);
		    	  out.write(b);
		      }
		      JOptionPane.showMessageDialog(null, "Message sent!");
		   }
		   catch (IOException e) 
		   {
		      System.out.println("Attempt to create connection failed with error: " + e);
		      JOptionPane.showMessageDialog(null, "Couldn't establish connection.");
		      return;
		   }	
		   
		   try 
		   {
		      connection.close();
		   }
		   catch (IOException e) 
		   {
		   }
	}
	
	/**
	 * Encodes the string into an array of bytes
	 * @param str
	 * @return
	 */
	private static byte[] encodeString(String str)
	{
		byte[] b = new byte[str.length()];
		for(int i = 0; i < b.length; i++)
		{
			b[i] = (byte)str.charAt(i);
		}
		return b;
	}
}
