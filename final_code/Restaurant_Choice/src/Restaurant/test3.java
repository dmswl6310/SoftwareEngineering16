package Restaurant;


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
	JPanel top;
	JPanel starbut;
	JPanel showstar;
	JLabel starAvg;
	JLabel showtext;
	JLabel pic;
	ImageIcon img;
	JButton[] s;

	final String location;
	
	public test3(Restaurant r) {

		super("상세 검색 화면");
		//location = "C:\\Users\\황은지\\Desktop\\Softengineering_Test1\\SE_Project\\src\\";
		location = "restaurant_index\\";
		done=false;
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
		
		showstar= new JPanel(new BorderLayout());	
		starbut = new JPanel(new GridLayout(1,5));
		top = new JPanel(new GridLayout(1,2));
		for(int i=0;i<5;i++) {
		s[i] = new JButton("", icon);
		s[i].setForeground(Color.white);
		starbut.add(s[i]);
		s[i].addActionListener(this);
	    s[i].setFocusPainted(false);
	    s[i].setBorderPainted(false);
	    s[i].setContentAreaFilled(false);
		}
		

		try {
			Scanner rscan = new Scanner(resinfo);			
			String[] temp = (rscan.nextLine()).split(" ");
			starAverage=Double.parseDouble(temp[0]);
			starNum=Integer.parseInt(temp[1]);
			
			while (rscan.hasNextLine()) {
				content += (rscan.nextLine());
			}
		} catch (FileNotFoundException e) {
			content += "파일이 없습니다";
		}
		
		starAvg = new JLabel("평점"+starAverage+"      평가인원"+starNum,JLabel.CENTER); 
		showstar.add(BorderLayout.CENTER,starbut);
		showstar.add(BorderLayout.SOUTH,starAvg);
		//showtext.add(starla);
		// title패널에는 라벨만 들어감
		Label t = new Label(this.name);
		title.add(t);

		showtext = new JLabel(content);
		// top패널에는 showtext 패널(텍스트필드)와 showstar패널(별점패널)이 들어감
		top.add(showtext);
		top.add(showstar);
		pic = new JLabel(img, SwingConstants.CENTER);
		// info패널에는 top(텍스트와 별점)과 그림 패널이 들어감
		info.add(BorderLayout.CENTER, top);
		info.add(BorderLayout.SOUTH, pic);

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
        starAverage=Math.floor((((starAverage*starNum)+star)/++starNum)*10)/10;
        starAvg.setText("평점"+starAverage+"      평가인원"+starNum);
        System.out.println("평균"+starAverage);
        System.out.println("횟수"+starNum);
        done=true;
		}
}
}