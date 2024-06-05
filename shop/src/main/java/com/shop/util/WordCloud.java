package com.shop.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shop.dto.EntitiesDto;
import com.shop.entity.Item;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WordCloud {
	
	public List<Item> cosineSimilarity(List<EntitiesDto> Item, List<List<EntitiesDto>> list) {
		List<Item> result = new ArrayList<Item>();
		for (List<EntitiesDto> entityList : list) {
			//엔티티 리스트
			String[] entities = entityList(entityList, Item);
			Map<String, Integer> index = new HashMap<>();
			
			for (int i=0; i<entities.length; i++) {
				index.put(entities[i], i);
			}
			//A와 B벡터화
			double [] ItemVector = vectorization(index, entities.length, Item);
			double [] otherVector = vectorization(index, entities.length, entityList);
			
			//A와 B 코사인 유사도 계산
		}
		
		
		return result;
	}
	
	//엔티티 리스트화
	 public static String[] entityList(List<EntitiesDto> A, List<EntitiesDto> B) {
	        Set<String> entitySet = new HashSet<>();
	        // 상품 A 엔티티 추가
	        for (EntitiesDto entity : A) {
	            entitySet.add(entity.getEntity());
	        }
	        // 상품 B 엔티티 추가
	        for (EntitiesDto entity : B) {
	            entitySet.add(entity.getEntity());
	        }

	        // 엔티티 목록을 배열로 변환
	        return entitySet.toArray(new String[0]);
	 }
	 //벡터화
	 public static double [] vectorization(Map<String, Integer> map, int size, List<EntitiesDto> item) {
		 double [] ItemVector = new double[size];
		 
		 for(EntitiesDto entity : item) {
			 //각 가중치를 벡터값에 대입
			 if(map.containsKey(entity.getEntity())){
				 int idx = map.get(entity.getEntity());
				 ItemVector[idx] = entity.getWeight();
			 }
		 }
		 return ItemVector;
	 }
	 
	 // 두 벡터의 코사인 유사도 계산
	    public static double calculateCosineSimilarity(double[] vector1, double[] vector2) {
	        double dotProduct = 0.0;
	        double norm1 = 0.0;
	        double norm2 = 0.0;

	        // 내적 계산
	        for (int i = 0; i < vector1.length; i++) {
	            dotProduct += vector1[i] * vector2[i];
	            norm1 += Math.pow(vector1[i], 2);
	            norm2 += Math.pow(vector2[i], 2);
	        }

	        // 벡터 크기의 곱 계산
	        norm1 = Math.sqrt(norm1);
	        norm2 = Math.sqrt(norm2);

	        // 코사인 유사도 계산
	        double cosineSimilarity = dotProduct / (norm1 * norm2);

	        return cosineSimilarity;
	    }
}
