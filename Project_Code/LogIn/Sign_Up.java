package LogIn;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Sign_Up extends JFrame{
	String tempID;
	String tempPW;
	String tempPW_Check;
	String tempmail;
	
	boolean satisfy = false;
	
	Sign_Up() {
		
		JPanel sign_up = new JPanel();
		sign_up.setLayout(null);
		
		JPanel sign_up_in = new JPanel();
		String temp_ID;
		String temp_PW;
		String temp_PW_Check;
		String temp_name;
		String temp_Email;	
		
		JLabel text = new JLabel("회원 가입");
		
		JLabel[] label = new JLabel[6];
		label[0] = new JLabel("*ID");
		label[1] = new JLabel("*PW");
		label[2] = new JLabel("*PW_Check");
		label[3] = new JLabel("*name");
		label[4] = new JLabel("*E-Mail");
		
		text.setBounds(200, 50, 100, 20);
		label[0].setBounds(100, 120, 100, 20);
		label[1].setBounds(100, 170, 100, 20);
		label[2].setBounds(100, 200, 100, 20);
		label[3].setBounds(100, 270, 100, 20);
		label[4].setBounds(100, 320, 100, 20);
		
		
		sign_up.add(text);
		sign_up.add(label[0]);
		sign_up.add(label[1]);
		sign_up.add(label[2]);	
		sign_up.add(label[3]);
		sign_up.add(label[4]);
		
		JTextField tf0 = new JTextField(12);
		JPasswordField tf1 = new JPasswordField(12); // PW
		JPasswordField tf2 = new JPasswordField(12); // PW_Check
		JTextField tf3 = new JTextField(12); // name
		JTextField tf4 = new JTextField(25); // E-Mail
		
		tf0.setBounds(200, 120, 150, 20);
		tf1.setBounds(200, 170, 150, 20);
		tf2.setBounds(200, 200, 150, 20);
		tf3.setBounds(200, 270, 150, 20);
		tf4.setBounds(200, 320, 150, 20);
		
		
		sign_up.add(tf0);
		sign_up.add(tf1);
		sign_up.add(tf2);
		sign_up.add(tf3);
		sign_up.add(tf4);
		////////////////////////////////////////////////////////////
		
		JLabel check_ID = new JLabel("ID 중복 확인");
		JButton b_check_ID = new JButton("확인");
		
		check_ID.setBounds(100,145,200,20);
		b_check_ID.setBounds(250,145, 70,20);
		
		
		JLabel check = new JLabel("패스워드 일치 확인");
		JButton b_check = new JButton("확인");
		
		b_check.setBounds(250,225, 70,20);
		check.setBounds(100,225,200,20);
		
		sign_up.add(b_check);
		sign_up.add(check);
		sign_up.add(b_check_ID);
		sign_up.add(check_ID);
		
		
		Application.window.add(sign_up, "Center");
		
		
		ActionListener eventHandler = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = "";
				// TODO Auto-generated method stub
				if(e.getSource() == b_check){
					Check_PW(tf1.getPassword(), tf2.getPassword());
				}
			}
		};
		
		
		
		
		
		
		
	}
	
	
		
	public void Check_PW(char[] PW1, char[] PW2) { // 패스워드 체크
		if(PW1.equals(PW2))
			return;
		else
			return;
	}
	
	public void Check_alreadyexist(String ID) {
		
		
		
	}
		
	
	
	
	
}
