package cc.luole.tech.stuinfo_collection.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cc.luole.tech.stuinfo_collection.core.model.Parent;
import cc.luole.tech.stuinfo_collection.core.service.ParentService;
@Service(value="parentService")
public class ParentServiceImpl extends BaseServiceImpl<Parent>  implements ParentService{

	public List<Parent> getListParentsByStuid(long stuid){
		return this.list("parent_get_stuparents_by_stuid", new Object[]{stuid});	
	}
	
}
