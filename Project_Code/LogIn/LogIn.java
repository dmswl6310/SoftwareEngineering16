package LogIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame{ // 로그인 창
	String Input_ID;
	char[] Input_PW;
	
	
	public LogIn(){
		
		JPanel SigninField = new JPanel();
		JPanel ButtonField = new JPanel();
		
		
		Application.window.setLayout(new BorderLayout());
		
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
		Application.window.add(SigninField, "Center");
		
		// 상단 버튼 패널
		
		JButton[] b = new JButton[3];
		b[0] = new JButton("언어");
		b[1] = new JButton("미니게임");
		b[2] = new JButton("회원가입");
		
		for(int i = 0; i < 3; i++) {
			b[i].setPreferredSize(new Dimension(120,30));
			ButtonField.add(b[i]);
		}
		Application.window.add(ButtonField,"North");
		
		//
		
		JButton l = new JButton("로그인");
		Application.window.add(l, "South");
		
		//////////////////////////////////////////////////////////////////
		ActionListener eventHandler = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = "";
				// TODO Auto-generated method stub
				if(e.getSource() == l){
					Input_ID = tf1.getText();
					Input_PW = tf2.getPassword();
					
					for(char cha : Input_PW) {
						Character.toString(cha);
						pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
					}// 패스워드 해독
					
					
					System.out.printf("ID : %s\n", Input_ID);
					System.out.printf("PW : %s\n", pw);
					System.out.printf("PW2 : %s\n", Input_PW);
				}
			}
		};
		//////////////////////////////////////////////////////////////////
		
		l.addActionListener(eventHandler);
		
		
		
		
		
		
	}//LogIn()		
	
	
	
}
