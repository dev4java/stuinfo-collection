package cc.luole.tech.stuinfo_collection.core.service;

import cc.luole.tech.stuinfo_collection.core.model.AdminUsr;


public interface AdminUsrService extends BaseService<AdminUsr>{
	public AdminUsr getAdminUsrbyName(String Name);
}
