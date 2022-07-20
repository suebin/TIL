package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberSelectView2 implements View {

	@Override
	public void input() {

		MemberDAO dao = new MemberDAO();
		int totalcount = dao.getTotalMember(); // getTotalMember() 메서드 만들기 (전체 레코드 수가 얼마인지 알아오기 위해)
		int recordPerPage = 4; // 각 페이지 당 몇 개의 레코드를 보여줄지 정의

		int totalPage = 0;
		if ((totalcount % recordPerPage) == 0) {
			totalPage = totalcount / recordPerPage;
		} else {
			totalPage = (totalcount / recordPerPage) + 1;
		}
		System.out.println(totalPage);

		
		Scanner sc = new Scanner(System.in);
		System.out.print("페이지번호 입력 ( 1-" + totalPage + " 페이지까지 가능 ): ");
		
		String pagenum = sc.next();
		
		ArrayList<MemberDTO> list = null;
		
		if (pagenum.equals("*")) {
			list = dao.selectAllMember();
		}
		else {
			list = dao.selectPagingMember(Integer.parseInt(pagenum), recordPerPage);			
		}
		
		for (MemberDTO dto : list) {
			System.out.println(dto);
		}

	}

}
