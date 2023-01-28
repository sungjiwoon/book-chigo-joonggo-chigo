package com.bookchigo.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bookchigo.domain.Notice;
@Mapper
public interface NoticeMapper {
	
	List<Notice> getNoticeList(int memberId);
	Notice getNotice(int noticeId);
	void updateCount(@Param("noticeId") int noticeId,@Param("count") int count);
}
