public class RegularExpressionTest {

	public static void main(String[] args) {
		String phones[] = {"010-1234-5678", "011-1234-5678", "010-12345-6789", "010-^^^2-5678"};
		
		// 010이나 011로 시작 / 숫자3,4자리 / 4자리 숫자 종료
		for (int i =0; i<phones.length; i++) {
			System.out.println(phones[i].matches("(010|011)-[0-9]{3,4}-[0-9]{4}")); // 패턴
			System.out.println(phones[i].contains("1234")); // 패턴이 아니라 정적으로 그냥 포함하는지만!
		}
		//.{3,5} 라고 중간에 넣으면 3-5개 아무 글자 오면 ok
		//[0-9]+ 라고 뒤에 넣으면 한자리로만 끝내면 ok
		
		String address = "서울시-서초구-서초동"; 
		String [] result = address.split("(-|/|:| )");

		for (int i = 0; i < result.length; i++) { 
			System.out.println(result[i]);
		}
	
		// . + * ? 분리자 = 정규표현식 사용 -> []괄호 안에 넣으면 ok
	}
}
