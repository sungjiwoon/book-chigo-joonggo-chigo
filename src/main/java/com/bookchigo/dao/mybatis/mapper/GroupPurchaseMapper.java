package com.bookchigo.dao.mybatis.mapper;


import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bookchigo.domain.GpApply;
import com.bookchigo.domain.GroupPurchase;

public interface GroupPurchaseMapper {

	// 리스트 관련
	List<GroupPurchase> getGroupPurchaseList();
	List<GroupPurchase> getGroupPurchaseImReaderList(int readerMemberId);
	List<GroupPurchase> Search_GroupPurchase(String book_name); 
	List<GpApply> getMyApplyList(int memberId);
	List<GpApply> getWhoApplierList(int gp_postId);
	
	// get
	GroupPurchase getGpPostByPostId (int gp_postId);

	// 업로드
	GroupPurchase Upload_GroupPurchase(GroupPurchase newPost);
	void Delete_GroupPurchase(int gp_postId);
	GroupPurchase Update_GroupPurchase(GroupPurchase Post);
	
	// 자세히보기
	GroupPurchase Detail_GroupPurchase(int gp_postId);

	// 공구신청&취소
	void Apply_GroupPurchase(int gp_postId); 
	void Cancel_GroupPurchase(int gp_postId); 
		
	// 디비에 삽입, 신청목록에 삽입
	void insertGpApply(GpApply newApply);
	void deleteGpApply(GpApply delApply); 
	
	// ing 체크 및 UPDATE
	void ingUpdate(int gp_postId);


}


