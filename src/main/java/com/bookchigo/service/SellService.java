package com.bookchigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookchigo.dao.SellDao;
import com.bookchigo.domain.SellItem;
import com.bookchigo.domain.Wishlist;
import com.bookchigo.domain.BuyFin;

public interface SellService {

	public List<SellItem> getSellList();

	public List<SellItem> getSellByItemId(int itemId);

	public List<SellItem> getSellListByItemName(String itemName);

	public List<SellItem> getSellListByMemberId(int memberId);

	public void insertSellItem(SellItem item);

	public void updateSellItem(SellItem item);

	public void deleteSellItem(int itemId);

	public void updateDealStatus(SellItem item);

	public int getDealStatus(int itemId);

	public void insertWishlist(Wishlist wish);

	public List<Wishlist> selectWishlist(int memberId);

	public void deleteWishlist(int wishId);

	public int getMemberIdbyId(String id);

	public void insertBuyFin(BuyFin buy);

	public List<BuyFin> selectBuyFin(int memberId);
}
