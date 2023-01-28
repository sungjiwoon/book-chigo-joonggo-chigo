package com.bookchigo.service;

import com.bookchigo.domain.Study;

import java.util.List;

public interface StudyService {
	public void insertStudy(Study study);

	public List<Study> getStudyList();
}
