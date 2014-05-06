package cc.luole.tech.stuinfo_collection.core.service;

import java.util.List;

import cc.luole.tech.stuinfo_collection.core.model.SchoolQuestion;

public interface SchoolQuestionService extends BaseService<SchoolQuestion>{

	/**
	* <p>Title: getListSchooleQuestionsByDeptStatus</p>
	* <p>Description: 根据学部和状态查出问题 eg:小学 问题:家是否属于阳光小区?</p>
	* <p>Copyright: Copyright © 2013 - Luole.com</p>
	* <p>Company: luoleTech</p>
	* @author yusw
	* @email yswthink@163.com
	* @date 2014年5月5日下午3:22:14
	* @version 1.0
	* @param dept
	* @param status
	* @return
	 */
	public List<SchoolQuestion> getListSchooleQuestionsByDeptStatus(int dept,int status);
	
	
}
