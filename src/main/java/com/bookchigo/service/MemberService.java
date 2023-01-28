package com.bookchigo.service;

import com.bookchigo.domain.Member;

import java.util.Map;

public interface MemberService{
	public void insertMember(Member member);

	public Map<String, String> isValidUser(String username, String password);

	public Member getMemberInfo(int memberId);
	public void deleteMember(int memberId);
}
