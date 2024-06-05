package com.shop.repository;

import com.shop.entity.Entities;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class EntitiesRepositoryTest {

    @Autowired
    EntitiesRepository entitiesRepository;

    @PersistenceContext
    EntityManager em;

    @BeforeEach
    public void setup() {
        Entities entity = new Entities();
        entity.setItemNm("sdf");
        entity.setEntity("someEntity");
        entity.setWeight(10.0);
        entitiesRepository.save(entity);
    }

    @Test
    @DisplayName("상품명으로 Entities 조회 테스트")
    public void findByItemNm(){
        List<Entities> entitiesList = entitiesRepository.findByItemNm("sdf");
        System.out.println("entitiesList = " + entitiesList);
    }


}