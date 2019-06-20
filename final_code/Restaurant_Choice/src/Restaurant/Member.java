package Restaurant;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.io.BufferedWriter;
import java.io.File;


public class Member{
	
	private String name;
	private String birth;
	private String ID;
	private String PW;
	private String Email;
	private int UserNumber;
	boolean IsMember = false;
	
		
	public String getID() {
		return ID;
	}
	
	public void setID(String new_ID) {
		ID = new_ID;
	}	
	
	public String getPW() {
		return PW;
	}
	
	public void setPW(String new_PW) {
		PW = new_PW;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String new_name) {
		name = new_name;
	}
	
	public String getbirth() {
		return birth;
	}
	
	public void setbirth(String new_birth) {
		birth = new_birth;
	}
	
		
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String new_Email) {
		Email = new_Email;
	}
	
	public int getUserNumber() {
		return UserNumber;
	}
	
	public void setUserNumber(int new_UserNumber) {
		UserNumber = new_UserNumber;
	}
	
	
	
	public void create(String name, String birth, String ID, String PW, String Email) {
		String input = null;
		input = "\r\n" + name + " " + birth + " " + ID + " " + PW + " " + ++Application.top + " " + Email;
		// 넣을 문자열 생성
		
		InputStreamReader isr = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		
		
		try {
			File file = new File("member.txt");
			bw = new BufferedWriter(new FileWriter(file, true));
			pw = new PrintWriter(bw, true);
			
			pw.write(input);
			pw.flush();
			
			Application.DB[Application.top].name = name;
			Application.DB[Application.top].birth = birth;
			Application.DB[Application.top].ID = ID;
			Application.DB[Application.top].PW = PW;
			Application.DB[Application.top].Email = Email;
			Application.DB[Application.top].UserNumber = Application.top;
			Application.DB[Application.top].IsMember = true;
			
			
			
			System.out.println(input);
		}catch(IOException e){
			e.printStackTrace();
			
		}finally {
			pw.close();
		}
		
		
		
		
		
		
	}
	
	public void print() {
		System.out.printf("Name : %s\n", this.getname());
		System.out.printf("생년월일 : %s\n", this.getbirth());
		System.out.printf("ID : %s\n", this.getID());
		System.out.printf("PW : %s\n", this.getPW());
		System.out.printf("UserNumber : %d\n", this.getUserNumber());
		System.out.printf("E-mail : %s\n", this.getEmail());
		
	}
	
	
	
	
	
	
	
}
