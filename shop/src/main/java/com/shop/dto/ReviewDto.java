package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewDto {

    private Long id;

    private Long itemId;

    private Long memberId;

    private String title;

    private String content;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;

}
