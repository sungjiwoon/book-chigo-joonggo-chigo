package com.bookchigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bookchigo.dao.GroupPurchaseDao;
import com.bookchigo.domain.GpApply;
import com.bookchigo.domain.GroupPurchase;

@Service
public class GroupPurchaseServiceImpl implements GroupPurchaseService {

	@Autowired
	private GroupPurchaseDao groupPurchaseDao;
	
	// 리스트 관련
	@Override
	public List<GroupPurchase> getGroupPurchaseList() {
		return groupPurchaseDao.getGroupPurchaseList();	
	}
	@Override
	public List<GroupPurchase> getGroupPurchaseImReaderList(int readerMemberId) {
		return  groupPurchaseDao.getGroupPurchaseImReaderList(readerMemberId);
	}
	@Override
	public List<GroupPurchase> Search_GroupPurchase(String book_name) {
		return groupPurchaseDao.Search_GroupPurchase(book_name);
	}
	@Override
	public List<GpApply> getWhoApplierList(int gp_postId) {
		return groupPurchaseDao.getWhoApplierList(gp_postId);
	}
	@Override
	public List<GpApply> getMyApplyList(int memberId) {
		return groupPurchaseDao.getMyApplyList(memberId);
	}
	
	// get 
	@Override
	public GroupPurchase getGpPostByPostId(int gp_postId) {
		return groupPurchaseDao.getGpPostByPostId(gp_postId);
	}
	
	// 업로드 
	@Override
	public GroupPurchase Upload_GroupPurchase(GroupPurchase newPost) {
		GroupPurchase upload = groupPurchaseDao.Upload_GroupPurchase(newPost);
		return upload;
	}
	@Override
	public void Delete_GroupPurchase(int gp_postId) {
		groupPurchaseDao.Delete_GroupPurchase(gp_postId);
	}
	@Override
	public GroupPurchase Update_GroupPurchase(GroupPurchase Post) {
		return groupPurchaseDao.Update_GroupPurchase(Post);
	}
	
	// 자세히 보기
	@Override
	public GroupPurchase Detail_GroupPurchase(int gp_postId) {
		GroupPurchase gp = groupPurchaseDao.Detail_GroupPurchase(gp_postId);
		return gp;
	}

	// 공구 신청&취소
	@Override
	public void Apply_GroupPurchase(int gp_postId) {
		 groupPurchaseDao.Apply_GroupPurchase(gp_postId);
	}
	@Override
	public void Cancel_GroupPurchase(int gp_postId) {
		groupPurchaseDao.Cancel_GroupPurchase(gp_postId);
	}
	
	// 디비에 삽입, 신청목록에 추가
	@Override
	public void insertGpApply(GpApply newApply) {
		groupPurchaseDao.insertGpApply(newApply);
		
	}
	public void deleteGpApply(GpApply delApply) throws DataAccessException {
		groupPurchaseDao.deleteGpApply(delApply);
	}
	
	// ing 체크 및 업데이트
	@Override
	public void ingUpdate(int gp_postId) {
		groupPurchaseDao.ingUpdate(gp_postId);
	}





}
