package LogIn;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.*;


public class Sign_Up extends JPanel{
	
	
	boolean satisfy_pw = false;
	boolean satisfy_ID = false;
	
	JPanel sign_up_in = new JPanel();
	String temp_ID;
	String temp_PW;
	String temp_PW_Check;
	String temp_birth;
	String temp_name;
	String temp_Email;	
	
	
	
	JLabel check = new JLabel();//Application.messages.getString("check_pwd_label")); //"패스워드 일치 확인"
	JButton b_check = new JButton();//Application.messages.getString("check"));
	
	JLabel check_ID = new JLabel();//Application.messages.getString("id_ok"));//"ID 중복 확인");
	JButton b_check_ID = new JButton(Language.getString("check"));
	
	JButton Final = new JButton(Language.getString("sign_up"));
	JLabel Final_tx = new JLabel("");
	
	
	JTextField tfname = new JTextField(12);	// 이름
	JTextField tfbirth = new JTextField(12); // 생년월일
	
	JTextField tf0 = new JTextField(12);	// ID
	JPasswordField tf1 = new JPasswordField(12); // PW
	JPasswordField tf2 = new JPasswordField(12); // PW_Check
	//JTextField tf3 = new JTextField(12); // name
	JTextField tf4 = new JTextField(25); // E-Mail
	
	public JButton BackButton = new JButton(Language.getString("go_back"));
	
	
	public Sign_Up() {
		check.setText(Language.getString("check_pwd_label"));
		b_check.setText(Language.getString("check"));
		check_ID.setText(Language.getString("id_ok"));
		
		JPanel sign_up = new JPanel();
		sign_up.setLayout(null);
		
		this.setLayout(new BorderLayout());
		
		JLabel text = new JLabel(Language.getString("sign_up"));
		
		JLabel[] label = new JLabel[7];
		label[0] = new JLabel("ID");
		label[1] = new JLabel("PW");
		label[2] = new JLabel("PW_Check");
		//label[3] = new JLabel("*name");
		label[4] = new JLabel("E-Mail");
		label[5] = new JLabel(Language.getString("name"));
		label[6] = new JLabel(Language.getString("birthDate"));
		
		
		
		text.setBounds(200, 50, 100, 20);
		label[5].setBounds(100, 120, 100, 20);
		label[6].setBounds(100, 170, 100, 20);
		
		label[0].setBounds(100, 220, 100, 20);
		label[1].setBounds(100, 270, 100, 20);
		label[2].setBounds(100, 300, 100, 20);
		//label[3].setBounds(100, 370, 100, 20);
		label[4].setBounds(100, 370, 100, 20);
		
		BackButton.setBounds(50, 500, 120, 20);
		
		
		sign_up.add(text);
		sign_up.add(label[0]);
		sign_up.add(label[1]);
		sign_up.add(label[2]);	
		//sign_up.add(label[3]);
		sign_up.add(label[4]);
		sign_up.add(label[5]);
		sign_up.add(label[6]);
		sign_up.add(BackButton);
		
		Final.setBounds(200, 500, 150, 20);
		Final_tx.setBounds(200, 480, 200, 20);
		
		tfname.setBounds(200, 120, 150, 20);
		tfbirth.setBounds(200, 170, 150, 20);
		tf0.setBounds(200, 220, 150, 20);	// ID
		tf1.setBounds(200, 270, 150, 20);	// PW
		tf2.setBounds(200, 300, 150, 20);	// PW_Check
		tf4.setBounds(200, 370, 150, 20);	// Email
		
		
		sign_up.add(tfname);
		sign_up.add(tfbirth);
		sign_up.add(tf0);
		sign_up.add(tf1);
		sign_up.add(tf2);
		//sign_up.add(tf3);
		sign_up.add(tf4);
		
		sign_up.add(Final);
		sign_up.add(Final_tx);
		///////////////////////////////////////////////////
		
		
		check_ID.setBounds(110,245,200,20);
		b_check_ID.setBounds(250,245, 70,20);
		
		
		check.setBounds(110,330,200,20);
		b_check.setBounds(250,330, 70,20);
		
		
		
		sign_up.add(b_check);
		sign_up.add(check);
		sign_up.add(b_check_ID);
		sign_up.add(check_ID);
		
		
		this.add(sign_up, "Center");
		
		
		
		
		ActionListener eventHandler = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = "";
				// TODO Auto-generated method stub
				if(e.getSource() == b_check){ // 
					Check_PW(tf1.getPassword(), tf2.getPassword());
				}else if(e.getSource() == b_check_ID) {
					Check_ID(tf0.getText());
				}else if(e.getSource() == Final) {
					if(Check_Final() == true
						&& !tfname.getText().equals("")
						&& !tfbirth.getText().equals("")
						&& !tf0.getText().equals("")
						&& !tf4.getText().equals("")) {
						
						temp_name = tfname.getText();
						temp_birth = tfbirth.getText();
						temp_ID = tf0.getText();
						// temp_PW는 미리 맞춰놓음
						temp_Email = tf4.getText();

						Member m = new Member();
						m.create(temp_name, temp_birth, temp_ID, temp_PW, temp_Email);
						JOptionPane.showMessageDialog(null, Language.getString("sign_up_success"));//"회원 가입이 완료되었습니다.");
						
						tfname.setText("");
						tfbirth.setText("");
						tf0.setText("");	// ID
						tf1.setText("");	// PW
						tf2.setText("");	// PW_Check
						tf4.setText("");	// Email
						
						
						Application.MyCard.card.show(Application.mainPanel,"LogIn");
						
					}else {
						Final_tx.setText(Language.getString("blank_not_fill"));//"정보를 모두 기입하지 않았습니다.");
					}
					
				}else if(e.getSource() == BackButton) {
					Application.MyCard.card.show(Application.mainPanel,"LogIn");
				}
			}
		};
		
		
		b_check.addActionListener(eventHandler);
		b_check_ID.addActionListener(eventHandler);
		Final.addActionListener(eventHandler);
		BackButton.addActionListener(eventHandler);
		
	}// Sign_Up
	
	
		
	public void Check_PW(char[] PW1, char[] PW2) { // 패스워드 체크
		String p1 = "";
		String p2 = "";
		
		if(PW1 != null) {
			for(char cha1 : PW1) {
				Character.toString(cha1);
				p1 += (p1.equals("")) ? ""+cha1+"" : ""+cha1+"";
			}
		}
		
		if(PW2 != null) {
			for(char cha2 : PW2) {
				Character.toString(cha2);
				p2 += (p2.equals("")) ? ""+cha2+"" : ""+cha2+"";
			}
		}
		
		
				
		if(p1.length() != 0 && p2.length() != 0) { // 아무것도 안 씀...

			if(p1.equals(p2) && !p1.equals("") && !p2.equals("")) {
				check.setText(Language.getString("check_pwd"));//"비밀번호 일치");
				temp_PW = p1;
				satisfy_pw = true;
			}else {
				check.setText(Language.getString("pwd_not_match"));
				satisfy_pw = false;
			}
		}
	} // check_pw
	
	public void Check_ID(String ID) {
		for(int i = 0; i <= Application.top; i++) {
			if(ID.equals(Application.DB[i].getID())) { // 이미 존재하는 ID라면
				check_ID.setText(Language.getString("id_in_use"));   //"중복되는 ID가 있습니다.");
				satisfy_ID = false;
				
				return;
			}
		}
		
		check_ID.setText(Language.getString("id_notin_use"));//"중복되는 ID가 없습니다.");
		satisfy_ID = true;
	} // Check_ID()
	
	
	public boolean Check_Final() {
		if(satisfy_ID == true && satisfy_pw == true) {
			return true;			
		}else {
			
			return false;
		}
			
	}
	
	
	
}
