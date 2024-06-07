package com.shop.controller;
import java.util.*;

import com.shop.dto.EntitiesDto;
import com.shop.entity.Item;
import com.shop.entity.Review;
import com.shop.repository.ItemRepository;
import com.shop.repository.ReviewRepository;
import com.shop.util.Cosine;
import com.shop.util.GcpNaturalLanguage;
import com.shop.util.Jaccard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class Controller {
    private final Jaccard jaccard;
    private final GcpNaturalLanguage gnl;
    private final ReviewRepository reviewRepository;

    private final ItemRepository itemRepository;
    private final Cosine cos;
    @GetMapping("/cosine/{itemNm}")
    public ResponseEntity<?> getCosineItem (@PathVariable String itemNm){
        List<Item> result = cos.getSimilarityItem(itemNm);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/item/{itemNm}")
    public ResponseEntity<?> getItem(@PathVariable String itemNm) {
        Item item = itemRepository.findByItemNm(itemNm);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/item")
    public ResponseEntity<?> getItems (){
        List<Item> result = itemRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/search")
    public  ResponseEntity<?> getSearchItem(@RequestBody List<String> keywords) {
        List<Item> result = itemRepository.findByItemNmIn(keywords);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/jaccard/{memberId}")
    public ResponseEntity<?> getJaccardItem (@PathVariable String memberId){
        List<Item> result = jaccard.getJaccardSimilar(memberId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/positive/{itemNm}")
    public ResponseEntity<?> getPositive(@PathVariable String itemNm){
        List<EntitiesDto>result = gnl.getPositiveEntities(itemNm);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/negative/{itemNm}")
    public ResponseEntity<?> getNegative(@PathVariable String itemNm){
        List<EntitiesDto>result = gnl.getNegativeEntities(itemNm);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/review/{itemNm}")
    public ResponseEntity<?> getReview(@PathVariable String itemNm){
        List<Review>result = reviewRepository.findByItemNm(itemNm);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/score/{itemNm}")
    public ResponseEntity<?> getScore(@PathVariable String itemNm){
        double result = gnl.getTotalScore(itemNm);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
