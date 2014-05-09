package cc.luole.tech.stuinfo_collection.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.dto.User;
import cc.luole.tech.stuinfo_collection.core.dto.UserAnswer;
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
import cc.luole.tech.stuinfo_collection.util.ExcelUtil;
import cc.luole.tech.stuinfo_collection.util.ExcelUtilFormat;
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
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView getlu(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		return this.listUser(request, response, session);
	}
	
	@RequestMapping("/list")
	public ModelAndView listUser(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		if(!isLogin()){
			//return this.jsonError("请先登陆");
			return this.getLogin();
		}
		ModelAndView model = new ModelAndView();
		int pageNo=Util.toInt4String(request,"pageNo");
		int pageSize=Util.toInt4String(request,"pageSize");
		if(pageSize==0){
			pageSize=10;
		}
		if(pageNo==0){
			pageNo=1;
		}
		String flag=request.getParameter("flag");
		if(null==flag || "".equals(flag)){
			flag="next";
		}
		long totalPageCount =1L;
		long totalCount=1L;
		Page page = studentService.getPageStudent(pageNo, pageSize);
		if(page!=null){
			
			totalPageCount=page.getTotalPageCount();
			totalCount=page.getTotalCount();
			model.addObject("list", page.getResult());	
			totalPageCount=page.getTotalPageCount();
			totalCount=page.getTotalCount();
			model.addObject("page", page);
			model.addObject("_url", "list");
			model.addObject("pageNo",pageNo);
			model.addObject("pageSize",pageSize);
			String pageHtml =this.pageHtml(flag,pageNo, totalCount, totalPageCount);
			model.addObject("pageHtml", pageHtml);
			System.out.println("当前总页数="+page.getTotalPageCount()+"  当前第页数="+page.getCurrentPageNo()+"   总记录数="+page.getTotalCount()+"---------"+pageHtml);
		}
		model.setViewName("/admin/list");
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
		if(!isLogin()){
			//return this.jsonError("请先登陆");
			return this.getLogin();
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
		model.setViewName("/admin/detail");
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
		if(!isLogin()){
			//return this.jsonError("请先登陆");
			return this.getLogin();
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
	public ModelAndView download(HttpServletRequest request,HttpServletResponse response) throws IOException{
		if(!isLogin()){
			//return this.jsonError("请先登陆");
			return this.getLogin();
		}
		List<ExcelUtilFormat> formats = new ArrayList<ExcelUtilFormat>();
		 	HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        List<User> listU =userService.getListUserInfos();
    		//------------------------------------------------------------------------------------------------------
	       /* List<Parent> listParent=null;
	        List<UserAnswer> listUa=null;
	        ExcelUtilFormat parentName=null;
	        ExcelUtilFormat company=null;
	        ExcelUtilFormat jobTitle=null;
	        ExcelUtilFormat telphone=null;
	        for (User user : listU) {
	        	listParent=user.getParent();
	        	if(listParent!=null){
	        		for (Parent p : listParent) {
	        			int guanxi=p.getRelation();
	        			if(guanxi==1){
	        				parentName = new ExcelUtilFormat("父亲", 10, "name");
        		    		formats.add(parentName);
	        			}else{
	        				parentName = new ExcelUtilFormat("母亲", 10, "name");
        		    		formats.add(parentName);
	        			}
	        			company = new ExcelUtilFormat("工作单位", 10, "company");
    		    		formats.add(company);
    		    		jobTitle = new ExcelUtilFormat("工作职务", 10, "jobTitle");
    		    		formats.add(jobTitle);
    		    		telphone = new ExcelUtilFormat("手机", 10, "telphone");
    		    		formats.add(telphone);	
					}
	        	}
			}
	        ExcelUtilFormat question=null;
	        ExcelUtilFormat answer=null;
	        for (User user : listU) {
	        	listUa=user.getUserAnswer();
	        	if(listUa!=null){
	        		for (UserAnswer userAnswer : listUa) {
	        			question = new ExcelUtilFormat(userAnswer.getQuestion(), 40, "question");
			    		formats.add(question);
			    		answer = new ExcelUtilFormat(userAnswer.getAnswer(), 40, "answer");
			    		formats.add(answer);
					}
	        	}
			}
	    	List<Object> listObj=new ArrayList<Object>();
    		listObj.add(listU);
    		listObj.add(listUa);
    		listObj.add(listParent);*/
    		//------------------------------------------------------------------------------------------------------
	        byte[] bytes =null;
	    		String sheetName="students.xls";
	    		//List<User> courseList = new ArrayList<User>();
	    		
	    		ExcelUtilFormat course = new ExcelUtilFormat("孩子姓名", 10, "uStuName");
	    		formats.add(course);
	    		ExcelUtilFormat classroomTeacher = new ExcelUtilFormat("性别", 10, "uStuSex");
	    		formats.add(classroomTeacher);
	    		ExcelUtilFormat teacherSourceName = new ExcelUtilFormat("生日", 20, "uStuBirthday");
	    		formats.add(teacherSourceName);
	    		ExcelUtilFormat address = new ExcelUtilFormat("户口所在地", 30, "uStuHujiAddress");
	    		formats.add(address);
	    		ExcelUtilFormat managementTeacher = new ExcelUtilFormat("家庭住址", 30, "uStuAddress");
	    		formats.add(managementTeacher);
	    		/*ExcelUtilFormat typeName = new ExcelUtilFormat("是否租住", 10, "typeName");
	    		formats.add(typeName);
	    		
	    		ExcelUtilFormat grade = new ExcelUtilFormat("年级", 10, "grade");
	    		formats.add(grade);
	    		ExcelUtilFormat ext = new ExcelUtilFormat("上线人数", 10, "ext");
	    		formats.add(ext);*/
	    		
//	    		headers.setContentDispositionFormData("attachment",sheetName);
	    		/*do
	    		{
	    			Page p = this.courseGroupService.getAllCoursebyDelete(Constants.Deleted.NORMAL,pageNo, pageSize);
	        		totalPage = p.getTotalPageCount();
	        		p = this.toCourseDto(p);
	        		courseList.addAll((List<CourseDto>)p.getResult());
	        		pageNo++;
	    		}
	    		while(pageNo<=totalPage);*/
	    	
	    		headers.setContentDispositionFormData("attachment",sheetName);
	    		try {
	    			ByteArrayOutputStream bos = ExcelUtil.madeSingleSheetExcel(listU, User.class, formats, sheetName);
	    			bytes = bos.toByteArray();
				} catch (Exception e) {
					logger.error("下载数据出错！", e);
				}
//	        return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.CREATED);
		        OutputStream os = null;
				try {
					os = response.getOutputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			    try {  
			    	response.reset();  
			    	response.setHeader("Content-Disposition", "attachment; filename="+sheetName);  
			    	response.setContentType("application/octet-stream; charset=utf-8");  
			        try {
						os.write(bytes);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
			        try {
						os.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
			    } finally {  
			        if (os != null) {  
			            os.close();  
			        }  
			    }
				return null;  
		
	}
	
	@RequestMapping("/delete")
	public ModelAndView del(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		if(!isLogin()){
			//return this.jsonError("请先登陆");
			return this.getLogin();
		}
		String uid=request.getParameter("uid");
		long lid=Util.tolong4Stringid(uid);
		if(lid==0L){
			return this.jsonError("数据传输错误");
		}
		boolean sf=false;
		Student student=studentService.load(lid);
		if(student!=null){
			sf=studentService.delete(lid);
			if(sf){
				//删除父母
				List<Parent> listParent=parentService.getListParentsByStuid(lid);
				if(listParent!=null && listParent.size()>0){
					for (Parent parent : listParent) {
						sf=parentService.delete(parent.getId());
					}
				}
				//删除问答
				List<AnswerQuestion> list=answerQuestionService.getListAnswerQuestionsByStuid(lid);
				if(list!=null && list.size()>0){
					for (AnswerQuestion answerQuestion : list) {
						sf=answerQuestionService.delete(answerQuestion.getId());
					}
				}
				return this.jsonSuccess("suc", null);
			}else{
				return this.jsonError("删除失败");
			}
		}		
		return null;
	}
	
	
	//后台分页代码
	private String pageHtml(String flag,int pageNo,long totalCount,long totalPageCount){
		String pageHtml="";
		int c=pageNo%8;
		int start=1;
		int end=1;
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append("<a class=\"home\" href=\"#\" id=\"homeid\">首页</a>");
		sb.append("<a  id=\"upid\" class=\"prev\" href=\"#\">上一页</a>");
		//number-cur
		if(totalPageCount>8){
			if(pageNo<8){
				for (int i = 1; i <= 8; i++) {
					sb.append("<a class=\"number ");
					if(i==pageNo){
						sb.append(" number-cur  ");
					}
					sb.append("\" onClick=\"go(");
					sb.append(i);
					sb.append(");\">");
					sb.append(i);
					sb.append("</a>");
				}
				sb.append("<span class=\"number\">...</span>");
				sb.append("<a class=\"number\" onClick=\"go(");
				sb.append(totalPageCount);
				sb.append(");\">");
				sb.append(totalPageCount);
				sb.append("</a>");
			}else{
				int s=pageNo-c+1;//开始一排的第一个
				int s1=s+8;//一排结束的值[不包含该值]
				if(c==0){
					if(flag.equals("up")){
						s=pageNo-8;
						if(totalPageCount<s1){
							for (int ss=pageNo-c; ss <= totalPageCount; ss++) {//for (int ss=pageNo-c+1; ss <= totalPageCount; ss++) {
								//System.out.println("-------------"+ss);
								/*sb.append("<a class=\"number\" onClick=\"go(");*/
								sb.append("<a class=\"number ");
								if(ss==pageNo){
									sb.append(" number-cur  ");
								}
								sb.append("\" onClick=\"go(");
								sb.append(ss);
								sb.append(");\">");
								sb.append(ss);
								sb.append("</a>");
							}
						}else{
							for (int i = pageNo-8+1; i <= pageNo; i++) {
								/*sb.append("<a class=\"number\" onClick=\"go(");*/
								sb.append("<a class=\"number ");
								if(i==pageNo){
									sb.append(" number-cur  ");
								}
								sb.append("\" onClick=\"go(");
								sb.append(i);
								sb.append(");\">");
								sb.append(i);
								sb.append("</a>");
							}
							sb.append("<span class=\"number\">...</span>");
							sb.append("<a class=\"number\" onClick=\"go(");
							sb.append(totalPageCount);
							sb.append(");\">");
							sb.append(totalPageCount);
							sb.append("</a>");
						}
						
					}else if(flag.equals("next")){
						s=pageNo+8;
						if(totalPageCount<s1){
							sb.append("<a class=\"number\" onClick=\"go(1);\">1</a> ");
							
							sb.append("<span class=\"number\">...</span>");
							for (int ss=pageNo-c; ss <= totalPageCount; ss++) {//for (int ss=pageNo-c+1; ss <= totalPageCount; ss++) {
								//System.out.println("-------------"+ss);
								/*sb.append("<a class=\"number\" onClick=\"go(");*/
								sb.append("<a class=\"number ");
								if(ss==pageNo){
									sb.append(" number-cur  ");
								}
								sb.append("\" onClick=\"go(");
								sb.append(ss);
								sb.append(");\">");
								sb.append(ss);
								sb.append("</a>");
							}
						}else{
							for (int i = pageNo+1; i <= s; i++) {
								/*sb.append("<a class=\"number\" onClick=\"go(");*/
								sb.append("<a class=\"number ");
								if(i==pageNo){
									sb.append(" number-cur  ");
								}
								sb.append("\" onClick=\"go(");
								sb.append(i);
								sb.append(");\">");
								sb.append(i);
								sb.append("</a>");
							}
							sb.append("<span class=\"number\">...</span>");
							sb.append("<a class=\"number\" onClick=\"go(");
							sb.append(totalPageCount);
							sb.append(");\">");
							sb.append(totalPageCount);
							sb.append("</a>");
						}
						
					}else if(flag.equals("curr")){
						s=pageNo+8;
						if(totalPageCount<s1){
							sb.append("<a class=\"number\" onClick=\"go(1);\">1</a> ");
							sb.append("<span class=\"number\">...</span>");
							for (int ss=pageNo-c; ss <= totalPageCount; ss++) {
								//System.out.println("-------------"+ss);
								/*sb.append("<a class=\"number\" onClick=\"go(");*/
								sb.append("<a class=\"number ");
								if(ss==pageNo){
									sb.append(" number-cur  ");
								}
								sb.append("\" onClick=\"go(");
								sb.append(ss);
								sb.append(");\">");
								sb.append(ss);
								sb.append("</a>");
							}
						}else{
							for (int i = pageNo; i < s; i++) {
								/*sb.append("<a class=\"number\" onClick=\"go(");*/
								sb.append("<a class=\"number ");
								if(i==pageNo){
									sb.append(" number-cur  ");
								}
								sb.append("\" onClick=\"go(");
								sb.append(i);
								sb.append(");\">");
								sb.append(i);
								sb.append("</a>");
							}
							sb.append("<span class=\"number\">...</span>");
							sb.append("<a class=\"number\" onClick=\"go(");
							sb.append(totalPageCount);
							sb.append(");\">");
							sb.append(totalPageCount);
							sb.append("</a>");
						}
						
					}
				}else if(totalPageCount<s1){
					sb.append("<a class=\"number\" onClick=\"go(1);\">1</a> ");
					sb.append("<span class=\"number\">...</span>");
					for (int ss=pageNo-c+1; ss <= totalPageCount; ss++) {
						//System.out.println("-------------"+ss);
						/*sb.append("<a class=\"number\" onClick=\"go(");*/
						sb.append("<a class=\"number ");
						if(ss==pageNo){
							sb.append(" number-cur  ");
						}
						sb.append("\" onClick=\"go(");
						sb.append(ss);
						sb.append(");\">");
						sb.append(ss);
						sb.append("</a>");
					}
				}
				
				else{
					for (int ss=pageNo-c+1; ss < s1; ss++) {
						//System.out.println("-------------"+ss);
						/*sb.append("<a class=\"number\" onClick=\"go(");*/
						sb.append("<a class=\"number ");
						if(ss==pageNo){
							sb.append(" number-cur  ");
						}
						sb.append(" \" onClick=\"go(");
						sb.append(ss);
						sb.append(");\">");
						sb.append(ss);
						sb.append("</a>");
					}
					if(s1<totalPageCount){
						sb.append("<span class=\"number\">...</span>");
						sb.append("<a class=\"number\" onClick=\"go(");
						sb.append(totalPageCount);
						sb.append(");\">");
						sb.append(totalPageCount);
						sb.append("</a>");
					}
				}
				
			}
		}else{//小于8
			for (int i = 1; i <= totalPageCount; i++) {
				/*sb.append("<a class=\"number\" onClick=\"go(");*/
				sb.append("<a class=\"number ");
				if(i==pageNo){
					sb.append(" number-cur  ");
				}
				sb.append("\" onClick=\"go(");
				sb.append(i);
				sb.append(");\">");
				sb.append(i);
				sb.append("</a>");
			}
		}
		sb.append("<a id=\"nextid\" class=\"next next-cur\" href=\"#\">下一页</a>");
		sb.append("<a id=\"endid\"  class=\"end\" href=\"#\">末页</a>");
		/*sb.append("<span class=\"total\">共<span>");
		sb.append(totalCount);
		sb.append("</span>条记录</span>");*/
		pageHtml=sb.toString();
		System.out.println(pageHtml);
		return pageHtml;
		
	}
	
}
