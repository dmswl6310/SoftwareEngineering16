package LogIn;

public class Member extends User{
	private String ID;
	private String PW;
	private String name;
	private String Email;
	private int UserNumber;
	private boolean IsMember = true;
	
		
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
	
	public int getUserNumber() {
		return UserNumber;
	}
	
	public void setUserNumber(int new_UserNumber) {
		UserNumber = new_UserNumber;
	}
	
	
}
