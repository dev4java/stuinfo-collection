package cc.luole.tech.stuinfo_collection.core.service.impl;

import java.util.Arrays;
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
		int size=this.getDownloadStuCount();
		Page p = pageQuery("download_list_usr_info", new Object[]{}, 1, size);
		return (List<DownloadStu>) p.getResult();
	}

	@Override
	public DownloadStu findDownloadStuByStuId(long stuid) {
		return this.load("find_download_stu_by_stuid", new Object[]{stuid});
	}

	@Override
	public int getDownloadStuCount() {
		String sql="select count(id) from sc_general_download";
		List list= this.excuteListSql("get_download_stu_size", sql,new Object[]{});
		if(list !=null){
			Object size=list.get(0);
			return Integer.parseInt(size.toString());
		}
		return 1000;
	}


	

}
