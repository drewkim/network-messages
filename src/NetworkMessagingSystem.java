import javax.swing.*;

public class NetworkMessagingSystem extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int MAX_WIDTH = 400;		
	private static final int MAX_HEIGHT = 300;	
	
	public NetworkMessagingSystem()
	{
		
	}
	
	public static void main (String[] args)
	{
		Gui gui = new Gui();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(MAX_WIDTH, MAX_HEIGHT);
		gui.setVisible(true);
	}
}
