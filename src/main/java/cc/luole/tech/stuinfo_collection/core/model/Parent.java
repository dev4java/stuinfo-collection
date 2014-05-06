package cc.luole.tech.stuinfo_collection.core.model;

import java.io.Serializable;

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
@Table(name = "sc_general_parent")
public class Parent  implements Serializable{
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private int relation;//1爸爸 2 妈妈
	private Long stuid;
	private String name;
	private String company ;
	private String  jobTitle;
	private Long telphone;
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
	
	@Column(name="relation")
	public int getRelation() {
		return relation;
	}
	public void setRelation(int relation) {
		this.relation = relation;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="stuid")
	public Long getStuid() {
		return stuid;
	}
	public void setStuid(Long stuid) {
		this.stuid = stuid;
	}
	@Column(name="company")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name="job_title")
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@Column(name="telphone")
	public Long getTelphone() {
		return telphone;
	}
	public void setTelphone(Long telphone) {
		this.telphone = telphone;
	}




}
