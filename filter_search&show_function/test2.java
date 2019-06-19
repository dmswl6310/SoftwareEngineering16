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
	String ttitle[] = { "�̸�", "�з�", "��ġ", "���½ð�", "�ݴ½ð�", "��������" };
	JTable table;
	String data[][];

	public void filescan(Restaurant choice) {

		Restaurant x2 = new Restaurant();
		res = new ArrayList<Restaurant>();

		try {
			File file = new File("C:\\Users\\Ȳ����\\Desktop\\Softengineering_Test1\\src\\���.txt");
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

		for (int i = 0; i < res.size(); i++) {
			if (res.get(i).searchInfo(choice) == false) {
				res.remove(i--);
			}
		}

	}

	public test2(Restaurant x) {

		super("�Ĵ� ��� ȭ��");
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

		// ��ü ���̾ƿ�-���� (title: ȭ���̸�, center: �Ĵ���);
		setLayout(new BorderLayout());
		title = new JPanel(new BorderLayout());
		list = new JPanel(new BorderLayout());
		
		//title���� ���Ѱ���
		Label t = new Label("�Ĵ� �˻� ���");
		title.add(t);
		
		//list���� ��ũ�� �޸� ���̺�
		table = new JTable(data, ttitle);
		JScrollPane sp = new JScrollPane(table);
		list.add(sp, BorderLayout.CENTER);

		// �ֻ��� ���̾ƿ��� �߰�
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
