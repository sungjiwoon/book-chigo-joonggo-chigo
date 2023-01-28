package com.bookchigo.dao.mybatis;

import com.bookchigo.dao.MemberDao;
import com.bookchigo.dao.mybatis.mapper.MemberMapper;
import com.bookchigo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private MemberMapper memberMapper;

	public void insertMember(Member member) throws DataAccessException {
		memberMapper.insertMember(member);
	}

	public String getPassword(String username) {
		return memberMapper.getPassword(username);
	}

	@Override
	public String getAccount(String username) { return memberMapper.getAccount(username); }

	@Override
	public String getMemberId(String username) { return memberMapper.getMemberId(username); }

	@Override
	public Member getMemberInfo(int memberId) {
		return memberMapper.getMemberInfo(memberId);
	}

	@Override
	public void deleteMember(int memberId) {
		memberMapper.deleteMember(memberId);
	}


}
