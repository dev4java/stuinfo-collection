package cc.luole.tech.stuinfo_collection.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.model.Fusion;
import cc.luole.tech.stuinfo_collection.core.service.FusionService;
@Service("fusionService")
public class FusionServiceImpl extends BaseServiceImpl<Fusion> implements FusionService{

	@Override
	public Page getPageFusion(int pageNo, int pageSize) {
		return this.pageQuery("fusion_get_page", new Object[]{}, pageNo, pageSize);
	}

	@Override
	public List<Fusion> getListFusion() {
		return this.list("fusion_get_list", new Object[]{});
	}

}
