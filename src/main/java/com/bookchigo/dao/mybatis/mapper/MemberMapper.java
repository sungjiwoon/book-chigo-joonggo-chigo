package com.bookchigo.dao.mybatis.mapper;

import com.bookchigo.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

@Mapper
public interface MemberMapper {
	void insertMember(Member member) throws DataAccessException;

	String getPassword(String username);
	String getAccount(String username);
	String getMemberId(String username);

	Member getMemberInfo(int memberId);

	void deleteMember(int memberId);
}