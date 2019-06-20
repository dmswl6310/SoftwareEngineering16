package Restaurant;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
//�ڹ� �ٸ��� : ctrl + shift + F
import javax.swing.SwingConstants;

public class test1 extends JPanel {
	
	JPanel top;
	JPanel filter;
	JPanel find;
	Label title;
	JComboBox<String> com1, com2;
	JTextField name, time, price;
	String type[] = { "---", "�ѽ�", "�Ͻ�", "���", "�߽�", "��Ÿ" };
	String location[] = { "---", "����(�ʹ�)", "�Ϲ�", "����", "����" };

	public test1() {

		// ��ü ���̾ƿ�-���� (center: filter(��ũ�Ѱ� �ؽ�Ʈ �ڽ���), south: ã���ư);
		//super("�Ĵ� �˻� ȭ��");
		setLayout(new BorderLayout());
		
		filter = new JPanel(new GridLayout(5, 2));
		find = new JPanel(new BorderLayout());
		top=new JPanel();
		// filter �гο��� �󺧵�� �ؽ�Ʈ,��ũ�ѹڽ� ��
		Label t1 = new Label("�Ĵ��̸�",Label.CENTER);
		t1.setFont(new Font("Times New Roman", 20,20));
		Label t2 = new Label("�з�",Label.CENTER);
		t2.setFont(new Font("Times New Roman", 20,20));
		Label t3 = new Label("��ġ",Label.CENTER);
		t3.setFont(new Font("Times New Roman", 20,20));
		Label t4 = new Label("�湮�ð�",Label.CENTER);
		t4.setFont(new Font("Times New Roman", 20,20));
		Label t5 = new Label("����",Label.CENTER);
		t5.setFont(new Font("Times New Roman", 20,20));
		
		title=new Label("�Ĵ� �˻� ȭ��");
		title.setFont(new Font("Times New Roman",20,20));
		//title.setBorder(EtchedBorder);
		top.add(title);
		com1 = new JComboBox<String>(type);
		JScrollPane s1 = new JScrollPane(com1);

		com2 = new JComboBox<String>(location);
		JScrollPane s2 = new JScrollPane(com2);

		name = new JTextField("---", 10);
		time = new JTextField("---", 2);
		price = new JTextField("---", 8);

		filter.add(t1);
		filter.add(name);
		filter.add(t2);
		filter.add(s1);
		filter.add(t3);
		filter.add(s2);
		filter.add(t4);
		filter.add(time);
		filter.add(t5);
		filter.add(price);

		// find�гο��� ã���ư�� ��
		JButton btn = new JButton("ã  ��");
		find.add(BorderLayout.CENTER, btn);

		// �ֻ��� ���̾ƿ��� �߰�
		add(BorderLayout.CENTER, filter);
		add(BorderLayout.SOUTH, find);
		add(BorderLayout.NORTH,top);
		// ã�� ��ư�� filter �г��� �󺧵� �Է°� �ޱ�
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Restaurant r1 = new Restaurant();
				if((name.getText()).equals("---")) {
					r1.name="*";
				}else {
					r1.name=name.getText();
				}
				r1.type = com1.getSelectedIndex();
				r1.location = com2.getSelectedIndex();
				if((time.getText()).equals("---")){
					r1.start_time=0;
					r1.finish_time=0;
				}else {
				r1.start_time = Integer.parseInt(time.getText());
				r1.finish_time = Integer.parseInt(time.getText());
				}
				
				if((price.getText()).equals("---")) {
					r1.price=0;
				}
				else{
					r1.price = Integer.parseInt(price.getText());
				}
				
				test2 obj2=new test2(r1);
				//obj2.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}

		});

		setSize(480, 640);
		setVisible(true);
	}

	

	// public class FindClickEvent implements ActionListener{
	//
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// System.out.print

	// }
	// }

	public static void main(String[] args) {

		test1 obj = new test1();
		//test2 obj2 = new test2();
		//obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		fileScan();
		
	}

	public static void fileScan() {

		// Restaurant�� list�� res���ٰ� ���Ϸ� ���� Restaurant���� �ڷḦ �ִ´�
		Restaurant x2 = new Restaurant();
		Scanner iscan = new Scanner(System.in);
		List<Restaurant> res = new ArrayList<Restaurant>();
		try {
			File file = new File("restaurant_index\\���.txt");
			Scanner fscan = new Scanner(file);

			while (fscan.hasNextLine()) {

				Restaurant x1 = new Restaurant();
				String[] temp = (fscan.nextLine()).split(" ");
				x1.name = temp[0];
				// System.out.println(x1.name);
				x1.type = Integer.parseInt(temp[1]);
				// System.out.println(x1.type);
				x1.location = Integer.parseInt(temp[2]);
				// System.out.println(x1.location);
				x1.start_time = Integer.parseInt(temp[3]);
				// System.out.println(x1.start_time);
				x1.finish_time = Integer.parseInt(temp[4]);
				// System.out.println(x1.finish_time);
				x1.price = Integer.parseInt(temp[5]);
				// System.out.println(x1.price);
				res.add(x1);

			}
		} catch (FileNotFoundException e) {
			System.out.println("������ ���� ���մϴ�");
		} catch (NumberFormatException e) {
			System.out.println("�Է����� ��������");
		}

		// ���ϴ� ������ �Է¹޴´�.
		System.out.println(">> Restaurant�� ������ �Է��ϼ���");

		System.out.println("�Ĵ� �̸���?");
		x2.name = iscan.next();
		System.out.println("���ϴ� �з���? (1:�ѽ�, 2:�Ͻ�, 3:��� , 4:�߽�, 5:��Ÿ)");
		x2.type = iscan.nextInt();
		System.out.println("���ϴ� ��ġ��? (1:����(�ʹ�), 2:�Ϲ�, 3:����, 4:����)");
		x2.location = iscan.nextInt();
		System.out.println("���ϴ� �ð���?");
		x2.start_time = iscan.nextInt();
		x2.finish_time = x2.start_time;
		System.out.println("���ϴ� ������?");
		x2.price = iscan.nextInt();

		// �Է������� ���͸� ���ĳ��� ��� ǥ��
		System.out.println("\n�Է��� ������..");
		System.out.println(">> name:" + x2.name + " type:" + x2.type + " location:" + x2.location + " time:"
				+ x2.start_time + " price:" + x2.price + " �Դϴ�\n");

		System.out.println("�ش�Ǵ� �Ĵ�������..");
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i).searchInfo(x2) == false) {
				res.remove(i--);
			}
		}

		for (int i = 0; i < res.size(); i++) {
			res.get(i).showShort();
		}

		// ���� ����� �� �ڼ��� ������ ���� �� ������
		System.out.println("\n��� �Ĵ� ��ȸ?(0����~)");
		int num = iscan.nextInt();
		System.out.println("\n******** " + num + "�� �Ĵ��� ������... ***************");
		res.get(num).showInfo();
		System.out.println("****************************************");
	}
}