package Restaurant;




import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;



public class Application {
	// temporarily DB create
	public static Member[] DB = new Member[20];
	public static int top = -1;
	public static boolean LangSelected = false;
	public static JFrame window = new JFrame("window"); // 창...?
	public static JPanel mainPanel = new JPanel();

	public static void DB_init() {
		///////// 테스트용 DB
		
		for(int i = 0; i< 20; i++)
			DB[i] = new Member();
		
		
		//////////
		BufferedReader bReader = null;
		
		try {
			File file = new File("member.txt");
			bReader = new BufferedReader(new FileReader(file));
			
			
			String line = null;
			int num = 0;
			
			Application.top++;
			while((line = bReader.readLine()) != null) {
				
				String[] str = null;
				str = line.split(" ");
				
				
				DB[top].IsMember = true;
				
				for(int i = 0; i < str.length; i++) {
					System.out.println(str[i]);
					switch(i) {
						case 0:
							DB[top].setname(str[i]);
							break;
						case 1:
							DB[top].setbirth(str[i]);
							break;
						case 2:
							DB[top].setID(str[i]);
							break;
						case 3:
							DB[top].setPW(str[i]);
							break;
						case 4:
							DB[top].setUserNumber(Integer.parseInt(str[i]));
							DB[top].setEmail("Not Exist");
							break;
						case 5:
							DB[top].setEmail(str[i]);
							Application.top++;
							break;
					}
				}
			}
			
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bReader != null)
					bReader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		/////////////////////////////////////////////////////////// 파일 열기
		Application.top--;
		System.out.printf("top : %d", top);
			
		
	}

	
	static class MyCard extends JFrame{
		static CardLayout card = new CardLayout(); // Card Layout Create
		
		//LogIn LI = new LogIn();
		//Sign_Up SU = new Sign_Up();
		Language LG = new Language();
		
		
		
		MyCard() {
			mainPanel.setLayout(card);
			mainPanel.add("Language", LG);
			//mainPanel.add("LogIn", LI);
			//mainPanel.add("Sign_Up", SU);
						
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		int window_W = 480;
		int window_H = 640;
		
		
		DB_init();
		// DB 생성		
		
		Application.window.setSize(window_W, window_H);
		Application.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Application.window.setResizable(false);
		
		Application.window.add(mainPanel);
		
		MyCard MC = new MyCard();
		MC.card.show(mainPanel, "Language");
		Application.window.setVisible(true);
		
		
	}
	
}