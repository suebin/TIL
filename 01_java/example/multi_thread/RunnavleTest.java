// 상속을 이미 받고 있는 경우 Runnable 인터페이스를 상속받는다!
class B implements Runnable {
	String name;

	B(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(name + "스레드 = " + i);
		}
	}

}

public class RunnableTest {

	public static void main(String[] args) {

		// Runnable의 하위클래스 B 객체 생성
		B a1 = new B("one"); // 형변환 규칙에 의해 Runnable a1 = new Runnable() 과 같다고 할 수 있다.
		B a2 = new B("two");

		// Thread 객체 생성
		Thread ta1 = new Thread(a1);
		Thread ta2 = new Thread(a2);

		// Thread 객체의 start 호출
		ta1.start();
		ta2.start();

		System.out.println("main 종료");
	}

}
