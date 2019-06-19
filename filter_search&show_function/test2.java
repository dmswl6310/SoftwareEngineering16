import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	String ttitle[] = { "이름", "분류", "위치", "여는시간", "닫는시간", "최저가격" };
	JTable table;
	String data[][];

	public void filescan(Restaurant choice) {

		Restaurant x2 = new Restaurant();
		res = new ArrayList<Restaurant>();

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
			}
		}

	}

	public test2(Restaurant x) {

		super("식당 목록 화면");
		this.filescan(x);
		data = new String[res.size()][10];
		for (int i = 0; i < res.size(); i++) {
			data[i][0] = res.get(i).name;
			data[i][1] = String.valueOf(res.get(i).type);
			data[i][2] = String.valueOf(res.get(i).location);
			data[i][3] = String.valueOf(res.get(i).start_time);
			data[i][4] = String.valueOf(res.get(i).finish_time);
			data[i][5] = String.valueOf(res.get(i).price);
		}

		// 전체 레이아웃-보더 (title: 화면이름, center: 식당목록);
		setLayout(new BorderLayout());
		title = new JPanel(new BorderLayout());
		list = new JPanel(new BorderLayout());
		
		//title에는 라벨한개만
		Label t = new Label("식당 검색 결과");
		title.add(t);
		
		//list에는 스크롤 달린 테이블만
		table = new JTable(data, ttitle);
		JScrollPane sp = new JScrollPane(table);
		list.add(sp, BorderLayout.CENTER);

		// 최상위 레이아웃에 추가
		add(BorderLayout.CENTER, list);
		add(BorderLayout.NORTH, title);

		setSize(480, 640);
		setVisible(true);
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				//System.out.println(row);
				test3 obj3=new test3(res.get(row));
				obj3.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});

	}
}
