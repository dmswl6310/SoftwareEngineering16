import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class test2 extends JFrame {
	
	JPanel title;
	JPanel list;
	List<Restaurant> res;
	//List resShort;
	String ttitle[]= {"이름","분류","위치","여는시간","닫는시간","최저가격"};
	//String data;
	// 그냥 위에 꺼 써도 될
	JTable table;
	String data[][];
	//{{"ㅈㅈ","ㄷ","ㄷ","ㄷ","ㄷ","ㄷ"},{"ㅈㅈ","ㄷ","ㄷ","ㄷ","ㄷ","ㄷ"}};
	public void filescan (Restaurant choice) {
		
		Restaurant x2 = new Restaurant();
		res = new ArrayList<Restaurant>();
		//resShort= new ArrayList();
		
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
	
	for (int i = 0; i < res.size(); i++) {
		if (res.get(i).searchInfo(choice) == false) {
			res.remove(i--);
			continue;
		}
		//resShort.add((Component)(res.;get(i).name));
	}
	
	}

	//JPanel filter;
	//JPanel find
	//JComboBox<String> com1, com2;
	//JTextField name, time, price;
	//String type[] = { "---", "한식", "일식", "양식", "중식", "기타" };
	//String location[] = { "---", "정문(쪽문)", "북문", "동문", "서문" };

	public test2(Restaurant x) {
	
		this.filescan(x);
		data=new String[res.size()][10];
		for(int i=0;i<res.size();i++) {
		data[i][0]=res.get(i).name;
		data[i][1]=String.valueOf(res.get(i).type);
		data[i][2]=String.valueOf(res.get(i).location);
		data[i][3]=String.valueOf(res.get(i).start_time);
		data[i][4]=String.valueOf(res.get(i).finish_time);
		data[i][5]=String.valueOf(res.get(i).price);
		// 여기 테스트 해볼껄 
		}
		
		// 전체 레이아웃-보더 (title: 화면이름, center: 식당목록);
		//super("식당 목록 화면");
		setLayout(new BorderLayout());
		title = new JPanel(new BorderLayout());
		list = new JPanel(new BorderLayout());

		// title패널에는 화면제목 출력
		Label t = new Label("식당 검색 결과");
		//t.setAlignment(Label.CENTER);
        
		title.add(t);	
		table=new JTable(data,ttitle);

		JScrollPane sp=new JScrollPane(table);
		
		list.add(sp,BorderLayout.CENTER);
		//list.
		//list.add(new JScrollPane(res.get(1).name));
		
		
		//filter.add(name);

		//filter.add(t2);
		//filter.add(s1);
		//filter.add(t3);
		//filter.add(s2);
		//filter.add(t4);
		//filter.add(time);
		//filter.add(t5);
		//filter.add(price);

		// find패널에는 찾기버튼만 들어감
		//JButton btn = new JButton("찾  기");
		//find.add(BorderLayout.CENTER, btn);

		// 최상위 레이아웃에 추가
		add(BorderLayout.CENTER, list);
		add(BorderLayout.NORTH, title);

		// 찾기 버튼에 filter 패널의 라벨들 입력값 받기
		/*btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Restaurant r1 = new Restaurant();
				r1.name = name.getText();
				r1.type = com1.getSelectedIndex();
				r1.location = com2.getSelectedIndex();
				r1.start_time = Integer.parseInt(time.getText());
				r1.finish_time = Integer.parseInt(time.getText());
				r1.price = Integer.parseInt(price.getText());
			}
		});
*/
		setSize(480, 640);
		setVisible(true);

	}
}
