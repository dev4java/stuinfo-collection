package cc.luole.tech.stuinfo_collection.core.service;

import java.util.List;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.dto.User;

public interface UserService extends BaseService<User>{

	public User getUser(long stuid);
	
	public Page getPageUser(int pageNo,int pageSize);
	
	public List<User> getListUser();
	
	public List<User> getListUserInfos();
	
}
