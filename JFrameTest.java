package test1;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JFrameTest extends JFrame {
	String[] num = {"2��","3��","4��","5��"};//�����
	String[] name = {"a","b","c","d","e"};//�ӽû���̸�

	public JFrameTest() {
		
		JComboBox strCombo= new JComboBox(num);
        this.add(strCombo);
        
        JComboBox nameCombo = new JComboBox(name);
        this.add(nameCombo);
        
        

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrameTest f = new JFrameTest();
		
		f.setTitle("����");
		f.setSize(480,640);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		
		
		
		
		f.setVisible(true);


		

	}

}
