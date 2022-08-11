## 내 정보 수정 (CRUD 중 Update)
- `updateform.jsp`에서 회원정보를 수정하고, `updateprocess.jsp`로 form 입력 내용을 전달한다. (단, 아이디와 비밀번호는 URL 파라미터로 입력받고, 수정할 수는 없다.)
- `updateprocess.jsp`에서 MemberDTO 객체를 생성하고, MemberDAO의 updateMember() 메서드를 실행해 DB에 연결해 수정을 완료하고, `updatesuccess.jsp`로 포워딩한다.
- `updatesuccess.jsp`에서 성공적으로 회원 정보가 수정되었음을 브라우저에 출력한다.
<br>
<br>

- [MemberDTO 파일](https://github.com/suebin/TIL/tree/master/08_jsp/test/login_logout/dto)
- [MemberDAO 파일](https://github.com/suebin/TIL/tree/master/08_jsp/test/login_logout/dao)