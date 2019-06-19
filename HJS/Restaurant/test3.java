package Restaurant;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class test3 extends JFrame {

	String name;
	JPanel title;
	JPanel info;

	String content;
	JTextField show;
	JLabel la;
	ImageIcon img;

	public test3(Restaurant r) {

		super("상세 검색 화면");
		this.name = r.name;
		content = "";
		File resinfo = new File("C:\\Users\\황은지\\Desktop\\Softengineering_Test1\\SE_Project\\src\\" + this.name + ".txt");
		img = new ImageIcon("C:\\Users\\황은지\\Desktop\\Softengineering_Test1\\SE_Project\\src\\" + this.name +".jpg");
		
		setLayout(new BorderLayout());
		title = new JPanel(new BorderLayout());
		info = new JPanel(new BorderLayout());
		
		Label t = new Label(this.name);
		title.add(t);
		
		try {
			Scanner rscan = new Scanner(resinfo);
			rscan.nextLine();
			while (rscan.hasNextLine()) {
				content += (rscan.nextLine());
			}
		} catch (FileNotFoundException e) {
			content += "파일이 없습니다";
		}

		show = new JTextField(content);
		la =new JLabel("그림없음",img,SwingConstants.CENTER);
		info.add(BorderLayout.CENTER,show);
		info.add(BorderLayout.SOUTH,la);
		
		add(BorderLayout.NORTH, title);
		add(BorderLayout.CENTER, info);
		
		setSize(480, 640);
		setVisible(true);
	}

}