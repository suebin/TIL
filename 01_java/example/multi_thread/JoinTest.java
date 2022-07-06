class C extends Thread {
	int data = 10;

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		data = data * 2;
		System.out.println("run메소드 = " + data);
	}
}

public class JoinTest {

	public static void main(String[] args) { // main 시스템 내장 스레드
		System.out.println("main 시작");
		C c1 = new C(); // 멀티 스레드 객체 생성 / c1.date => 10
		c1.start(); // run 실행준비 / (실행전) c1. data => 10, (실행후) c1.data => 20

		try {
			c1.join(); // CPU가 c1 스레드 실행 변경, c1.run 수행
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(c1.data); // run 수행결과 출력
		System.out.println("main 종료");

	}

}