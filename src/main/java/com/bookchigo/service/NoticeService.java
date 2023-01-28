package com.bookchigo.service;

import java.util.List;

import com.bookchigo.domain.Notice;

public interface NoticeService {
	public List<Notice> getNoticeList(int memberId);
	public Notice getNotice(int notice_id);
	public void updateCount(int noticeId, int count);
}
