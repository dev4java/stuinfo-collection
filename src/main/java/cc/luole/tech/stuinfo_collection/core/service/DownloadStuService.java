package cc.luole.tech.stuinfo_collection.core.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.model.DownloadStu;
import cc.luole.tech.stuinfo_collection.core.model.Fusion;
@Service(value="downloadStuService")
public interface DownloadStuService extends BaseService<DownloadStu>{
	
	public List<DownloadStu> getListDownloadStu();
	
	public DownloadStu findDownloadStuByStuId(long stuid);
	
	//得到记录数
	public int getDownloadStuCount();
}
