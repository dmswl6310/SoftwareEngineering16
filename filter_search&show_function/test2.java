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
	String ttitle[]= {"�̸�","�з�","��ġ","���½ð�","�ݴ½ð�","��������"};
	//String data;
	// �׳� ���� �� �ᵵ ��
	JTable table;
	String data[][];
	//{{"����","��","��","��","��","��"},{"����","��","��","��","��","��"}};
	public void filescan (Restaurant choice) {
		
		Restaurant x2 = new Restaurant();
		res = new ArrayList<Restaurant>();
		//resShort= new ArrayList();
		
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
			continue;
		}
		//resShort.add((Component)(res.;get(i).name));
	}
	
	}

	//JPanel filter;
	//JPanel find
	//JComboBox<String> com1, com2;
	//JTextField name, time, price;
	//String type[] = { "---", "�ѽ�", "�Ͻ�", "���", "�߽�", "��Ÿ" };
	//String location[] = { "---", "����(�ʹ�)", "�Ϲ�", "����", "����" };

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
		// ���� �׽�Ʈ �غ��� 
		}
		
		// ��ü ���̾ƿ�-���� (title: ȭ���̸�, center: �Ĵ���);
		//super("�Ĵ� ��� ȭ��");
		setLayout(new BorderLayout());
		title = new JPanel(new BorderLayout());
		list = new JPanel(new BorderLayout());

		// title�гο��� ȭ������ ���
		Label t = new Label("�Ĵ� �˻� ���");
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

		// find�гο��� ã���ư�� ��
		//JButton btn = new JButton("ã  ��");
		//find.add(BorderLayout.CENTER, btn);

		// �ֻ��� ���̾ƿ��� �߰�
		add(BorderLayout.CENTER, list);
		add(BorderLayout.NORTH, title);

		// ã�� ��ư�� filter �г��� �󺧵� �Է°� �ޱ�
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
