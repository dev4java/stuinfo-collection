package cc.luole.tech.stuinfo_collection.core.service.impl;

import org.springframework.stereotype.Service;

import cc.luole.tech.stuinfo_collection.core.model.AdminUsr;
import cc.luole.tech.stuinfo_collection.core.service.AdminUsrService;
@Service("adminUsrService")
public class AdminUsrServiceImpl extends BaseServiceImpl<AdminUsr> implements AdminUsrService{

	@Override
	public AdminUsr getAdminUsrbyName(String name) {
		// TODO Auto-generated method stub
		return this.load("get_adminusr_by_name", new Object[]{name});
	}

}
