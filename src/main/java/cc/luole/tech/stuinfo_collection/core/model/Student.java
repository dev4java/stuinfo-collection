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
* <p>Title: Parent</p>
* <p>Description: 一句话描述这里</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月5日下午1:24:18
* @version 1.0
*/
@Entity
@Table(name = "sc_general_student")
public class Student  implements Serializable{
/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private String name;
	private int sex; //1男2女
	private Date birthday;
	private String hujiAddress;//familyRegister地址
	private String address;
	private Long id;
	//---------冗余字段
	private int applyDept;//冗余字段 为了方便加载个人信息中的学校问题
	private String stuanswer;

@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.AUTO)
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(name="name")
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Column(name="sex")
public int getSex() {
	return sex;
}
public void setSex(int sex) {
	this.sex = sex;
}
@Column(name="birthday")
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
@Column(name="huji_address")
public String getHujiAddress() {
	return hujiAddress;
}
public void setHujiAddress(String hujiAddress) {
	this.hujiAddress = hujiAddress;
}
@Column(name="address")
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Column(name="apply_dept")
public int getApplyDept() {
	return applyDept;
}
public void setApplyDept(int applyDept) {
	this.applyDept = applyDept;
}

@Column(name="stuanswer")
public String getStuanswer() {
	return stuanswer;
}
public void setStuanswer(String stuanswer) {
	this.stuanswer = stuanswer;
}







}
