package cc.luole.tech.stuinfo_collection.core.dto;


import java.sql.Date;
import java.util.List;

import cc.luole.tech.stuinfo_collection.core.model.AnswerQuestion;
import cc.luole.tech.stuinfo_collection.core.model.BaseModel;
import cc.luole.tech.stuinfo_collection.core.model.Parent;

/**
* <p>Title: User</p>
* <p>Description: 封装完整的用户信息{学生/家长/问题}</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月5日下午2:13:10
* @version 1.0
*/
public class User extends BaseModel{
	//学生信息
	private String uStuName;
	private String uStuSex; //1男2女
	private Date uStuBirthday;
	private String uStuHujiAddress;
	private String uStuAddress;
	private String uStuApplyDept;
	
	//家长信息
	/*private String uPRelation;//1爸爸 2 妈妈
	private Long uPStuid;
	private String uPName;
	private String uPCompany ;
	private String  uPJobTitle;
	private int uPTelphone;*/
	private List<Parent> parent;
	
	//问题及回答问题
	/*private String uSchQuestion;
	private String uStuAnswer;*/
	private List<UserAnswer> userAnswer;
	

	public String getuStuName() {
		return uStuName;
	}
	public void setuStuName(String uStuName) {
		this.uStuName = uStuName;
	}
	public String getuStuSex() {
		return uStuSex;
	}
	public void setuStuSex(String uStuSex) {
		this.uStuSex = uStuSex;
	}
	public Date getuStuBirthday() {
		return uStuBirthday;
	}
	public void setuStuBirthday(Date uStuBirthday) {
		this.uStuBirthday = uStuBirthday;
	}
	public String getuStuHujiAddress() {
		return uStuHujiAddress;
	}
	public void setuStuHujiAddress(String uStuHujiAddress) {
		this.uStuHujiAddress = uStuHujiAddress;
	}
	public String getuStuAddress() {
		return uStuAddress;
	}
	public void setuStuAddress(String uStuAddress) {
		this.uStuAddress = uStuAddress;
	}
	
	
/*	public String getuPRelation() {
		return uPRelation;
	}
	public void setuPRelation(String uPRelation) {
		this.uPRelation = uPRelation;
	}
	public Long getuPStuid() {
		return uPStuid;
	}
	public void setuPStuid(Long uPStuid) {
		this.uPStuid = uPStuid;
	}
	public String getuPName() {
		return uPName;
	}
	public void setuPName(String uPName) {
		this.uPName = uPName;
	}
	public String getuPCompany() {
		return uPCompany;
	}
	public void setuPCompany(String uPCompany) {
		this.uPCompany = uPCompany;
	}
	public String getuPJobTitle() {
		return uPJobTitle;
	}
	public void setuPJobTitle(String uPJobTitle) {
		this.uPJobTitle = uPJobTitle;
	}
	public int getuPTelphone() {
		return uPTelphone;
	}
	public void setuPTelphone(int uPTelphone) {
		this.uPTelphone = uPTelphone;
	}*/
	
	public String getuStuApplyDept() {
		return uStuApplyDept;
	}
	public void setuStuApplyDept(String uStuApplyDept) {
		this.uStuApplyDept = uStuApplyDept;
	}
	/*public String getuSchQuestion() {
		return uSchQuestion;
	}
	public void setuSchQuestion(String uSchQuestion) {
		this.uSchQuestion = uSchQuestion;
	}
	public String getuStuAnswer() {
		return uStuAnswer;
	}
	public void setuStuAnswer(String uStuAnswer) {
		this.uStuAnswer = uStuAnswer;
	}*/
	public List<Parent> getParent() {
		return parent;
	}
	public void setParent(List<Parent> parent) {
		this.parent = parent;
	}
	public List<UserAnswer> getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(List<UserAnswer> userAnswer) {
		this.userAnswer = userAnswer;
	}

	

	
	
}
