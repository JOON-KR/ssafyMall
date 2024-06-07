package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

    @Query(value="select r.* from review r " +
            "join item i on r.item_id = i.item_id " +
            "where i.item_nm = :itemNm " +
            "order by r.reg_time desc", nativeQuery = true)
    List<Review> findByItemNm(@Param("itemNm") String itemNm);



}
