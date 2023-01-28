package com.bookchigo.dao.mybatis;

import com.bookchigo.dao.StudyDao;
import com.bookchigo.dao.mybatis.mapper.StudyMapper;
import com.bookchigo.domain.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudyDaoImpl implements StudyDao {
	@Autowired
	private StudyMapper studyMapper;

	@Override
	public void insertStudy(Study study) throws DataAccessException {
		studyMapper.insertStudy(study);
	}

	@Override
	public List<Study> getStudyList() {
		return studyMapper.getStudyList();
	}
}
