class MusicThread extends Thread {
	// 상속 . 생성자. 오버라이딩 - 음악듣는중입니다 3번 출력
	MusicThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			System.out.println(getName()+"듣는 중입니다.");
		}
	}

}

class DownloadThread extends Thread {
	// 상속 . 생성자. 오버라이딩 - 다운로드중입니다 10번 출력
	DownloadThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(getName()+" 중입니다.");
		}
	}
}

class NewsThread extends Thread {
	// 상속 . 생성자. 오버라이딩 - 뉴스보는 중입니다 5번 출력
	NewsThread (String name) {
		super(name);
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(getName()+"보는 중입니다.");
		}
	}
}

public class MyThreadTest {
	public static void main(String[] args) {
		Thread arr[] = new Thread[3]; // class A extends Thread
		arr[0] = new MusicThread("음악");
		arr[1] = new NewsThread("뉴스");
		arr[2] = new DownloadThread("다운로드");
		
		/*
		arr[0].start();
		arr[1].start();
		arr[2].start();
		*/
		
		for (int i=0; i<=arr.length; i++) {
			arr[i].start();
		}
		
		/* 3개 스레드 실행 시작 메소드 호출 */

		/*
		 * 음악듣는중입니다 음악듣는중입니다 음악듣는중입니다 다운로드중입니다 뉴스보는 중입니다 음악듣는중입니다 음악듣는중입니다 ....
		 * 
		 */

	}

}