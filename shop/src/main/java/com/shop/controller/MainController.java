package com.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shop.dto.ItemSearchDto;
import com.shop.dto.MainItemDto;
import com.shop.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ItemService itemService;

    @GetMapping(value = "/")
    public String main(Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 6);
        // 초기 로드 시 빈 검색어 리스트로 검색
        List<String> keywords = List.of();
        Page<MainItemDto> items = itemService.getMainItemPage(keywords, pageable);
        
        model.addAttribute("items", items);
        model.addAttribute("itemSearchDto", new ItemSearchDto());
        model.addAttribute("maxPage", 5);

        return "main";
    }

    @PostMapping(value = "/", consumes = "application/json")
    public String search(@RequestBody List<String> keywords, Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 6);

        Page<MainItemDto> items = itemService.getMainItemPage(keywords, pageable);
        System.out.println("keywords = " + keywords);
        ItemSearchDto itemSearchDto = new ItemSearchDto();
        itemSearchDto.setSearchQuery(keywords.get(0));
        
        model.addAttribute("items", items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 5);

        return "main";
    }
}
