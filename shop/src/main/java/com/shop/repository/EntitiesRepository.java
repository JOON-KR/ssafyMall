package com.shop.repository;

import java.util.List;

import com.shop.entity.Entities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntitiesRepository extends JpaRepository<Entities, Long> {

    List<Entities> findByItemNm(String itemNm);
}
