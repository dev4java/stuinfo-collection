package cc.luole.tech.stuinfo_collection.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController extends DispatcherServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 为方便配置nginx
	//@RequestMapping("/collection")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		model.setViewName("/portal/collect");
		return model;
	}
}
