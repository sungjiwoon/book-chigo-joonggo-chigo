package com.bookchigo.dao.mybatis.mapper;

import com.bookchigo.domain.Study;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface StudyMapper {
	void insertStudy(Study study) throws DataAccessException;
	List<Study> getStudyList();
}