import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*****************************************************************
 * Description: Reads in an array of Strings from a sender on 
 * the same network.
 * 
 * @author Drew Kim
 *
 *****************************************************************/
public class Receiver 
{
	public static final int port = 1728;

	public static void main(String[] args) 
	{
		Socket connection;
		ServerSocket server;
		InputStream is;
		try 
		{
			//Establish the port, accept the connection, and start the input stream
			server = new ServerSocket(port);
			connection = server.accept();
			is = connection.getInputStream();
			
			//Get the number of strings being sent
			int numStrings = is.read();
			
			String[] strArray = new String[numStrings];
			
			//Read in each individual array of bytes and convert it to a string
			for(int i = 0; i < numStrings; i++) 
			{
				int stringLength = is.read();
				byte[] b = new byte[stringLength];
				
				//OutputStream sends over an array of bytes, so we receive it and decode it.
				is.read(b);
				String str = decodeString(b);
				System.out.println(str);
				strArray[i] = str;
			}
		}
		catch(IOException e)
		{
			System.out.println("Server shut down with error: " + e);
		}

	}

	/**
	 * Convert an array of bytes into a String
	 * @param b
	 * @return
	 */
	private static String decodeString(byte[] b)
	{
		String str = "";
		for(int i = 0; i < b.length; i++)
			str += (char)b[i];
		return str;
	}
}
