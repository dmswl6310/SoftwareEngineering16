package test1;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JFrameTest extends JFrame {
	String[] num = {"2명","3명","4명","5명"};//사람수
	String[] name = {"a","b","c","d","e"};//임시사람이름

	public JFrameTest() {
		
		JComboBox strCombo= new JComboBox(num);
        this.add(strCombo);
        
        JComboBox nameCombo = new JComboBox(name);
        this.add(nameCombo);
        
        

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrameTest f = new JFrameTest();
		
		f.setTitle("게임");
		f.setSize(480,640);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		
		
		
		
		f.setVisible(true);


		

	}

}
