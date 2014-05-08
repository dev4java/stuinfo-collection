package cc.luole.tech.stuinfo_collection.util;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TryCatchFinally;

/**
* <p>Title: Util</p>
* <p>Description: 公共的方法</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月5日下午2:35:06
* @version 1.0
*/
public class Util {
	/**
	* <p>Title: </p>
	* <p>Description:防止通过new生成该类对象 </p>
	 */
	private Util(){
		
	}

	//TODO:通过googlemap的key-value双向获取
	
	public static boolean notEmpty(String str){
		boolean flag=false;
		if(str !=null && str.trim().length()>0 && !"".equals(str)){
			flag=true;
		}
		return flag;
	}
	
	public static String toString4intSex(int a){
		if(a==1){
			return "男";
		}else{
			return "女";
		}
	}
	
	public static int toInt4StringSex(String sex){
		if(sex.equals("男")){
			return 1;
		}else{
			return 2;
		}
	}
	
	public static String toString4intQuestType(int a){
		if(a==1){//1单选 2 多选 3 文本
			return "单选题";
		}else if(a==2){
			return "多选";
		}else if(a==3){
			return "文本";
		}else{
			return "未知";
		}
	}
	
	public static String toString4intRelation(int a){
		if(a==1){
			return "爸爸";
		}else if(a==2){
			return "妈妈";
		}else{
			return "未知";
		}
	}
	
	public static int toString4StringRelation(String a){
		if(a.equals("爸爸")){
			return 1;
		}else if(a.equals(" 妈妈")){
			return 2;
		}else{
			return 3;
		}
	}
	
	public static String toString4intDept(int a){
		switch(a)
		{
		case 1:return "小学";
		case 2:return "初中";
		case 3:return "高中";
		case 4:return "大学";
		case 5:return "幼儿园";
		default:return "小学";
		}
	}
	
	public static int toInt4StringDept(String dept){
		/*switch(dept)
		{
		case "小学":return 1;
		case "初中":return 2;
		case "高中":return 3;
		case "大学":return 4;
		case "幼儿园":return 5;
		default:return 1;
		}*/
		if(dept.equals("小学")){
			return 1;
		}else if(dept.equals("初中")){
			return 2;
		}else if(dept.equals("高中")){
			return 3;
		}else if(dept.equals("大学")){
			return 4;
		}else if(dept.equals("幼儿园")){
			return 5;
		}else{
			return 6;
		}
	}
	
	public static Date toSqlDate4String(String str){
		Date date=null;
		try {
			date=java.sql.Date.valueOf(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return date;
	}
	
	public static long tolong4Stringid(String sex){
		long id=0L;
		try {
			id=Long.parseLong(sex);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return id;
	}
	
	public static int toInt4String(HttpServletRequest request,String str){
		String s=request.getParameter(str);
		int par=0;
		if(!notEmpty(s)){
			s="0";
		}
		try {
			par=Integer.parseInt(s);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return par;
	}
	

}
