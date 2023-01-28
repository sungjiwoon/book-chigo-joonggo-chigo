package com.bookchigo.dao;

import com.bookchigo.domain.Member;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	void insertMember(Member member) throws DataAccessException;

	String getPassword(String username);
	String getAccount(String username);
	String getMemberId(String username);

	Member getMemberInfo(int memberId);

	void deleteMember(int memberId);
}
