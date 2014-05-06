package cc.luole.tech.stuinfo_collection.util;

import java.util.HashMap;
import java.util.Map;


/**
* <p>Title: Constant</p>
* <p>Description: 常量类</p>
* <p>Copyright: Copyright © 2013 - Luole.com</p>
* <p>Company: luoleTech</p>
* @author yusw
* @email yswthink@163.com
* @date 2014年5月5日下午3:52:42
* @version 1.0
*/
public class Constants {
	/**
	* <p>Title: Status</p>
	* <p>Description:0有效 1 无效</p>
	* <p>Copyright: Copyright © 2013 - Luole.com</p>
	* <p>Company: luoleTech</p>
	* @author yusw
	* @email yswthink@163.com
	* @date 2014年5月5日下午3:54:56
	* @version 1.0
	 */
	public static class Status{
		public static int VALID=0;
		public static int INVALID=1;
	}
	
	public static class Dept{
		public static Map convertDept(){
			Map<Integer,String> map=new HashMap<Integer, String>();
			map.put(1, "小学");
			map.put(2, "初中");
			map.put(3, "高中");
			map.put(4, "大学");
			map.put(5, "幼儿园");
			return map;
			}
	}
	
}
