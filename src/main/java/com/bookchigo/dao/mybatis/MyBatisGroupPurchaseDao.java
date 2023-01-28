package com.bookchigo.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookchigo.dao.GroupPurchaseDao;
import com.bookchigo.dao.mybatis.mapper.GroupPurchaseMapper;
import com.bookchigo.domain.Book;
import com.bookchigo.domain.GpApply;
import com.bookchigo.domain.GroupPurchase;

@Repository
public class MyBatisGroupPurchaseDao implements GroupPurchaseDao {
	
	@Autowired
	private GroupPurchaseMapper groupPurchaseMapper;
	
	// 리스트 관련
	public List<GroupPurchase> getGroupPurchaseList() throws DataAccessException {
		return groupPurchaseMapper.getGroupPurchaseList();
	};
	public List<GroupPurchase> getGroupPurchaseImReaderList(int readerMemberId) throws DataAccessException {
		return groupPurchaseMapper.getGroupPurchaseImReaderList(readerMemberId);
	}
	public List<GroupPurchase> Search_GroupPurchase(String book_name) throws DataAccessException {
		return groupPurchaseMapper.Search_GroupPurchase(book_name);
	}
	public List<GpApply> getWhoApplierList(int gp_postId) throws DataAccessException {
		return groupPurchaseMapper.getWhoApplierList(gp_postId);
	}
	public List<GpApply> getMyApplyList(int memberId) throws DataAccessException {
		return groupPurchaseMapper.getMyApplyList(memberId);
	}
	
	// get
	public GroupPurchase getGpPostByPostId(int gp_postId) throws DataAccessException {
		return groupPurchaseMapper.getGpPostByPostId(gp_postId);
	};
	
	// 게시글 업로드, 삭제, 수정
	public GroupPurchase Upload_GroupPurchase(GroupPurchase newPost) throws DataAccessException {
		return groupPurchaseMapper.Upload_GroupPurchase(newPost);
	}
	public void Delete_GroupPurchase(int gp_postId) throws DataAccessException {
		groupPurchaseMapper.Delete_GroupPurchase(gp_postId);
	}
	public GroupPurchase Update_GroupPurchase(GroupPurchase Post) throws DataAccessException {
		return groupPurchaseMapper.Update_GroupPurchase(Post);
	}

	
	// 자세히 보기 
	public GroupPurchase Detail_GroupPurchase(int gp_postId) throws DataAccessException {
		return groupPurchaseMapper.Detail_GroupPurchase(gp_postId);
	};
	
    // 공구 신청&취소
	public void Apply_GroupPurchase(int gp_postId) throws DataAccessException {
		groupPurchaseMapper.Apply_GroupPurchase(gp_postId);
	}; 
	public void Cancel_GroupPurchase(int gp_postId) throws DataAccessException {
		groupPurchaseMapper.Cancel_GroupPurchase(gp_postId);
		
	}
	
	// 디비에 삽입, 신청목록에 삽입
	public void insertGpApply(GpApply newApply) throws DataAccessException {
		groupPurchaseMapper.insertGpApply(newApply);	
	}
	public void deleteGpApply(GpApply delApply) throws DataAccessException {
		groupPurchaseMapper.deleteGpApply(delApply);
	}
	
	// ing 체크 및 UPDATE
	public void ingUpdate(int gp_postId) throws DataAccessException {
		groupPurchaseMapper.ingUpdate(gp_postId);
	}
	
	
}
