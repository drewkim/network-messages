import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JButton send;
	private TextField text;
	private TextField ip;
	private TextField port;
	
	public Gui()
	{
		super("Messaging System");
		setLayout(new FlowLayout());
		HandlerClass handler = new HandlerClass();

		text = new TextField("", 40);
		add(text);
		text.addActionListener(handler);
		
		send = new JButton("send");
		add(send);
		send.addActionListener(handler);
		
		ip = new TextField("Enter IP Adress of Receiver", 20);
		add(ip);
		ip.addActionListener(handler);
		
		port = new TextField("Enter port", 10);
		add(port);
		port.addActionListener(handler);
	}
	
	private class HandlerClass implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == send)
			{
				String[] stringArrayToSend = encodeStringIntoArray(text.getText());
				Sender sender = new Sender(ip.getText(), Integer.parseInt(port.getText()), stringArrayToSend);
				sender.doClientConnection();
			}
		}
		
	}
	
	private static String[] encodeStringIntoArray(String str)
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		String string = "";
		for(int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			if(ch != ' ')
			{
				string +=i;
			}
			else
			{
				arrayList.add(string);
				string = "";
			}
		}
		return arrayList.toArray(new String[arrayList.size()]);
	}
}
