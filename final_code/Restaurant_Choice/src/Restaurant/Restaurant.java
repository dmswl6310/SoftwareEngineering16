package Restaurant;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Restaurant {
	String name; // �̸�=> 10�ڸ� ����
	int type; // �з�=> 1:�ѽ�, 2:�Ͻ�, 3:��� , 4:�߽�, 5:��Ÿ
	int location; // ��ġ=> 1:����(�ʹ�), 2:�Ϲ�, 3:����, 4:����
	int start_time; // �ð�=> ���ڸ�����
	int finish_time;
	int price; // ����(�ּҰ���-���̵帻�� �Ϲݸ޴�����..)=> 10�ڸ� ����
	// �̸� : '*'�� ���ϵ� ����, ������ : 0�� ���ϵ� ����
	// ������ ������ �ð��� ���� �� ����
	// �Ĵ� �߰� �� Restaurant�� �����͸� ������ ���Ͽ� �߰� ����Ѵ�.

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
			System.out.println("������ �����ϴ�");
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