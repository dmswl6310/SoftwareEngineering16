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

	double starAverage;
	int starNum;
	Boolean done;
	
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

		super("�� �˻� ȭ��");
		location = "C:\\Users\\Ȳ����\\Desktop\\Softengineering_Test1\\SE_Project\\src\\";
		done=false;
		this.name = r.name;
		content = "";
		File resinfo = new File(location + this.name + ".txt");
		img = new ImageIcon(location + this.name + ".jpg");

		// ��ü ���� : title�� info �г� �ΰ�
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

		// title�гο��� �󺧸� ��
		Label t = new Label(this.name);
		title.add(t);

		try {
			Scanner rscan = new Scanner(resinfo);			
			String[] temp = (rscan.nextLine()).split(" ");
			starAverage=Double.parseDouble(temp[0]);
			starNum=Integer.parseInt(temp[1]);
			
			while (rscan.hasNextLine()) {
				content += (rscan.nextLine());
			}
		} catch (FileNotFoundException e) {
			content += "������ �����ϴ�";
		}

		show = new JTextField(content);
		// show1�гο��� show �г�(�ؽ�Ʈ�ʵ�)�� show2�г�(����)�� ��
		show1.add(show);
		show1.add(show2);
		la = new JLabel(img, SwingConstants.CENTER);
		// info�гο��� show1(�ؽ�Ʈ�� ����)�� �׸� �г��� ��
		info.add(BorderLayout.CENTER, show1);
		info.add(BorderLayout.SOUTH, la);

		add(BorderLayout.NORTH, title);
		add(BorderLayout.CENTER, info);

		setSize(480, 640);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(done==false) {

		double star=0.0;
    	int[] num=new int[5];
    	
    	for(int i=0;i<5;i++) {
        if (e.getSource( )==s[i])  {
        	star=(i+1);
        	for(int j=0;j<=i;j++) {
        		num[j]=1;
				s[j].setIcon(new ImageIcon(location+"y1.PNG"));
        	}
        	
        }else {
        s[i].setIcon(new ImageIcon(location+"y2.PNG"));
        }
    	}
        starAverage=((starAverage*starNum)+star)/(++starNum);
        System.out.println("���"+starAverage);
        System.out.println("Ƚ��"+starNum);
        done=true;
		}
}
}

