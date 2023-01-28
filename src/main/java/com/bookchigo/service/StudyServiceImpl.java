package com.bookchigo.service;

import com.bookchigo.dao.StudyDao;
import com.bookchigo.domain.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {
	@Autowired
	private StudyDao studyDao;

	@Override
	public void insertStudy(Study study) {
		studyDao.insertStudy(study);
	}

	@Override
	public List<Study> getStudyList() {
		return studyDao.getStudyList();
	}
}
