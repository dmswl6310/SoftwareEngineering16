import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class test3 extends JFrame implements ActionListener{

	String name;
	JPanel title;
	JPanel info;

	String content;
	JPanel show1;
	JPanel show2;
	JTextField show;
	JLabel la;
	ImageIcon img;
	JButton[] s;

	final String location;
	
	public test3(Restaurant r) {

		super("상세 검색 화면");
		location = "C:\\Users\\황은지\\Desktop\\Softengineering_Test1\\SE_Project\\src\\";

		this.name = r.name;
		content = "";
		File resinfo = new File(location + this.name + ".txt");
		img = new ImageIcon(location + this.name + ".jpg");

		// 전체 구성 : title과 info 패널 두개
		setLayout(new BorderLayout());
		title = new JPanel(new BorderLayout());
		info = new JPanel(new BorderLayout());

		ImageIcon icon = new ImageIcon(location + "y2.png");
		s=new JButton[5];
		
		
		show2 = new JPanel(new GridLayout(1,5));
		show1 = new JPanel(new GridLayout(1,2));

		for(int i=0;i<5;i++) {
		s[i] = new JButton("", icon);
		s[i].setForeground(Color.white);
		show2.add(s[i]);
		s[i].addActionListener(this);
	    s[i].setFocusPainted(false);
	    s[i].setBorderPainted(false);
	    s[i].setContentAreaFilled(false);
		}

		// title패널에는 라벨만 들어감
		Label t = new Label(this.name);
		title.add(t);

		try {
			Scanner rscan = new Scanner(resinfo);
			rscan.nextLine();
			while (rscan.hasNextLine()) {
				content += (rscan.nextLine());
			}
		} catch (FileNotFoundException e) {
			content += "파일이 없습니다";
		}

		show = new JTextField(content);
		// show1패널에는 show 패널(텍스트필드)와 show2패널(별점)이 들어감
		show1.add(show);
		show1.add(show2);
		la = new JLabel(img, SwingConstants.CENTER);
		// info패널에는 show1(텍스트와 별점)과 그림 패널이 들어감
		info.add(BorderLayout.CENTER, show1);
		info.add(BorderLayout.SOUTH, la);

		add(BorderLayout.NORTH, title);
		add(BorderLayout.CENTER, info);

		setSize(480, 640);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		
    	int[] num=new int[6];
    	for(int i=0;i<5;i++) {
        if (e.getSource( )==s[i])  {
        	num[i]=1;
        	
			if(num[i]%2 == 1){
				
				s[i].setIcon(new ImageIcon(location+"y1.PNG"));
			}
			else{
				s[i].setIcon(new ImageIcon(location+"y2.PNG"));
			}
        }
    	}
        num[5]=num[0]+num[1]+num[2]+num[3]+num[4];
        /*if (e.getSource( )==cq)  {
        
        if (e.getSource( )==ee) {
        	number1=0;
        	number2=0;
        	number3=0;
        	number4=0;
        	number5=0;
        	sj.setIcon(new ImageIcon(location+"y2.PNG"));
        	chy.setIcon(new ImageIcon(location+"y2.PNG"));
        	cq.setIcon(new ImageIcon(location+"y2.PNG"));
        	enter.setIcon(new ImageIcon(location+"y2.PNG"));
        	ew.setIcon(new ImageIcon(location+"y2.PNG"));
        }
        number6=number1+number2+number3+number4+number5;
        
        
     }

*/
}
}
