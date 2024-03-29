package springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<HelloDTO> list = new ArrayList<>();
		
		for (int i=1; i<=5; i++) {
			HelloDTO dto = new HelloDTO();
			dto.setMessage("리스트" + i);
			list.add(dto);
		}
			
		request.setAttribute("list", list);

		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("list");
		
		return mv;
	}
}
