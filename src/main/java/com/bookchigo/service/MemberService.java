package com.bookchigo.service;

import com.bookchigo.domain.Member;

public interface MemberService{
	public void insertMember(Member member);

	public boolean isValidUser(String username, String password);
}
