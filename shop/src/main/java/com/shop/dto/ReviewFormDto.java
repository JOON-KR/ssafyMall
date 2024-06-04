package com.shop.dto;

import com.shop.entity.Review;
import jakarta.validation.constraints.NotBlank;
import org.modelmapper.ModelMapper;

public class ReviewFormDto {

    private Long id;

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요")
    private String content;

    private static ModelMapper modelMapper = new ModelMapper();

    public Review createReview() { return modelMapper.map(this, Review.class); }

    public static  ReviewFormDto of(Review review) { return modelMapper.map(review
    , ReviewFormDto.class); }
}
