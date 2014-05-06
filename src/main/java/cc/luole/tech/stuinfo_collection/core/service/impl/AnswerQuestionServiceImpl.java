package cc.luole.tech.stuinfo_collection.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cc.luole.tech.stuinfo_collection.core.model.AnswerQuestion;
import cc.luole.tech.stuinfo_collection.core.service.AnswerQuestionService;
@Service(value="answerQuestionService")
public class AnswerQuestionServiceImpl extends BaseServiceImpl<AnswerQuestion> implements AnswerQuestionService {

	@Override
	public List<AnswerQuestion> getListAnswerQuestionsByStuid(long stuid) {
		// TODO Auto-generated method stub
		return this.list("answerquest_get_answer_by_stuid", new Object[]{stuid});
	}

}
