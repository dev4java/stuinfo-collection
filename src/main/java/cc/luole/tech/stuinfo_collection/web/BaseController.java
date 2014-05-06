package cc.luole.tech.stuinfo_collection.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import cc.luole.tech.stuinfo_collection.core.service.AdminUsrService;
import cc.luole.tech.stuinfo_collection.core.service.AnswerQuestionService;
import cc.luole.tech.stuinfo_collection.core.service.FusionService;
import cc.luole.tech.stuinfo_collection.core.service.ParentService;
import cc.luole.tech.stuinfo_collection.core.service.SchoolQuestionService;
import cc.luole.tech.stuinfo_collection.core.service.StudentService;
import cc.luole.tech.stuinfo_collection.core.service.UserService;
import cc.luole.tech.stuinfo_collection.util.Util;

/**
* <p>Title: BaseController</p>
* <p>Description: 一句话描述这里</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月5日上午午10:24:40
* @version 1.0
*/
@Controller
public class BaseController extends DispatcherServlet{
	
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);
	
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	public UserService userService;
	
	@Autowired
	SchoolQuestionService schoolQuestionService;
	
	@Autowired
	public StudentService studentService;
	
	@Autowired
	public ParentService parentService;
	
	@Autowired
	public AnswerQuestionService answerQuestionService;
	
	@Autowired
	public AdminUsrService adminUsrService;
	
	@Autowired
	public FusionService fusionService;
	
	
	/**
	* <p>Title: isLogin</p>
	* <p>Description: 判断用户是否登录</p>
	* <p>Copyright: Copyright © 2013 - Luole.com</p>
	* <p>Company: luoleTech</p>
	* @author yusw
	* @email yswthink@163.com
	* @date 2014年5月6日下午1:24:33
	* @version 1.0
	* @param request
	* @param response
	* @return
	 */
	public boolean isLogin(HttpSession session){
		boolean flag=false;
		Object login=session.getAttribute("isLogin");
		if(login != null){
			flag=true;
			System.out.println(login.toString());
		}
		return flag;
	}
	
	/**
	 * 返回错误提示
	 * @author shiyue[jianpingcao@sohu-inc.com][2011-12-16]
	 * @param msg
	 * @return
	 */
	protected ModelAndView jsonError(String msg) {
		ModelAndView view = new ModelAndView("res");
		try {
			JSONObject json = new JSONObject();
			json.put("status", 1);
			json.put("statusText", msg);
			json.put("data", "null");
			String res = json.toString();
			view.addObject("res", res);
		} catch (Exception e) {
			log.warn("json error", e.getMessage());
		}
		return view;
	}
	
	/**
	 * 返回成功提示
	 * @author shiyue[jianpingcao@sohu-inc.com][2011-12-16]
	 * @param msg
	 * @return
	 */
	protected ModelAndView jsonSuccess(String msg, Object data) {
		ModelAndView view = new ModelAndView("res");
		try {
			JSONObject json = new JSONObject();
			json.put("status", 0);
			json.put("statusText", msg);
			json.put("data", data);
			String res = json.toString();
			view.addObject("res", res);
		} catch (Exception e) {
			log.warn("json error", e.getMessage());
		}
		return view;
	}
}
