package com.bookchigo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bookchigo.domain.GpApply;
import com.bookchigo.domain.GroupPurchase;

public interface GroupPurchaseDao {
	
	// 리스트 불러오는거
	List<GroupPurchase> getGroupPurchaseList() throws DataAccessException;
	List<GroupPurchase> getGroupPurchaseImReaderList(int readerMemberId) throws DataAccessException;
	List<GroupPurchase> Search_GroupPurchase(String book_name) throws DataAccessException; 
	List<GpApply> getWhoApplierList(int gp_postId) throws DataAccessException;
	List<GpApply> getMyApplyList(int memberId) throws DataAccessException;

	// get (얻어오는 작업 관련)
	GroupPurchase getGpPostByPostId (int gp_postId) throws DataAccessException;

	// 게시글 업로드와 삭제
	GroupPurchase Upload_GroupPurchase(GroupPurchase newPost) throws DataAccessException;
	void Delete_GroupPurchase(int gp_postId) throws DataAccessException;
	GroupPurchase Update_GroupPurchase(GroupPurchase Post) throws DataAccessException;
	
	// 자세히보기
	GroupPurchase Detail_GroupPurchase(int gp_postId) throws DataAccessException;

	// 공구 신청&취소
	void Apply_GroupPurchase(int gp_postId) throws DataAccessException; 
	void Cancel_GroupPurchase(int gp_postId) throws DataAccessException; 
	
	// 공구신청취소 -> 디비에 삽입삭제, 신청목록에 삽입삭제
	void insertGpApply(GpApply newApply) throws DataAccessException; 
	void deleteGpApply(GpApply delApply) throws DataAccessException; 
	
	// ing 체크 및 UPDATE
	void ingUpdate(int gp_postId) throws DataAccessException; 
	
}