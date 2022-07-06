// 스레드들이 객체를 공유해서 작업하는 경우

// 누가 Data 객체에 값을 먼저 저장했느냐에 따라 출력값이 달라진다.
// 그건 알 수가 없다는 문제가 있음!
// 그러므로 "synchronized"를 붙인다.

// 동기화 메소드 정의 : 2개 이상 스레드 동시 동기화 메소드 수행 x, 1개 수행하는 동안 1개 스레드 대기
// 속도는 느려진다.
class Data {
	int value;

	public synchronized void saveValue(int value) {
		this.value = value;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " : " + this.value);
	}
}

class DataThread1 extends Thread {
	Data d;

	DataThread1(String name, Data d) {
		super(name);
		this.d = d;
	}

	public void run() {
		d.saveValue(10);
	}
}

class DataThread2 extends Thread {
	Data d;

	DataThread2(String name, Data d) {
		super(name);
		this.d = d;
	}

	public void run() {
		d.saveValue(20);
	}
}

public class SynchronizedTest {

	public static void main(String[] args) {
		Data d = new Data();
		DataThread1 t1 = new DataThread1("스레드1", d);
		DataThread2 t2 = new DataThread2("스레드2", d);

		/*
		 * if (t1.d == t2.d) { // 같은 객체 공유 2개 스레드 System.out.println("같다"); }
		 */

		t1.start();
		t2.start();
	}

}

