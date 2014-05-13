package cc.luole.tech.stuinfo_collection.core.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.model.DownloadStu;
import cc.luole.tech.stuinfo_collection.core.service.DownloadStuService;

@Service("downloadStuService")
public class DownloadStuServiceImpl extends BaseServiceImpl<DownloadStu> implements DownloadStuService{

	@Override
	public List<DownloadStu> getListDownloadStu() {
		Page p = pageQuery("download_list_usr_info", new Object[]{}, 1, 10);
		return (List<DownloadStu>) p.getResult();
	}


	

}
