package com.bookchigo.service;

import com.bookchigo.dao.MemberDao;
import com.bookchigo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public void insertMember(Member member) {
		memberDao.insertMember(member);
	}

	@Override
	public Map<String, String> isValidUser(String username, String password) {
		Map<String, String> response = new HashMap<String, String>();
		String validPassword = memberDao.getPassword(username);

		System.out.println("password : " + validPassword);

		if (validPassword != null && validPassword.equals(password) == true) {
			String account = memberDao.getAccount(username);
			String memberId = memberDao.getMemberId(username);

			System.out.println("account : " + account);
			System.out.println("memberId : " + memberId);

			response.put("account", account);
			response.put("memberId", memberId);
			response.put("username", username);
			return response;
		}

		return null;
	}

	@Override
	public Member getMemberInfo(int memberId) {
		return memberDao.getMemberInfo(memberId);
	}

	@Override
	public void deleteMember(int memberId) {
		memberDao.deleteMember(memberId);
	}
}
