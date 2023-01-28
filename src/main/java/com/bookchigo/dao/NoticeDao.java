package com.bookchigo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bookchigo.domain.Notice;

public interface NoticeDao {
	List<Notice> getNoticeList(int memberId) throws DataAccessException;
	Notice getNotice(int noticeId) throws DataAccessException;
	void updateCount(int noticeId, int count)throws DataAccessException;
}
