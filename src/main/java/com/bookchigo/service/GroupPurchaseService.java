package com.bookchigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bookchigo.dao.GroupPurchaseDao;
import com.bookchigo.domain.GpApply;
import com.bookchigo.domain.GroupPurchase;

public interface GroupPurchaseService {
	
	// 리스트 관련
	public List<GroupPurchase> getGroupPurchaseList();
	public List<GroupPurchase> getGroupPurchaseImReaderList(int readerMemberId);
	public List<GroupPurchase> Search_GroupPurchase(String book_name); 
	public List<GpApply> getMyApplyList(int memberId);
	public List<GpApply> getWhoApplierList(int gp_postId);
	
	// get
	public GroupPurchase getGpPostByPostId (int gp_postId);

	// 게시글 업로드, 삭제, 수정
	public GroupPurchase Upload_GroupPurchase(GroupPurchase newPost);
	public void Delete_GroupPurchase(int gp_postId);
	public GroupPurchase Update_GroupPurchase(GroupPurchase Post);
	
	// 자세히 보기
	public GroupPurchase Detail_GroupPurchase(int gp_postId);
	
	// 공구 신청&취소
	public void Apply_GroupPurchase(int gp_postId); 
	public void Cancel_GroupPurchase(int gp_postId); 
		
	// 디비에 삽입, 신청목록에 삽입
	public void insertGpApply(GpApply newApply);
	public void deleteGpApply(GpApply delApply); 
	
	// ing 체크 및 UPDATE
	public void ingUpdate(int gp_postId);
	
	
	

}
