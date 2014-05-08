package cc.luole.tech.stuinfo_collection.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cc.luole.sns.tools.commons.Page;
import cc.luole.tech.stuinfo_collection.core.model.Fusion;
import cc.luole.tech.stuinfo_collection.core.model.Student;
import cc.luole.tech.stuinfo_collection.core.service.StudentService;
@Service(value="studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService  {
	
	@Override
	public Page getPageStudent(int pageNo, int pageSize) {
		return this.pageQuery("student_get", new Object[]{}, pageNo, pageSize);
	}

	@Override
	public List<Student> getListStudent() {
		return this.list("student_get", new Object[]{});
	}

}
