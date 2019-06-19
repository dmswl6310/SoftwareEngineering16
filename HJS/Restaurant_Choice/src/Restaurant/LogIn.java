package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LogIn extends JPanel{ // 로그인 창
	String Input_ID;
	char[] Input_PW;
	public JButton lButton = null;
	public JButton[] b = null;
	
	public LogIn(){
		JPanel loginField = new JPanel();
		JPanel SigninField = new JPanel();
		JPanel ButtonField = new JPanel();
		
		
		this.setLayout(new BorderLayout());
		
		// 아이디, 패스워드 패널
		SigninField.setLayout(new FlowLayout());
		JLabel j1 = new JLabel("ID");
		JTextField tf1 = new JTextField(12);
		JLabel j2 = new JLabel("PW");
		JPasswordField tf2 = new JPasswordField(12);
		tf2.setEchoChar('*');
		tf1.setPreferredSize(new Dimension(600, 20));
		tf2.setPreferredSize(new Dimension(600, 20));
	
		SigninField.add(j1);
		SigninField.add(tf1);
		SigninField.add(j2);
		SigninField.add(tf2);
		loginField.add(SigninField, "Center");
		this.add(loginField);
		// 상단 버튼 패널
		
		b = new JButton[3];
		b[0] = new JButton(Application.messages.getString("language"));
		b[1] = new JButton(Application.messages.getString("minigame"));
		b[2] = new JButton(Application.messages.getString("sign_up"));
		
		for(int i = 0; i < 3; i++) {
			b[i].setPreferredSize(new Dimension(120,30));
			ButtonField.add(b[i]);
		}
		this.add(ButtonField,"North");
		
		//
		
		lButton = new JButton(Application.messages.getString("log_in"));
		this.add(lButton,  "South");
		
		//////////////////////////////////////////////////////////////////
		ActionListener eventHandler = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = "";
				// TODO Auto-generated method stub
				
					
				if(e.getSource() == lButton){
					Input_ID = tf1.getText();
					Input_PW = tf2.getPassword();
					
					for(char cha : Input_PW) {
						Character.toString(cha);
						pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
					}// 패스워드 해독
					
					
					System.out.printf("ID : %s\n", Input_ID);
					System.out.printf("PW : %s\n", pw);
					System.out.printf("PW2 : %s\n", Input_PW);
					
					boolean logincheck = false;					
					for(int i = 0; i <= Application.top; i++) {
						if(Application.DB[i].getID().equals(Input_ID) &&
								Application.DB[i].getPW().equals(pw)) {
							JOptionPane.showMessageDialog(null, Application.messages.getString("sign_up_success"));
							logincheck = true;
							
							Application.MyCard.card.show(Application.mainPanel,"test1");
							
							
						}
					}
					
					if(logincheck == false) {
						JOptionPane.showMessageDialog(null, Application.messages.getString("acc_not_exist"));
						
					}
					
				}else if(e.getSource() == b[2]) {
					Application.MyCard.card.show(Application.mainPanel,"Sign_Up");
				}
				else if(e.getSource()==b[0])
				{
					Application.MyCard.card.show(Application.mainPanel, "Language");
				}else if(e.getSource()==b[1])
				{
					GhostLeg GL = new GhostLeg();
					
				}
					
			}
		};
		//////////////////////////////////////////////////////////////////
		
		lButton.addActionListener(eventHandler);
		b[2].addActionListener(eventHandler);
		b[0].addActionListener(eventHandler);
		b[1].addActionListener(eventHandler);
		
		
		
		
	}//LogIn()		
	
	
	
}