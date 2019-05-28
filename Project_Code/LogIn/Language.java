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
	
	public static final int WIDTH = 360;
	public static final int HEIGHT = 640;
	
	public static String language;
	public static String country;
	
	
	public static Locale currentLocale;
	
	static ResourceBundle messages; 
	
	private JPanel langPanel;
	private Locale defaultLocale = new Locale("en","US");
	
	public static void main(String[] args)
	{
		Language dem = new Language();
		dem.setVisible(true);
		
	}
	
	public Language()
	{
		super("Language");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(new BorderLayout());
		
		langPanel=new JPanel();
		//langPanel.setLayout(new BorderLayout());     
		//langPanel.setBackground(Color.BLACK);  //color of language window
		add(langPanel);
		
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
		
		langPanel.add(bar, BorderLayout.CENTER);
		
		
	}
	
	public void SetLanguage(String lang, String c)
	{
		currentLocale=new Locale(lang, c);
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
			
		}
		else {
			Locale.setDefault(defaultLocale);;
			
		}
		
	}

}
