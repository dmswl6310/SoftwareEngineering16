import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;


public class guiLang extends JFrame {

	String language, country;
	
	void SelectLang(String l, String c)
	{
	language=l;
	country=c;
	}
	String getLang()
	{
		return language;
	}
	String getC()
	{
		return country;
	}
	public void SetLang()
	{
		
		
		//JPanel ButtonField = new JPanel();
		
		JFrame frame = new JFrame("Seect Language");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360,640);
       
		JButton[] b = new JButton[3];
		b[0] = new JButton("ENGLISH");
		b[1] = new JButton("한국어");
		b[2] = new JButton("Francaise");
		
	for(int i=0;i<3;i++) 
       frame.getContentPane().add(b[i]);
       frame.setVisible(true);
		
		ActionListener eventHandler=new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==b[0])
				{
					SelectLang("en", "US");
				}
				if(e.getSource()==b[1])
				{
					SelectLang("ko", "KO");
				}
				
				}
					
				};
				b[0].addActionListener(eventHandler);
				b[1].addActionListener(eventHandler);
			
		}//SetLang
	
public static void main(String []args)
	
	{	
	    String language, country;
	
		guiLang g1=new guiLang();
	    g1.SetLang();
		
	
		language=g1.getLang();
		country=g1.getC();
		
		ResourceBundle messages=null;
		Locale aLocale = new Locale("en", "US");
		Locale frLocale = new Locale("fr","FR");
		Locale currentLocale;
		
		currentLocale = new Locale(language, country);
		
		
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		System.out.println(messages.getString("greetings"));
		System.out.println(messages.getString("farewell"));
		
	}
	
}
