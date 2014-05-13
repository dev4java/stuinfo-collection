package cc.luole.tech.stuinfo_collection.core.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sc_general_download")
public class DownloadStu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//学生信息
		private Long id;
		private Long dStuId;
		private String dStuName;
		private String dStuSex; //1男2女
		private Date dStuBirthday;
		private String dStuHujiAddress;
		private String dStuAddress;
		private int dStuApplyDept;
		
		//家长信息
		private String dStufname;
		private String dStufcompany;
		private String dStufjobTitle;
		private String dStuftelphone;
		//------------------------------------------------
		private String dStumname;
		private String dStumcompany;
		private String dStumjobTitle;
		private String dStumtelphone;
		
		//问题及回答问题
		private Long dStuAnsId;
		private Long dStuScqId;
		private String dStuquestion;
		private String dStuanswer;
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@Column(name="stu_id")
		public Long getdStuId() {
			return dStuId;
		}
		public void setdStuId(Long dStuId) {
			this.dStuId = dStuId;
		}
		
		@Column(name="stu_name")
		public String getdStuName() {
			return dStuName;
		}
		public void setdStuName(String dStuName) {
			this.dStuName = dStuName;
		}
		
		@Column(name="stu_sex")
		public String getdStuSex() {
			return dStuSex;
		}
		public void setdStuSex(String dStuSex) {
			this.dStuSex = dStuSex;
		}
		
		@Column(name="stu_birthday")
		public Date getdStuBirthday() {
			return dStuBirthday;
		}
		public void setdStuBirthday(Date dStuBirthday) {
			this.dStuBirthday = dStuBirthday;
		}
		
		@Column(name="stu_huji")
		public String getdStuHujiAddress() {
			return dStuHujiAddress;
		}
		public void setdStuHujiAddress(String dStuHujiAddress) {
			this.dStuHujiAddress = dStuHujiAddress;
		}
		
		@Column(name="stu_addr")
		public String getdStuAddress() {
			return dStuAddress;
		}
		public void setdStuAddress(String dStuAddress) {
			this.dStuAddress = dStuAddress;
		}
		
		
		@Column(name="stu_apply")
		public int getdStuApplyDept() {
			return dStuApplyDept;
		}
		public void setdStuApplyDept(int dStuApplyDept) {
			this.dStuApplyDept = dStuApplyDept;
		}
		@Column(name="stu_father")
		public String getdStufname() {
			return dStufname;
		}
		public void setdStufname(String dStufname) {
			this.dStufname = dStufname;
		}
		
		@Column(name="stu_fcompany")
		public String getdStufcompany() {
			return dStufcompany;
		}
		public void setdStufcompany(String dStufcompany) {
			this.dStufcompany = dStufcompany;
		}
		
		@Column(name="stu_fjobtitle")
		public String getdStufjobTitle() {
			return dStufjobTitle;
		}
		public void setdStufjobTitle(String dStufjobTitle) {
			this.dStufjobTitle = dStufjobTitle;
		}
		
		@Column(name="stu_ftel")
		public String getdStuftelphone() {
			return dStuftelphone;
		}
		public void setdStuftelphone(String dStuftelphone) {
			this.dStuftelphone = dStuftelphone;
		}
		
		@Column(name="stu_mather")
		public String getdStumname() {
			return dStumname;
		}
		public void setdStumname(String dStumname) {
			this.dStumname = dStumname;
		}
		
		@Column(name="stu_mcompany")
		public String getdStumcompany() {
			return dStumcompany;
		}
		public void setdStumcompany(String dStumcompany) {
			this.dStumcompany = dStumcompany;
		}
		
		@Column(name="stu_mjobtitle")
		public String getdStumjobTitle() {
			return dStumjobTitle;
		}
		public void setdStumjobTitle(String dStumjobTitle) {
			this.dStumjobTitle = dStumjobTitle;
		}
		
		@Column(name="stu_mtel")
		public String getdStumtelphone() {
			return dStumtelphone;
		}
		public void setdStumtelphone(String dStumtelphone) {
			this.dStumtelphone = dStumtelphone;
		}
		
		
		@Column(name="stu_ans_id")
		public Long getdStuAnsId() {
			return dStuAnsId;
		}
		public void setdStuAnsId(Long dStuAnsId) {
			this.dStuAnsId = dStuAnsId;
		}
		
		
		@Column(name="stu_scq_id")
		public Long getdStuScqId() {
			return dStuScqId;
		}
		public void setdStuScqId(Long dStuScqId) {
			this.dStuScqId = dStuScqId;
		}
		
		
		@Column(name="stu_question")
		public String getdStuquestion() {
			return dStuquestion;
		}
		public void setdStuquestion(String dStuquestion) {
			this.dStuquestion = dStuquestion;
		}
		
		
		@Column(name="stu_answer")
		public String getdStuanswer() {
			return dStuanswer;
		}
		public void setdStuanswer(String dStuanswer) {
			this.dStuanswer = dStuanswer;
		}
		
		
		
}
