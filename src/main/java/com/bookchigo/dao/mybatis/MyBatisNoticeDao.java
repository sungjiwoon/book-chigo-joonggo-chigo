package com.bookchigo.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookchigo.dao.NoticeDao;
import com.bookchigo.dao.mybatis.mapper.NoticeMapper;
import com.bookchigo.domain.Notice;

@Repository
public class MyBatisNoticeDao implements NoticeDao {
	@Autowired
	private NoticeMapper noticeMapper;
	
	public List<Notice> getNoticeList(int memberId) {
		return noticeMapper.getNoticeList(memberId);
	} 
	
	public Notice getNotice(int noticeId) {
		return noticeMapper.getNotice(noticeId);
	}
	
	public void updateCount(int noticeId, int count) {
		noticeMapper.updateCount(noticeId, count);
	}
}
