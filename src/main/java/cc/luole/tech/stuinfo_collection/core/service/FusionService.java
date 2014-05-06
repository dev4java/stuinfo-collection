package cc.luole.tech.stuinfo_collection.core.service;

import java.util.List;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.model.Fusion;

public interface FusionService extends BaseService<Fusion>{
	
	public Page getPageFusion(int pageNo,int pageSize);
	
	public List<Fusion> getListFusion();

}
