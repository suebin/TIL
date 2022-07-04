import java.text.DecimalFormat;

public class DecimalFormatTest {

	public static void main(String[] args) {
		double num = 1234567.89;
		// # 정수부분 - 표현 숫자가 더 커도 잘 표현
		// # 소수점 이하 부분 - 정확 자릿수 표현 (반올림)
		DecimalFormat df = new DecimalFormat("###,###.##"); //6자리 정수, 2자리 소수
		System.out.println(df.format(num));

	}

}
