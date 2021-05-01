package com.bookchigo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookchigo.dao.MemberDao;
import com.bookchigo.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public void insertMember(Member member) {
		memberDao.insertMember(member);
	}

	@Override
	public boolean isValidUser(String username, String password) {
		String validPassword = memberDao.getPassword(username);
		
		if (validPassword == null || validPassword.equals(password) == false) {
			return false;
		}
		return true;
	}
}
