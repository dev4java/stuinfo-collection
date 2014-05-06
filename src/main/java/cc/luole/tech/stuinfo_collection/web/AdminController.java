package cc.luole.tech.stuinfo_collection.web;

import java.io.Serializable;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.dto.User;
import cc.luole.tech.stuinfo_collection.core.model.AdminUsr;
import cc.luole.tech.stuinfo_collection.core.model.AnswerQuestion;
import cc.luole.tech.stuinfo_collection.core.model.Parent;
import cc.luole.tech.stuinfo_collection.core.model.SchoolQuestion;
import cc.luole.tech.stuinfo_collection.core.model.Student;
import cc.luole.tech.stuinfo_collection.core.service.AnswerQuestionService;
import cc.luole.tech.stuinfo_collection.core.service.ParentService;
import cc.luole.tech.stuinfo_collection.core.service.SchoolQuestionService;
import cc.luole.tech.stuinfo_collection.core.service.StudentService;
import cc.luole.tech.stuinfo_collection.core.service.UserService;
import cc.luole.tech.stuinfo_collection.util.Util;

/**
* <p>Title: StuInfoController</p>
* <p>Description: 一句话描述这里</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月5日上午10:25:58
* @version 1.0
*/
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController{

	
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	/**
	* <p>Title: login</p>
	* <p>Description: 后台用户登陆</p>
	* <p>Copyright: Copyright © 2013 - Luole.com</p>
	* <p>Company: luoleTech</p>
	* @author yusw
	* @email yswthink@163.com
	* @date 2014年5月6日下午4:40:53
	* @version 1.0
	* @param request
	* @param response
	* @param session
	* @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		if(!Util.notEmpty(name) || !Util.notEmpty(password)){
			this.jsonError("请输入用户名或密码");
		}
		AdminUsr aUsr = adminUsrService.getAdminUsrbyName(name);
		if(aUsr!=null){
			String dbPwd=aUsr.getPassword();
			if(password.equals(dbPwd)){
				session.setAttribute("isLogin", aUsr);
				return this.jsonSuccess("suc", aUsr);
			}			
		}else{
			return this.jsonError("无此用户,请与管理员联系");
		}
		return null;
	}
	
	@RequestMapping("/list")
	public ModelAndView listUser(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		if(!isLogin(session)){
			return this.jsonError("请先登陆");
		}
		ModelAndView model = new ModelAndView();
		int pageNo=Util.toInt4String(request,"pageNo");
		int pageSize=Util.toInt4String(request,"pageSize");
		pageSize=10;
		Page page = studentService.getPageStudent(pageNo, pageSize);
		if(page!=null){
			model.addObject("message", page.getResult());	
		}
		model.setViewName("stu_page");
		return model;
	}
	

	/**
	* <p>Title: showUser</p>
	* <p>Description: 展示单个的用户信息</p>
	* <p>Copyright: Copyright © 2013 - Luole.com</p>
	* <p>Company: luoleTech</p>
	* @author yusw
	* @email yswthink@163.com
	* @date 2014年5月6日下午4:42:14
	* @version 1.0
	* @param request
	* @param response
	* @param session
	* @return
	 */
	@RequestMapping("/show")
	public ModelAndView showUser(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		if(!isLogin(session)){
			return this.jsonError("请先登陆");
		}
		ModelAndView model = new ModelAndView();
		String uid=request.getParameter("uid");
		if(!Util.notEmpty(uid)){
			return this.jsonError("数据传输错误");
		}
		User user=userService.getUser(Util.tolong4Stringid(uid));
		if(user!=null){
			model.addObject("message", user);	
		}else{
			model.addObject("message", "nothing");	
		}
		model.setViewName("showMessage");
		return model;
	}
	
	
	/**
	* <p>Title: addQuestion</p>
	* <p>Description: 新增问题{冗余功能}</p>
	* <p>Copyright: Copyright © 2013 - Luole.com</p>
	* <p>Company: luoleTech</p>
	* @author yusw
	* @email yswthink@163.com
	* @date 2014年5月6日下午4:41:29
	* @version 1.0
	* @return
	 */
	@RequestMapping("/add/question")
	public ModelAndView addQuestion(HttpSession session){
		if(!isLogin(session)){
			return this.jsonError("请先登陆");
		}
		ModelAndView model = new ModelAndView();
		SchoolQuestion aq = new SchoolQuestion();
		aq.setQuestion("你家在哪儿?");
		aq.setDept(2);
		aq.setStatus(0);
		Serializable uid=schoolQuestionService.insert(aq);
		if(uid!=null){
			model.addObject("message", uid);	
		}else{
			model.addObject("message", "nothing");	
		}
		model.setViewName("showMessage");
		return model;
	}
	
	@RequestMapping("/download")
	public ModelAndView download(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		if(!isLogin(session)){
			return this.jsonError("请先登陆");
		}
		ModelAndView model = new ModelAndView();
		
		return model;
	}
	
	
	
}
