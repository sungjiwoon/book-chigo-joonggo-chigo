package com.bookchigo.dao;

import com.bookchigo.domain.Study;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyDao {
	void insertStudy(Study study) throws DataAccessException;
	List<Study> getStudyList();
}
