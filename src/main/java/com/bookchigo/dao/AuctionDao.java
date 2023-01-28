package com.bookchigo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bookchigo.domain.AuctionBid;
import com.bookchigo.domain.AuctionItem;
import com.bookchigo.domain.Member;
import com.bookchigo.domain.Notice;

public interface AuctionDao {
	
		//경매 게시글 작성시 사용
		void insertAuctionItem(AuctionItem ai) throws DataAccessException;
		void updateAuctionItem(AuctionItem ai) throws DataAccessException;
		void deleteAuctionItem(int au_itemId) throws DataAccessException;
		
		// 경매 게시글 검색시 사용 1. 아이템 이름 2. 작가로 
		List<AuctionItem> searchAuctionByItemName(String itemname) throws DataAccessException;
		List<AuctionItem> searchAuctionByAuthor(String author) throws DataAccessException;
		
		// 게시글 상세보기할 때 
		AuctionItem selectAuctionItem(int au_itemId) throws DataAccessException;
		//경매 아이템 리스트 불러올 때 
		List<AuctionItem> selectAuctionItemList() throws DataAccessException;
		
		//입찰 시 사용
		void insertAuctionBid(AuctionBid ai) throws DataAccessException;
		
		//경매 입찰 목록 뽑을 때 사용
		List<AuctionBid> selectAuctionBidList(int au_itemId) throws DataAccessException;
		
		//낙찰 시 사용자한테 메세지 넣을 때 사용. 
		void insertNoticeMessageByAuction(Notice no) throws DataAccessException;
		
		//경매 게시글 및 입찰 거래 상태 수정시 사용 
		void updateAuctionBidDealStatus(AuctionBid ab) throws DataAccessException;
		void updateAuctionItemDealStatus(AuctionItem ai) throws DataAccessException;
		
		//맴버 정보 불러옴.. 
		Member selectMemberByAuction(int memberId) throws DataAccessException;
		
		AuctionBid selectAuctionBidOrderByPrice(int au_itemId) throws DataAccessException;
		
		//경매 게시글 목록 불러오기
		List<AuctionItem> selectAuctionItemByMemberId(int memberId) throws DataAccessException;
		//경매 내가 한 입찰 목록 불러오기. 
		List<AuctionBid> selectAuctionBidByMemberId(int memberId) throws DataAccessException;
		
		//경매 마감시 사용함. 
		void updateAuctionBidDealStatusByAll(int bidstatus, int au_itemId) throws DataAccessException;
		
		void deleteAuctionBid(int au_itemId) throws DataAccessException;
		
		
}
