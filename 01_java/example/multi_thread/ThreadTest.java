// Thread 상속하면 run() Override 필수
class A extends Thread {
	// 변수 생성자 메소드 추가
	/*
	 * String name;
	 * 
	 * A(String name) { this.name = name; }
	 */
	A(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			// System.out.println(name + "스레드 = " + i);
			System.out.println(getName() + "스레드 = " + i);
			// getName() = 자동으로 new한 순서대로 알아서 멀티 스레드의 이름을 부여 (사용하려면 이 예제 안의 변수, 매개변수, 생성자는
			// 없애야 한다.)

		}
	}

}

// 여기서는 스레드가 3개!
public class ThreadTest {
	// 모든 스레드는 객체를 생성하고 start로 꼭 호출! (start() 호출하면 run() 실행)
	public static void main(String[] args) {
		A a1 = new A("one");
		A a2 = new A("two");
		// 멀티 스레드 : a1스레드와 a2스레드가 동시에 뒤섞여서 실행 (매번 실행 결과 순서가 일정하지 x, 1번에 CPU가 여러개 스레드를
		// 실행하는 구조)
		a1.start(); // a1만 있을 때 : run()호출하는 시점에서 CPU가 실행중인 메소드는 main -> 대기하다가 main 끝나면 run() 실행
		a2.start();

		System.out.println("main 종료");
	}

}
