package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginAllController {
	
	// GET 방식
	//@RequestMapping(value="/login", method=RequestMethod.GET) 
	@GetMapping("/login")
	public String loginform() {	
		return "loginform";
	}
	
	// POST 방식
	//@RequestMapping(value="/login", method=RequestMethod.POST) 
	@PostMapping("/login")
	public String loginresult(@ModelAttribute("loginresult") LoginDTO dto) {  

		return "loginresult";
	}
	
	
/*	@RequestMapping("/loginform") // 이 어노테이션이 있다면 String으로 리턴 타입을 선언해도 리턴값을 View 이름으로 간주한다.
	public String loginform() {	
		return "loginform";
	}	*/
	
	// test5
/*	@RequestMapping("/loginresult")
	public String loginresult(@ModelAttribute("loginresult") LoginDTO dto) {  

		return "loginresult";
	}	*/
	
	// test4
/*	@RequestMapping("/loginresult")
	public ModelAndView loginresult(LoginDTO dto) {  
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginresult");

		return mv;
	}   */
	
	 // test3
/*	@RequestMapping("/loginresult")
	public ModelAndView loginresult(@RequestParam("id") String name, String password) {  
		
		LoginDTO dto = new LoginDTO();
		dto.setId(name);
		dto.setPassword(password);

		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginresult");

		return mv;
	}	*/
	
	//test2
/*	@RequestMapping("/loginresult")
	public ModelAndView loginresult(String id, int password) {
		System.out.println(id+":"+password);
		//모델 생성
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPassword(password);
		//전달
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginresult");
		return mv;
	}	*/
	
	
	// test1
/*	@RequestMapping("/loginresult")
	public ModelAndView loginresult(HttpServletRequest request) {
		// 로그인 요청 정보 입력
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 모델 생성
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPassword(password);
		
		// 전달
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginresult");

		return mv;
	}	*/

}



// 회원 관리 컨트롤러 : CRUD 메서드 : 1개 컨트롤러