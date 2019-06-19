import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Language extends JPanel implements ActionListener
{
	/**
	 * 
	 * 
	 * */

	
	private static final long serialVersionUID = 1L;
	
	
	public static String language;
	public static Locale currentLocale;
	
	public ResourceBundle messages;
	
	public JPanel langPanel;
	public JButton Back= new JButton("Go Back");
	private Locale defaultLocale = new Locale("en","US");
	
	
	public Language()
	{
		langPanel = new JPanel();
		langPanel.setLayout(null);
		this.setLayout(new BorderLayout());
		Back.setBounds(200, 250, 100, 20);
		langPanel.add(Back,"Center");
		Back.addActionListener(this);
		
		
		currentLocale = defaultLocale;
		messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
		
		//langPanel.setLayout(new BorderLayout());     
		//langPanel.setBackground(Color.BLACK);  //color of language window
		//add(langPanel);
		
		JMenu langMenu = new JMenu("Choose Language");
		
		JMenuItem korean = new JMenuItem("한국어");
		korean.addActionListener(this);
		langMenu.add(korean);
		
		JMenuItem french = new JMenuItem("Francias");
		french.addActionListener(this);
		langMenu.add(french);
		
		JMenuItem english = new JMenuItem("English");
		english.addActionListener(this);
		langMenu.add(english);
		
		JMenuItem chinese = new JMenuItem("Chinese");
		chinese.addActionListener(this);
		langMenu.add(chinese);
		
		JMenuBar bar = new JMenuBar();
		bar.add(langMenu);
		
		
		
		langPanel.add(bar, "South");
		bar.setBounds(150, 150, 200, 20);
		this.add(langPanel);
	
		
	}
	
	public void SetLanguage(String lang, String c)
	{
		currentLocale = new Locale(lang, c);
		messages = ResourceBundle.getBundle("Messagesbundle",currentLocale);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String buttonString = e.getActionCommand();
		
		if(buttonString.equals("한국어")) {
			SetLanguage("ko","KR");
			
		}
		else if(buttonString.equals("Francias")) {
			SetLanguage("fr", "FR");
		
		}
			
		else if(buttonString.equals("English")) {
			
				SetLanguage("en", "US");
				
				
		}
		else if(buttonString.equals("Chinese")) {
			SetLanguage("zh", "CN");
			//System.out.println(messages.getString("greetings"));
		}
		else if(buttonString.equals("Go Back")) {
			Application.MyCard.card.show(Application.mainPanel,"LogIn");
		}
		else
			Locale.setDefault(defaultLocale);;
			
		
		
	}

}
