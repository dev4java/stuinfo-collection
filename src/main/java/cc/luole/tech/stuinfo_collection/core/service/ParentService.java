package cc.luole.tech.stuinfo_collection.core.service;

import java.util.List;

import cc.luole.tech.stuinfo_collection.core.model.Parent;

/**
* <p>Title: ParentService</p>
* <p>Description: 一句话描述这里</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月5日下午2:47:53
* @version 1.0
*/
public interface ParentService extends BaseService<Parent>{
	/**
	* <p>Title: getParentsByStuid</p>
	* <p>Description: 根据学生id找出学生的父母</p>
	* <p>Copyright: Copyright © 2013 - Luole.com</p>
	* <p>Company: luoleTech</p>
	* @author yusw
	* @email yswthink@163.com
	* @date 2014年5月5日下午2:52:12
	* @version 1.0
	* @param stuid
	* @return
	 */
	public List<Parent> getListParentsByStuid(long stuid);
}
