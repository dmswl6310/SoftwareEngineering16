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
//자바 줄맞춤 : ctrl + shift + F
import javax.swing.SwingConstants;

public class test1 extends JFrame {
	
	JPanel top;
	JPanel filter;
	JPanel find;
	Label title;
	JComboBox<String> com1, com2;
	JTextField name, time, price;
	String type[] = { "---", "한식", "일식", "양식", "중식", "기타" };
	String location[] = { "---", "정문(쪽문)", "북문", "동문", "서문" };

	public test1() {

		// 전체 레이아웃-보더 (center: filter(스크롤과 텍스트 박스들), south: 찾기버튼);
		//super("식당 검색 화면");
		setLayout(new BorderLayout());
		
		filter = new JPanel(new GridLayout(5, 2));
		find = new JPanel(new BorderLayout());
		top=new JPanel();
		// filter 패널에는 라벨들과 텍스트,스크롤박스 들어감
		Label t1 = new Label("식당이름",Label.CENTER);
		t1.setFont(new Font("Times New Roman", 20,20));
		Label t2 = new Label("분류",Label.CENTER);
		t2.setFont(new Font("Times New Roman", 20,20));
		Label t3 = new Label("위치",Label.CENTER);
		t3.setFont(new Font("Times New Roman", 20,20));
		Label t4 = new Label("방문시각",Label.CENTER);
		t4.setFont(new Font("Times New Roman", 20,20));
		Label t5 = new Label("가격",Label.CENTER);
		t5.setFont(new Font("Times New Roman", 20,20));
		
		title=new Label("식당 검색 화면");
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

		// find패널에는 찾기버튼만 들어감
		JButton btn = new JButton("찾  기");
		find.add(BorderLayout.CENTER, btn);

		// 최상위 레이아웃에 추가
		add(BorderLayout.CENTER, filter);
		add(BorderLayout.SOUTH, find);
		add(BorderLayout.NORTH,top);
		// 찾기 버튼에 filter 패널의 라벨들 입력값 받기
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
		obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		fileScan();
		
	}

	public static void fileScan() {

		// Restaurant형 list인 res에다가 파일로 읽은 Restaurant형들 자료를 넣는다
		Restaurant x2 = new Restaurant();
		Scanner iscan = new Scanner(System.in);
		List<Restaurant> res = new ArrayList<Restaurant>();
		try {
			File file = new File("C:\\Users\\황은지\\Desktop\\Softengineering_Test1\\src\\목록.txt");
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
			System.out.println("파일을 열지 못합니다");
		} catch (NumberFormatException e) {
			System.out.println("입력형식 맞지않음");
		}

		// 원하는 정보를 입력받는다.
		System.out.println(">> Restaurant형 정보를 입력하세요");

		System.out.println("식당 이름은?");
		x2.name = iscan.next();
		System.out.println("원하는 분류는? (1:한식, 2:일식, 3:양식 , 4:중식, 5:기타)");
		x2.type = iscan.nextInt();
		System.out.println("원하는 위치는? (1:정문(쪽문), 2:북문, 3:동문, 4:서문)");
		x2.location = iscan.nextInt();
		System.out.println("원하는 시간은?");
		x2.start_time = iscan.nextInt();
		x2.finish_time = x2.start_time;
		System.out.println("원하는 가격은?");
		x2.price = iscan.nextInt();

		// 입력정보와 필터링 거쳐나온 결과 표시
		System.out.println("\n입력한 정보는..");
		System.out.println(">> name:" + x2.name + " type:" + x2.type + " location:" + x2.location + " time:"
				+ x2.start_time + " price:" + x2.price + " 입니다\n");

		System.out.println("해당되는 식당정보는..");
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i).searchInfo(x2) == false) {
				res.remove(i--);
			}
		}

		for (int i = 0; i < res.size(); i++) {
			res.get(i).showShort();
		}

		// 나온 결과중 더 자세한 정보를 원할 시 보여줌
		System.out.println("\n몇번 식당 조회?(0부터~)");
		int num = iscan.nextInt();
		System.out.println("\n******** " + num + "번 식당의 정보는... ***************");
		res.get(num).showInfo();
		System.out.println("****************************************");
	}
}