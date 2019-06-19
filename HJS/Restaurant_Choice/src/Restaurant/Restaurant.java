package Restaurant;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Restaurant {
	String name; // 이름=> 10자리 이하
	int type; // 분류=> 1:한식, 2:일식, 3:양식 , 4:중식, 5:기타
	int location; // 위치=> 1:정문(쪽문), 2:북문, 3:동문, 4:서문
	int start_time; // 시간=> 두자리이하
	int finish_time;
	int price; // 가격(최소가격-사이드말고 일반메뉴에서..)=> 10자리 이하
	// 이름 : '*'이 와일드 문자, 나머지 : 0이 와일드 문자
	// 계절과 날씨는 시간이 남을 시 구현
	// 식당 추가 시 Restaurant형 데이터를 지정한 파일에 추가 기록한다.

	void showShort() {
		System.out.println(">> name:" + this.name + " type:" + this.type + " location:" + this.location + " start_time:"
				+ this.start_time + " finish_time:" + this.finish_time + " price:" + this.price);
	}

	void showInfo() {
		File resinfo = new File("restaurant_index\\" + name + ".txt");
		try {
			Scanner rscan = new Scanner(resinfo);
			while (rscan.hasNextLine()) {
				System.out.println(rscan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다");
		}
	}

	boolean searchInfo(Restaurant input) {

		if ((input.name.equals("*") || input.name.equals(this.name)) 
				&& (input.type == 0 || input.type == this.type)
				&& (input.location == 0 || input.location == this.location)
				&& (input.start_time == 0 || input.start_time >= this.start_time)
				&& (input.finish_time <= this.finish_time) && (input.price == 0 || input.price >= this.price)) {
			return true;
		} else {
			return false;
		}
	}
}