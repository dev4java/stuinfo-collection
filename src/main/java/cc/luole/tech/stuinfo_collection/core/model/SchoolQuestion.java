package cc.luole.tech.stuinfo_collection.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
* <p>Title: SchoolQuestion</p>
* <p>Description: 一句话描述这里</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月5日下午1:24:23
* @version 1.0
*/
@Entity
@Table(name = "sc_general_schoolquestion")
public class SchoolQuestion implements Serializable{
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private int questType;//1单选 2 多选 3 文本
	private int dept;//1 小学 2 初中 3高中 4大学
	private String question;
	private String answer;
	private int status;//0有效 1无效
	private Long id;
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="dept")
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	
	@Column(name="question")
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name="answer")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Column(name="quest_type")
	public int getQuestType() {
		return questType;
	}
	public void setQuestType(int questType) {
		this.questType = questType;
	}
	@Column(name="status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
