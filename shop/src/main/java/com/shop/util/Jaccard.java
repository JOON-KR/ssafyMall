package com.shop.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shop.dto.CartDetailDto;
import com.shop.dto.ItemDto;
import com.shop.entity.Item;
import com.shop.repository.CartItemRepository;
import com.shop.repository.ItemRepository;
import com.shop.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Jaccard {

	private final ItemRepository itemRepository;
	private final ItemService itemService;
	private final CartItemRepository cartItemRepository;

	private List<Item> CalJaccardSimilar(List<CartDetailDto> User, List<List<CartDetailDto>> list) {
		
		List<double[]> filteredList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			List<CartDetailDto> tmp = list.get(i);
			Set<String> user = new HashSet<>();
			for(int j = 0; j < User.size();j++) {
				user.add(User.get(j).getItemNm());
			}
			Set<String> other = new HashSet<>();
			for(int j = 0; j < User.size();j++) {
				other.add(tmp.get(j).getItemNm());
			}

			// 교집합 부분
			Set<String> intersection = new HashSet<>(user);
			intersection.retainAll(other);
			
			// 합집합 부분
			Set<CartDetailDto> union = new HashSet<>(User);
			union.addAll(tmp);
			
			double jaccardScore = (double) intersection.size() / union.size();
			double [] temp = { i, jaccardScore };
			filteredList.add(temp);
		}
		Collections.sort(filteredList, (o1, o2)->Double.compare(o2[1],o1[1]));
		// 상위 10%의 데이터 수집
		int filteredSize = filteredList.size()/10;
			
		// 인덱스 저장용
		int indexVal = 0;
		Map<String, Integer> map = new HashMap<>();
		
		// 상위 10%유저의 찜 리스트 카운팅 정렬
		List<String[]> countingList = new ArrayList<String[]>();
		for(int i = 0; i< filteredSize; i++) {
			int idx = (int) filteredList.get(i)[0];
			List<CartDetailDto> cdd = list.get(idx);
			for(int j = 0; j<cdd.size();j++) {
				String name = cdd.get(j).getItemNm();
				if(map.containsValue(name)) {
					countingList.get(map.get(name))[1] = ""+(Integer.parseInt(countingList.get(map.get(name))[1])+1)  ;
				}else {
					map.put(name, indexVal++);
					String []temp = { name, "1"};
					countingList.add(temp);
				}
			}
		}
		Collections.sort(countingList,(o1,o2)->Integer.parseInt(o2[1])-Integer.parseInt(o1[1]));
		
		// 결과( 10개이내 상품 추출 )
		List<Item> result = new ArrayList<>();
		for(int i = 0; i<10 && i<countingList.size(); i++) {
			Item item= itemRepository.findByItemNm(countingList.get(i)[0]);
			result.add(item);
		}
		return result;
	}

}
