package cc.luole.tech.stuinfo_collection.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* <p>Title: AnswerQuest</p>
* <p>Description: 一句话描述这里</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月5日下午1:24:12
* @version 1.0
*/
@Entity
@Table(name = "sc_general_answerquestion")
public class AnswerQuestion  implements Serializable {
/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
private Long stuid;
//private Long parentid;
private Long questionid;
private String answer;
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

@Column(name="stuid")
public Long getStuid() {
	return stuid;
}
public void setStuid(Long stuid) {
	this.stuid = stuid;
}

/*@Column(name="parentid")
public Long getParentid() {
	return parentid;
}
public void setParentid(Long parentid) {
	this.parentid = parentid;
}*/

@Column(name="questionid")
public Long getQuestionid() {
	return questionid;
}
public void setQuestionid(Long questionid) {
	this.questionid = questionid;
}

@Column(name="Answer")
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}



}
