import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Language extends JFrame implements ActionListener
{
	/**
	 * 
	 * 
	 * */

	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 480;
	public static final int HEIGHT = 640;
	
	public static String language;
	public static Locale currentLocale;
	
	public ResourceBundle messages;
	
	public JPanel langPanel;
	public JFrame langFrame;
	private Locale defaultLocale = new Locale("en","US");
	
	/*public static void main(String[] args)
	{
		Language dem = new Language();
		dem.setVisible(true);
	}*/
	public Language()
	{
		
		super("Language");
		//setSize(WIDTH, HEIGHT);
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		currentLocale = defaultLocale;
		messages = ResourceBundle.getBundle("MessagesBundle",currentLocale);
		langPanel = new JPanel();
		langPanel.setVisible(true);
		
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
		//setJMenuBar(bar);  // no need to set bar
		
		langFrame.add(bar, BorderLayout.CENTER);
	
		
	}
	
	public void SetLanguage(String lang, String c)
	{
		currentLocale = new Locale(lang, c);
		messages = ResourceBundle.getBundle("Messagesbundle",currentLocale);
		
		//System.out.println(currentLocale);
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
		else {
			Locale.setDefault(defaultLocale);;
			
		}
		
	}

}
