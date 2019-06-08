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
	String type[]= {"---","�ѽ�","�Ͻ�","���","�߽�","��Ÿ"};
	String location[]= {"---","����(�ʹ�)","�Ϲ�","����","����"};
	public test1() {
		super("�Ĵ� �˻� ȭ��");
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
			File file=new File("C:\\Users\\Ȳ����\\Desktop\\Softengineering_Test1\\src\\���.txt");
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
			System.out.println("������ ���� ���մϴ�");
		}catch(NumberFormatException e){
			System.out.println("�Է����� ��������");
		}

		System.out.println(">> Restaurant�� ������ �Է��ϼ���");

		System.out.println("�Ĵ� �̸���?");
		x2.name=iscan.next();
		System.out.println("���ϴ� �з���? (1:�ѽ�, 2:�Ͻ�, 3:��� , 4:�߽�, 5:��Ÿ)");
		x2.type=iscan.nextInt();
		System.out.println("���ϴ� ��ġ��? (1:����(�ʹ�), 2:�Ϲ�, 3:����, 4:����)");
		x2.location=iscan.nextInt();
		System.out.println("���ϴ� �ð���?");
		x2.start_time=iscan.nextInt();
		x2.finish_time=x2.start_time;
		System.out.println("���ϴ� ������?");
		x2.price=iscan.nextInt();

		System.out.println("�Է��� ������..");
		System.out.println(">> name:"+x2.name+" type:"+x2.type+" location:"+x2.location+" time:"+x2.start_time+" price:"+x2.price+" �Դϴ�");


		for (int i = 0; i < res.size(); i++) {
			//System.out.println(res.get(i).location);
			if(res.get(i).searchInfo(x2)==true) { 
				res.get(i).showShort(); 
			}
		}
		
		
	System.out.println("��� �Ĵ� ��ȸ?(0����~)");
	int num=iscan.nextInt();
	System.out.println("********"+num+" �� �Ĵ��� ������...***************");
	res.get(num).showInfo();
	System.out.println("**************************************");
		 
		/*
	for (int i = 0; i < res.size(); i++) {
		   res.get(i).showInfo(); }
		 */
	}
}
