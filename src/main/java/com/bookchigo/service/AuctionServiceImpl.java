package com.bookchigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookchigo.dao.AuctionDao;
import com.bookchigo.domain.AuctionBid;
import com.bookchigo.domain.AuctionItem;
import com.bookchigo.domain.Member;
import com.bookchigo.domain.Notice;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionService {
	
	@Autowired
	private AuctionDao auctionDao;
	
	//1) 경매 아이템 게시글 등록시 사용
	public void insertAuctionItem(AuctionItem ai) {
		auctionDao.insertAuctionItem(ai);
	}
	//2) 경매 게시글 수정 시 사용
	public void updateAuctionItem(AuctionItem ai) {
		auctionDao.updateAuctionItem(ai);
	}
	//3) 경매 게시글 삭제할 시 혹은 마감 시 사용.
	public void deleteAuctionItem(int au_itemId) {
		auctionDao.deleteAuctionItem(au_itemId);
	}
	//4) 경매 아이템 이름으로 검색할 때 사용 return 값 : 해당 경매 게시글 아이디 
	public List<AuctionItem> searchAuctionByItemName(String itemname) {
		return auctionDao.searchAuctionByItemName(itemname);
	}
	//5) 경매 아이템 작가 이름으로 검색할 때 사용. retrun : 해당 경매 게시글 아이디 
	public List<AuctionItem> searchAuctionByAuthor(String author) {
		return auctionDao.searchAuctionByAuthor(author);
	}
	//6) 경매 아이템 게시글 상세보기로 불러올 때 사용.
	public AuctionItem selectAuctionItem(int au_itemId) {
		return auctionDao.selectAuctionItem(au_itemId);
	}
	//7) 경매 게시글 리스트 불러올 때 사용. (가장 먼저 불러오는)
	public List<AuctionItem> selectAuctionItemList() {
		return auctionDao.selectAuctionItemList();
	}
	//8) 경매 입찰시 사용. 
	public void insertAuctionBid(AuctionBid ab) {
		auctionDao.insertAuctionBid(ab);
	}
	//9) 경매 입찰 리스트 불러올 때
	public List<AuctionBid> selectAuctionBidList(int au_itemId) {
		return auctionDao.selectAuctionBidList(au_itemId);
	}
	//10) 경매 입찰 상태 수정하고 싶을 때 사용
	public void updateAuctionBidDealStatus(AuctionBid ab) {
		auctionDao.updateAuctionBidDealStatus(ab);
	}
	//11) 경매 아이템 상태 수정하고 싶을 때 사용.
	public void updateAuctionItemDealStatus(AuctionItem ai) {
		auctionDao.updateAuctionItemDealStatus(ai);
	}
	//12) 마감하고, 낙찰자한테 알림등록 시 사용.
	public void insertNoticeMessageByAuction(Notice no) {
		auctionDao.insertNoticeMessageByAuction(no);
	}
	//13) 낙찰자 정보 불러올 때사용.
	public Member selectMemberByAuction(int memberId) {
		return auctionDao.selectMemberByAuction(memberId);
	}
	//14) 가장 높은 가격의 입찰자 불러옴.
	public AuctionBid selectAuctionBidOrderByPrice(int au_itemId) {
		return auctionDao.selectAuctionBidOrderByPrice(au_itemId);
	}
	//15) 경매 게시글 목록 불러오기
	public List<AuctionItem> selectAuctionItemByMemberId(int memberId) {
		return auctionDao.selectAuctionItemByMemberId(memberId);
	}
	//16) 경매 내가 한 입찰 목록 불러오기. 
	public List<AuctionBid> selectAuctionBidByMemberId(int memberId) {
		return auctionDao.selectAuctionBidByMemberId(memberId);
	}
	//17) 경매 마감시 사용하는, 입찰 상태 전부 변경. 
	public void updateAuctionBidDealStatusByAll(int bidstatus, int au_itemId) {
		System.out.println("AuctionServiceImpl: updateAuctionBidDealStatusByAll ");
		auctionDao.updateAuctionBidDealStatusByAll(bidstatus, au_itemId);
	}
	
	public void deleteAuctionBid(int au_itemId) {
		auctionDao.deleteAuctionBid(au_itemId);
	}

}
