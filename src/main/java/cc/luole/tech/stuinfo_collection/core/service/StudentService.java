package cc.luole.tech.stuinfo_collection.core.service;

import java.util.List;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.model.Fusion;
import cc.luole.tech.stuinfo_collection.core.model.Student;


/**
* <p>Title: StudentService</p>
* <p>Description: 一句话描述这里</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月5日下午2:00:55
* @version 1.0
*/
public interface StudentService extends BaseService<Student>{

	public Page getPageStudent(int pageNo,int pageSize);
	
	public List<Fusion> getListStudent();

}
