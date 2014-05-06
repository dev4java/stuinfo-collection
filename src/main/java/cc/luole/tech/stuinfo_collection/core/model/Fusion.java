package cc.luole.tech.stuinfo_collection.core.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
* <p>Title: Fusion</p>
* <p>Description:学生的汇聚信息,主要是方便简化分页的sql查询操作而将数据汇聚到一张表中{弃用功能}</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月6日下午5:22:54
* @version 1.0
 */
@Entity
@Table(name = "sc_general_fusion")
public class Fusion implements Serializable{
/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
private Long id;
private Long stuid;
private String stuName;
private Date stuBirthday;
private String scQuest;
private String stuAnswer;
private String stuAddr;
//-----------------add
private String relation;
private String parentName;
private String telphone;


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
@Column(name="stu_birthday")
public Date getStuBirthday() {
	return stuBirthday;
}
public void setStuBirthday(Date stuBirthday) {
	this.stuBirthday = stuBirthday;
}
@Column(name="sc_quest")
public String getScQuest() {
	return scQuest;
}
public void setScQuest(String scQuest) {
	this.scQuest = scQuest;
}
@Column(name="stu_answer")
public String getStuAnswer() {
	return stuAnswer;
}
public void setStuAnswer(String stuAnswer) {
	this.stuAnswer = stuAnswer;
}

@Column(name="stuAddr")
public String getStuAddr() {
	return stuAddr;
}
public void setStuAddr(String stuAddr) {
	this.stuAddr = stuAddr;
}

@Column(name="relation")
public String getRelation() {
	return relation;
}
public void setRelation(String relation) {
	this.relation = relation;
}

@Column(name="parent_ame")
public String getParentName() {
	return parentName;
}
public void setParentName(String parentName) {
	this.parentName = parentName;
}

@Column(name="telphone")
public String getTelphone() {
	return telphone;
}
public void setTelphone(String telphone) {
	this.telphone = telphone;
}
@Column(name="stu_name")
public String getStuName() {
	return stuName;
}
public void setStuName(String stuName) {
	this.stuName = stuName;
}


}
