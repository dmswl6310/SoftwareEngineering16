import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;




public class Language extends JPanel
{	
	public JPanel langPanel;
	public JButton Back = new JButton("Done");
	public static JComboBox<Locale> LangCBox;
	private static ResourceBundle message = ResourceBundle.getBundle("MessagesBundle",Language.getDefaultLocale());

	public Language()
	{
		langPanel = new JPanel();
		langPanel.setLayout(null);
		this.setLayout(new BorderLayout());
		Back.setBounds(200, 250, 100, 20);
		Back.addActionListener(listen);
		langPanel.add(Back,"Center");
		LangCBox = new JComboBox();
		LangCBox.addItem(Locale.getDefault());
		LangCBox.addItem(new Locale("ko","KR"));
		LangCBox.addItem(new Locale("en","US"));
		LangCBox.addItemListener(itemEvent -> SetLanguage());
		langPanel.add(LangCBox);
		LangCBox.setBounds(150, 150, 200, 20);
		this.add(langPanel);
		
	}//Language
	
	ActionListener listen = new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource()==Back)
					{
						///////////////////////////////////////
						LogIn LI = new LogIn();
						Sign_Up SU = new Sign_Up();
						Application.mainPanel.add("Sign_Up", SU);
						Application.mainPanel.add("LogIn", LI);
						Application.MyCard.card.show(Application.mainPanel,"LogIn");
					}
						
				}
		
			};
	
	
	public void SetLanguage()
	{
		Locale locale = LangCBox.getItemAt(LangCBox.getSelectedIndex());
	    message = ResourceBundle.getBundle("Messagesbundle",locale);   
		
	}
	
	
	public static String getString(String key)
	{
	 return message.getString(key);
	}

}


