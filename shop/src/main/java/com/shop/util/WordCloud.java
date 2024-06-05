package com.shop.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.shop.dto.EntitiesDto;
import com.shop.entity.Item;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WordCloud {
	
	public List<Item> cosineSimilarity(List<EntitiesDto> Item, List<List<EntitiesDto>> list){
		List<Item>result = new ArrayList<Item>();
		
		
		
		
		
		
		return result;
	}
	
	//엔티티 리스트화
	 public static String[] entityList(List<EntitiesDto> A, List<EntitiesDto> B) {
	        Set<String> entitySet = new HashSet<>();
	        // 상품 A 엔티티 추가
	        for (EntitiesDto entity : A) {
	            entitySet.add(entity.());
	        }
	        // 상품 B 엔티티 추가
	        for (EntitiesDto entity : B) {
	            entitySet.add(entity.getEntityName());
	        }

	        // 엔티티 목록을 배열로 변환
	        return entitySet.toArray(new String[0]);
	    }
	    
}
