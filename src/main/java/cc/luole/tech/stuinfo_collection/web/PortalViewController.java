package cc.luole.tech.stuinfo_collection.web;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cc.luole.tech.stuinfo_collection.core.dto.User;
import cc.luole.tech.stuinfo_collection.core.model.AnswerQuestion;
import cc.luole.tech.stuinfo_collection.core.model.Fusion;
import cc.luole.tech.stuinfo_collection.core.model.Parent;
import cc.luole.tech.stuinfo_collection.core.model.SchoolQuestion;
import cc.luole.tech.stuinfo_collection.core.model.Student;
import cc.luole.tech.stuinfo_collection.util.Constants;
import cc.luole.tech.stuinfo_collection.util.Util;

/**
* <p>Title: PortalViewController</p>
* <p>Description: 前端页面展示,用于采集入学意向数据</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月6日下午1:26:25
* @version 1.0
*/

@Controller
@RequestMapping("/collection")
public class PortalViewController extends BaseController{

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	@RequestMapping("/show")
	public ModelAndView showQuestion(HttpServletRequest request,HttpServletResponse response){
		String dept=request.getParameter("dept");
		int intDept=1;
		if(Util.notEmpty(dept)){
			intDept=Util.toInt4StringDept(dept);
		}
		ModelAndView model = new ModelAndView();
		List<SchoolQuestion> listSq=schoolQuestionService.getListSchooleQuestionsByDeptStatus(intDept, Constants.Status.VALID);
		SchoolQuestion sq = null;
		if(listSq!=null){
			model.addObject("flag", 0);
			model.addObject("question", listSq);
			for (SchoolQuestion schoolQuestion : listSq) {
				new SchoolQuestion();
				System.out.println(schoolQuestion.getQuestion());
				System.out.println(schoolQuestion.getAnswer());
			}
		}else{
			model.addObject("flag", 1);
		}
		model.setViewName("/portal/collect");
		return model;
	}
	
	
	@RequestMapping(value="/show",method=RequestMethod.POST)
	public ModelAndView postQuestion(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		//学生信息
		String stuName=request.getParameter("stuname");
		String stuSex=request.getParameter("stusex");
		String stuBirthday=request.getParameter("stubirthday");
		String stuHuji=request.getParameter("stuhuju");
		String stuHomeAddr=request.getParameter("stuhome");
		String scQuestId=request.getParameter("scqid");//问题id
		String stuAnswer=request.getParameter("stuanswer");//学生回答
		String stuApply=request.getParameter("stuapply");//类型 小学 初中
		//判断空
		if(!Util.notEmpty(stuName)|| !Util.notEmpty(stuSex) || !Util.notEmpty(stuBirthday) || !Util.notEmpty(stuHuji) || !Util.notEmpty(stuHomeAddr) || !Util.notEmpty(scQuestId)|| !Util.notEmpty(stuAnswer)){
			return this.jsonError("所填数据项不完整");
		}
		
		Student student = new Student();
		student.setName(stuName);
		student.setSex(Util.toInt4StringSex(stuSex));
		student.setBirthday(Util.toSqlDate4String(stuBirthday));
		student.setHujiAddress(stuHuji);
		student.setApplyDept(Integer.parseInt(stuApply));
		student.setAddress(stuHomeAddr);
		student.setStuanswer(stuAnswer);
		Serializable stuid=studentService.insert(student);
		if(stuid==null ){
			return this.jsonError("系统错误");
		}
		//--------------------------------------------------------------------------------
		//1爸爸 2 妈妈
		//父母信息
				String frelation=request.getParameter("frelation");
				String fname=request.getParameter("fname");
				String fcompany=request.getParameter("fcompany");
				String fjobTitle=request.getParameter("fjobTitle");
				String ftelphone=request.getParameter("ftelphone");
				//------------------------------------------------
				String mrelation=request.getParameter("mrelation");
				String mname=request.getParameter("mname");
				String mcompany=request.getParameter("mcompany");
				String mjobTitle=request.getParameter("mjobTitle");
				String mtelphone=request.getParameter("mtelphone");
				/*List<Parent> listParent =new ArrayList<Parent>();*/				
				//判断空
				/*if(!Util.notEmpty(stuName)|| !Util.notEmpty(stuSex) || !Util.notEmpty(stuBirthday) || !Util.notEmpty(stuHuji) || 
						Util.notEmpty(stuHomeAddr) || !Util.notEmpty(scQuestId)|| !Util.notEmpty(stuAnswer)){
					return this.jsonError("所填数据项不完整");
				}*/
				
				Parent fparent = new Parent();
				fparent.setName(fname);
				if(Util.notEmpty(frelation)){
					fparent.setRelation(Util.toString4StringRelation(frelation));
				}
				if(Util.notEmpty(ftelphone)){
					fparent.setTelphone(Long.parseLong(ftelphone));
				}
				fparent.setStuid(Long.parseLong(stuid.toString()));
				fparent.setJobTitle(fjobTitle);
				fparent.setCompany(fcompany);
				Serializable parid=parentService.insert(fparent);
				
				Parent mparent = new Parent();
				mparent.setName(mname);
				if(Util.notEmpty(frelation)){
					mparent.setRelation(Util.toString4StringRelation(mrelation));
				}
				if(Util.notEmpty(mtelphone)){
					mparent.setTelphone(Long.parseLong(mtelphone));
				}
				mparent.setStuid(Long.parseLong(stuid.toString()));
				mparent.setJobTitle(mjobTitle);
				mparent.setCompany(mcompany);
				Serializable marid=parentService.insert(mparent);
				//----------------------------------------------------------------
				/*SchoolQuestion aq = new SchoolQuestion();
				aq.setQuestion("你几口人????");
				aq.setDept(2);
				aq.setStatus(0);
				Serializable scqid=schoolQuestionService.insert(aq);*/
				
				//回答问题
				SchoolQuestion sq = schoolQuestionService.load(Long.parseLong(scQuestId));
				String schoolqc=sq.getQuestion();
				if(sq!=null){
					AnswerQuestion answerQuestion = new AnswerQuestion();
					answerQuestion.setQuestionid(Long.parseLong(scQuestId.toString()));
					answerQuestion.setAnswer(stuAnswer);
					answerQuestion.setStuid(Long.parseLong(stuid.toString()));
					Serializable ansqid=answerQuestionService.insert(answerQuestion);
				}
				
				//写入汇聚表
				/*Fusion fusion = new Fusion();
				fusion.setStuid(Long.parseLong(stuid.toString()));
				fusion.setStuName(stuName);
				fusion.setStuBirthday(Util.toSqlDate4String(stuBirthday));
				fusion.setScQuest(schoolqc);
				fusion.setStuAnswer(stuAnswer);
				fusion.setStuAddr(stuHomeAddr);
				fusionService.insert(fusion);*/
		return this.jsonSuccess("msg", "提交成功");
	}

}
