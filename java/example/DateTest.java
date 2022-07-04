import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		long mill = System.currentTimeMillis();
		
		Date now = new Date(); // 현재시각(초단위 동일), 출력형태 정해졌다.
		System.out.println(mill);
		System.out.println(now);
		
		// Date 클래스의 메소드들은 jdk 변화되면서 사용 자제 표시 - deprecated method
		// 사용해도 컴파일 오류는 발생하지 않지만 새 프로젝트 사용 자제를 권고한다.
		// 기능은 Calendar 클래스 이동 권고!
		
		Calendar cal = Calendar.getInstance(); // new 객체 생성 x
		System.out.println(cal);
		// now.getYear(); 년도 사용 자제
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1; // Month 0월 = 1월임
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println("현재 시각은 "+year+"년도 "+month+"월 "+day+"일 ");
		System.out.println(hour+"시 "+minute+"분 "+second+"초 ");
		
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 1(일),2(월)
		
		
		//22-07-04 13:23:24 요일 (날짜/시각 형식 미리 지정)
		//SimpleDateFormat - 간결히 날짜시각 "형식"을 제공
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss E"); //DDD = 일년 중 몇일!
		String result = sdf.format(cal.getTime());
		System.out.println(result);
	}
}

