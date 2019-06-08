import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class test1 extends JFrame{
	JPanel p,p1,p2;
	JComboBox<String> com1,com2;
	JTextField name,time,price;
	String type[]= {"---","한식","일식","양식","중식","기타"};
	String location[]= {"---","정문(쪽문)","북문","동문","서문"};
	public test1() {
		super("식당 검색 화면");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		name=new JTextField("---",10);
		c.add(name);
		//p=new JPanel(new GridLayout(1,5));
		com1=new JComboBox<String>(type);
		JScrollPane s1=new JScrollPane(com1);
		c.add(s1);
		
		com2=new JComboBox<String>(location);
		JScrollPane s2=new JScrollPane(com2);
		c.add(s2);
		
		time=new JTextField("---",2);
		c.add(time);
		
		price=new JTextField("---",8);
		c.add(price);
		
		setSize(480,640);
		setVisible(true);
	}
	public static void main(String[] args) {
		test1 obj=new test1();
		obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		  
		 
		 
		 Restaurant x2=new Restaurant();
		Scanner iscan=new Scanner(System.in);
		List<Restaurant> res = new ArrayList<Restaurant>();
		try {
			File file=new File("C:\\Users\\황은지\\Desktop\\Softengineering_Test1\\src\\목록.txt");
			Scanner fscan=new Scanner(file);

			while(fscan.hasNextLine()){
				Restaurant x1=new Restaurant();
				String[] temp=(fscan.nextLine()).split(" ");
				x1.name=temp[0];
				//System.out.println(x1.name);
				x1.type=Integer.parseInt(temp[1]);
				//System.out.println(x1.type);
				x1.location=Integer.parseInt(temp[2]);
				//System.out.println(x1.location);
				x1.start_time=Integer.parseInt(temp[3]);
				//System.out.println(x1.start_time);
				x1.finish_time=Integer.parseInt(temp[4]);
				//System.out.println(x1.finish_time);
				x1.price=Integer.parseInt(temp[5]);
				//System.out.println(x1.price);
				res.add(x1);
			}
		}catch(FileNotFoundException e) {
			System.out.println("파일을 열지 못합니다");
		}catch(NumberFormatException e){
			System.out.println("입력형식 맞지않음");
		}

		System.out.println(">> Restaurant형 정보를 입력하세요");

		System.out.println("식당 이름은?");
		x2.name=iscan.next();
		System.out.println("원하는 분류는? (1:한식, 2:일식, 3:양식 , 4:중식, 5:기타)");
		x2.type=iscan.nextInt();
		System.out.println("원하는 위치는? (1:정문(쪽문), 2:북문, 3:동문, 4:서문)");
		x2.location=iscan.nextInt();
		System.out.println("원하는 시간은?");
		x2.start_time=iscan.nextInt();
		x2.finish_time=x2.start_time;
		System.out.println("원하는 가격은?");
		x2.price=iscan.nextInt();

		System.out.println("입력한 정보는..");
		System.out.println(">> name:"+x2.name+" type:"+x2.type+" location:"+x2.location+" time:"+x2.start_time+" price:"+x2.price+" 입니다");


		for (int i = 0; i < res.size(); i++) {
			//System.out.println(res.get(i).location);
			if(res.get(i).searchInfo(x2)==true) { 
				res.get(i).showShort(); 
			}
		}
		
		
	System.out.println("몇번 식당 조회?(0부터~)");
	int num=iscan.nextInt();
	System.out.println("********"+num+" 번 식당의 정보는...***************");
	res.get(num).showInfo();
	System.out.println("**************************************");
		 
		/*
	for (int i = 0; i < res.size(); i++) {
		   res.get(i).showInfo(); }
		 */
	}
}
