package com.bookchigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookchigo.dao.NoticeDao;
import com.bookchigo.domain.Notice;


@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<Notice> getNoticeList(int memberId) {
		return noticeDao.getNoticeList(memberId);
	}
	
	@Override
	public Notice getNotice(int noticeId) {
		return noticeDao.getNotice(noticeId);
	}
	@Override
	public void updateCount(int noticeId, int count) {
		noticeDao.updateCount(noticeId, count);
	}
}