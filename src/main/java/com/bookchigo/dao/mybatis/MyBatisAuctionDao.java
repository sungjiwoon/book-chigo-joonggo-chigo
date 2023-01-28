package com.bookchigo.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.bookchigo.dao.AuctionDao;
import com.bookchigo.domain.AuctionBid;
import com.bookchigo.domain.AuctionItem;
import com.bookchigo.domain.Member;
import com.bookchigo.domain.Notice;
import com.bookchigo.dao.mybatis.mapper.AuctionMapper;

@Repository
public class MyBatisAuctionDao implements AuctionDao {
	@Autowired
	private AuctionMapper auctionMapper;
	
	//경매 게시글 작성시 사용
	public void insertAuctionItem(AuctionItem ai) throws DataAccessException {
		auctionMapper.insertAuctionItem(ai);
	}
	public void updateAuctionItem(AuctionItem ai) throws DataAccessException{
		auctionMapper.updateAuctionItem(ai);
	}
	public void deleteAuctionItem(int au_itemId) throws DataAccessException {
		auctionMapper.deleteAuctionItem(au_itemId);
	}
			
	// 경매 게시글 검색시 사용 1. 아이템 이름 2. 작가로 
	public List<AuctionItem> searchAuctionByItemName(String itemName) throws DataAccessException {
		return auctionMapper.searchAuctionByItemName(itemName);
	}
	public List<AuctionItem> searchAuctionByAuthor(String author) throws DataAccessException {
		return auctionMapper.searchAuctionByAuthor(author);
	}
			
	// 게시글 상세보기할 때 
	public AuctionItem selectAuctionItem(int au_itemId) throws DataAccessException{
		return auctionMapper.selectAuctionItem(au_itemId);
	}
	//경매 아이템 리스트 불러올 때 
	public List<AuctionItem> selectAuctionItemList() throws DataAccessException{
		return auctionMapper.selectAuctionItemList();
	}
			
	//입찰 시 사용
	public void insertAuctionBid(AuctionBid ai) throws DataAccessException {
		auctionMapper.insertAuctionBid(ai);
	}
			
	//경매 입찰 목록 뽑을 때 사용
	public List<AuctionBid> selectAuctionBidList(int au_itemId) throws DataAccessException {
		return auctionMapper.selectAuctionBidList(au_itemId);
	}
		
	//낙찰 시 사용자한테 메세지 넣을 때 사용. 
	public void insertNoticeMessageByAuction(Notice no) throws DataAccessException {
		auctionMapper.insertNoticeMessageByAuction(no);
	}
	//경매 게시글 및 입찰 거래 상태 수정시 사용 
	public void updateAuctionBidDealStatus(AuctionBid ab) throws DataAccessException {
		auctionMapper.updateAuctionBidDealStatus(ab);
	}
	public void updateAuctionItemDealStatus(AuctionItem ai) throws DataAccessException {
		auctionMapper.updateAuctionItemDealStatus(ai);
	}
			
	//맴버 정보 불러옴.. 
	public Member selectMemberByAuction(int memberId) throws DataAccessException{
		return auctionMapper.selectMemberByAuction(memberId);
	}
	
	public AuctionBid selectAuctionBidOrderByPrice(int au_itemId) throws DataAccessException{
		return auctionMapper.selectAuctionBidOrderByPrice(au_itemId);
	}
	
	//경매 게시글 목록 불러오기
	public List<AuctionItem> selectAuctionItemByMemberId(int memberId) {
		return auctionMapper.selectAuctionItemByMemberId(memberId);
	}
	//경매 내가 한 입찰 목록 불러오기. 
	public List<AuctionBid> selectAuctionBidByMemberId(int memberId) {
		return auctionMapper.selectAuctionBidByMemberId(memberId);
	}
	
	public void updateAuctionBidDealStatusByAll(int bidstatus, int au_itemId) {
		System.out.println("My batisAuction : updateAuctionBidDealStatusByAll ");
		auctionMapper.updateAuctionBidDealStatusByAll(bidstatus, au_itemId);
	}
	
	public void deleteAuctionBid(int au_itemId) {
		auctionMapper.deleteAuctionBid(au_itemId);
	}

}
