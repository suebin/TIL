public class CellPhoneTest {

	public static void main(String[] args) {
		CellPhone myPhone = new CellPhone("GALAXY-7");

//20분간 충전을 한다.
		myPhone.charge(20);
		myPhone.printBattery();

//300분간 통화를 한다.
		myPhone.call(300);
		myPhone.printBattery();

//50분간 충전을 한다.
		myPhone.charge(50);
		myPhone.printBattery();

//40분간 통화를 한다.
		myPhone.call(40); // 40분간 통화를 한다.
		myPhone.printBattery();

//통화시간입력오류
		try {
			myPhone.call(-20);
			myPhone.printBattery();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		try {
			myPhone.charge(-20);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		CellPhone yourPhone = new CellPhone("galaxy-7");

		if (myPhone.isSame(yourPhone)) {
			System.out.println("동일 모델입니다.");
		} else {
			System.out.println("다른 모델입니다.");
		}
	}

}

class CellPhone {
	String model;
	double battery;

	CellPhone(String model) {
		this.model = model;
	}

	// 통화 시간(분)을 출력하고, 통화 시간에 따라 배터리 양을 감소시킨다.
	void call(int time) throws IllegalArgumentException {

		if (time < 0) {
			throw new IllegalArgumentException("통화시간입력오류");
		}

		battery -= time * 0.5;
		if (battery < 0) {
			battery = 0;
		}

		System.out.println("통화 시간 : " + time + "분");

	}

	// 충전한 시간(분)을 출력하고, 충전한 시간에 따라 배터리 양을 증가시킨다.
	void charge(int time) throws IllegalArgumentException {

		if (time < 0) {
			throw new IllegalArgumentException("충전시간입력오류");
		}

		battery += time * 3;
		if (battery > 100) {
			battery = 100;
		}
		System.out.println("충전 시간 : " + time + "분");
	}

	// 남은 배터리 양을 출력한다.
	void printBattery() {
		System.out.println("남은 배터리 양 : " + battery);
	}

	// CellPhone 타입의 객체를 입력받고, 입력받은 객체의 모델 번호가 같은 경우에 true를 리턴한다.
	boolean isSame(CellPhone other) {
		return model.equalsIgnoreCase(other.model);

	}

}