package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ItemRepository extends JpaRepository<Item, Long>,
        QuerydslPredicateExecutor<Item>, ItemRepositoryCustom {

    Item findByItemNm(String itemNm);

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThan(Integer price);

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    @Query("select i from Item i where i.itemDetail like " +
            "%:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value="select * from item i where i.item_detail like " +
            "%:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);

    @Query("SELECT i FROM Item i WHERE i.itemNm IN :itemNames")
    List<Item> findByItemNmIn(@Param("itemNames") List<String> itemNames);

    @Query(value = "SELECT i.* FROM item i LEFT JOIN cart_item c ON i.item_id = c.item_id GROUP BY i.item_id ORDER BY COUNT(c.cart_item_id) DESC LIMIT 10", nativeQuery = true)
    List<Item> findItemsOrderByCartItemCount();
}