package cc.luole.tech.stuinfo_collection.core.service;

import java.util.List;

import cc.luole.tech.stuinfo_collection.core.model.AnswerQuestion;

public interface AnswerQuestionService extends BaseService<AnswerQuestion>{
	
	public List<AnswerQuestion> getListAnswerQuestionsByStuid(long stuid);

}
