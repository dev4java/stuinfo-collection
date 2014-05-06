package cc.luole.tech.stuinfo_collection.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.dto.User;
import cc.luole.tech.stuinfo_collection.core.dto.UserAnswer;
import cc.luole.tech.stuinfo_collection.core.model.AnswerQuestion;
import cc.luole.tech.stuinfo_collection.core.model.Parent;
import cc.luole.tech.stuinfo_collection.core.model.SchoolQuestion;
import cc.luole.tech.stuinfo_collection.core.model.Student;
import cc.luole.tech.stuinfo_collection.core.service.AnswerQuestionService;
import cc.luole.tech.stuinfo_collection.core.service.ParentService;
import cc.luole.tech.stuinfo_collection.core.service.SchoolQuestionService;
import cc.luole.tech.stuinfo_collection.core.service.StudentService;
import cc.luole.tech.stuinfo_collection.core.service.UserService;
import cc.luole.tech.stuinfo_collection.util.Constants;
import cc.luole.tech.stuinfo_collection.util.Util;

@Service(value="userService")
public class UserServiceImpl extends BaseServiceImpl<User>  implements UserService{
	@Autowired
	public StudentService studentService;
	
	@Autowired
	public ParentService parentService;
	
	@Autowired
	public SchoolQuestionService schoolQuestionService;
	
	@Autowired
	public AnswerQuestionService answerQuestionService;
	
	@Override
	public User getUser(long stuid) {
		User u = new User();
		//组装stu
		Student student=this.studentService.load(stuid);
		String stuApplyDept="";
		int studept=1;
		if(student!=null){
			studept=student.getApplyDept();
			stuApplyDept=Util.toString4intDept(studept);
			u.setuStuName(student.getName());
			u.setuStuSex(Util.toString4intSex(student.getSex()));
			u.setuStuBirthday(student.getBirthday());
			u.setuStuHujiAddress(student.getHujiAddress());
			u.setuStuAddress(student.getAddress());
			u.setuStuApplyDept(stuApplyDept);
		}
		//组装parent
		List<Parent> listParent = parentService.getListParentsByStuid(stuid);
		List<Parent> isParent = new ArrayList<Parent>();
		Parent parent=null;
		if(listParent.size()>0){
			for (Parent parent1 : listParent) {
				parent = new Parent();
				parent.setName(parent1.getName());
				parent.setCompany(parent1.getCompany());
				parent.setJobTitle(parent1.getJobTitle());
				parent.setTelphone(parent1.getTelphone());
				isParent.add(parent);
			}
			u.setParent(isParent);
		}
		//先组装answer 拿到questionid
		List<AnswerQuestion> aq =answerQuestionService.getListAnswerQuestionsByStuid(stuid);
		List<UserAnswer> isUsrAnswer = new ArrayList<UserAnswer>();
		SchoolQuestion schoolQuestion=null;
		UserAnswer userAnswer=null;
		if(aq.size()>0){
			for (AnswerQuestion answerQuestion : aq) {
				long ansQueId=answerQuestion.getQuestionid();
			
				//组装question
				/*schoolQuestion=schoolQuestionService.getListSchooleQuestionsByidStatus(ansQueId,Constants.Status.VALID);*/
				schoolQuestion=schoolQuestionService.load(ansQueId);
				if(schoolQuestion!=null){
					userAnswer = new UserAnswer();
					//判断该问题的状态
					if(schoolQuestion.getStatus()==Constants.Status.VALID){
						userAnswer.setAnsqueid(ansQueId);
						userAnswer.setAnswer(answerQuestion.getAnswer());
						userAnswer.setQuestion(schoolQuestion.getQuestion());
						isUsrAnswer.add(userAnswer);
					}
				}
				
			}
			u.setUserAnswer(isUsrAnswer);
		}
		return u;
	}

	@Override
	public Page getPageUser(int pageNo, int pageSize) {
		return this.pageQuery("stu_get_page", new Object[]{}, pageNo, pageSize);
	}

	@Override
	public List<User> getListUser() {
		// TODO Auto-generated method stub
		return this.list("stu_get_list", new Object[]{});
	}

}
