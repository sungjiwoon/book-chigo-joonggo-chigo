package com.bookchigo.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.bookchigo.domain.AuctionBid;
import com.bookchigo.domain.AuctionItem;
import com.bookchigo.domain.Member;
import com.bookchigo.domain.Notice;
@Mapper
public interface AuctionMapper {

	//경매 게시글 작성시 사용
	void insertAuctionItem(AuctionItem ai); //1
	void updateAuctionItem(AuctionItem ai); //2
	void deleteAuctionItem(int au_itemId); //3
	
	// 경매 게시글 검색시 사용 1. 아이템 이름 2. 작가로 
	List<AuctionItem> searchAuctionByItemName(String itemname); //4
	List<AuctionItem> searchAuctionByAuthor(String author); //5
	
	// 게시글 상세보기할 때 
	AuctionItem selectAuctionItem(int au_itemId); //6
	//경매 아이템 리스트 불러올 때  
	List<AuctionItem> selectAuctionItemList(); //7
	
	//입찰 시 사용
	void insertAuctionBid(AuctionBid ai); //8
	
	//경매 입찰 목록 뽑을 때 사용
	List<AuctionBid> selectAuctionBidList(int au_itemId); //9
	
	//낙찰 시 사용자한테 메세지 넣을 때 사용. 
	void insertNoticeMessageByAuction(Notice no); //10
	
	//경매 게시글 및 입찰 거래 상태 수정시 사용 
	void updateAuctionBidDealStatus(AuctionBid ab); //11
	void updateAuctionItemDealStatus(AuctionItem ai); //12
	
	//맴버 정보 불러옴.. 
	Member selectMemberByAuction(int memberId); //13
	
	//가장 높은 가격의 입찰 목록 뽑기. 
	AuctionBid selectAuctionBidOrderByPrice(@Param("au_itemId") int au_itemId); //14
	
	//경매 게시글 목록 불러오기
	List<AuctionItem> selectAuctionItemByMemberId(int memberId); //15
	
	//경매 내가 한 입찰 목록 불러오기. 
	List<AuctionBid> selectAuctionBidByMemberId(int memberId); //16
	
	//경매 아이템 마감시 사용할 것. 
	void updateAuctionBidDealStatusByAll(@Param("bidstatus") int bidstatus, @Param("au_itemId") int au_itemId); //17
	
	void deleteAuctionBid(int au_itemId); //18
	

}
