class A extends Thread {

	A(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(getName() + " 의 우선순위 = " + getPriority());
		for (int i = 1; i <= 100; i++) {
			try {
				Thread.sleep(1000); // 1초 간 스레드를 일시 중단
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + "스레드 = " + i);
		}
	}

}

public class ThreadPriorityTest {

	public static void main(String[] args) {
		A a1 = new A("one");
		A a2 = new A("two");

		a1.setPriority(Thread.MIN_PRIORITY); // 1
		a2.setPriority(Thread.MAX_PRIORITY); // 10
		// = 실행 시간이 동일할 경우 two가 먼저 실행 완료할 "가능성"이 크다.

		a1.start();
		a2.start();

		System.out.println("main 종료");
	}

}
