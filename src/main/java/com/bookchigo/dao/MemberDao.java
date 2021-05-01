package com.bookchigo.dao;

import org.springframework.dao.DataAccessException;

import com.bookchigo.domain.Member;

public interface MemberDao {
	void insertMember(Member member) throws DataAccessException;

	String getPassword(String username);
}
