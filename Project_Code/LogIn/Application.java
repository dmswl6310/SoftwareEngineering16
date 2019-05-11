package LogIn;

import javax.swing.JFrame;

public class Application {
	// temporarily DB create
	public static Member[] DB = new Member[10];
	public static int top = -1;
	public static int UN = 0; // User Number
	public static JFrame window = new JFrame("window"); // 창...?
	
	
	
	
	public static void main(String[] args) {
		LogIn L = new LogIn();
		//Sign_Up S = new Sign_Up();
		// 프로그램의 처음은 항상 로그인 화면으로 시작함
		Application.window.setSize(480, 640);
		Application.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Application.window.setResizable(false);
		
		
		
		Application.window.setVisible(true);
		
	}
	
}
