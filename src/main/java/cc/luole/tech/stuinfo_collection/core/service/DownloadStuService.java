package cc.luole.tech.stuinfo_collection.core.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.model.DownloadStu;
import cc.luole.tech.stuinfo_collection.core.model.Fusion;

public interface DownloadStuService extends BaseService<DownloadStu>{
	
	public List<DownloadStu> getListDownloadStu();
	

}
