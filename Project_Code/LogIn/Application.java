package LogIn;

import javax.swing.JFrame;

public class Application {
	// temporarily DB create
	public static Member[] DB = new Member[10];
	public static int top = -1;
	public static int UN = 0; // User Number
	public static JFrame window = new JFrame("window"); // â...?
	
	
	
	
	public static void main(String[] args) {
		LogIn L = new LogIn();
		//Sign_Up S = new Sign_Up();
		// ���α׷��� ó���� �׻� �α��� ȭ������ ������
		Application.window.setSize(480, 640);
		Application.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Application.window.setResizable(false);
		
		
		
		Application.window.setVisible(true);
		
	}
	
}
