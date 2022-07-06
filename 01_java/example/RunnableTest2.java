// 중첩 인터페이스
// 무명 클래스 정의
// Runnable 하위 클래스 객체 생성
public class RunnableTest2 {

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("스레드 = " + i);
				}
			}

		};

		// B a1 = new B("one");

		Thread ta1 = new Thread(r1);

		ta1.start();

		System.out.println("main 종료");
	}

}
