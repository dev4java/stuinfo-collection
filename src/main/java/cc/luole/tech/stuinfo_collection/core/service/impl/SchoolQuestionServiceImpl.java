package cc.luole.tech.stuinfo_collection.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cc.luole.tech.stuinfo_collection.core.model.SchoolQuestion;
import cc.luole.tech.stuinfo_collection.core.service.SchoolQuestionService;
@Service(value="schoolQuestionService")
public class SchoolQuestionServiceImpl extends BaseServiceImpl<SchoolQuestion> implements SchoolQuestionService {

	@Override
	public List<SchoolQuestion> getListSchooleQuestionsByDeptStatus(int dept,
			int status) {
		return this.list("schoolequestion_get_questions_by_dept_status", new Object[]{dept,status});
	}

}
