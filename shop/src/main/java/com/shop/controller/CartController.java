package com.shop.controller;

import com.shop.dto.CartItemDto;
import com.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartController {
    private final CartService cartService;

    @PostMapping("/cart/add")
    public ResponseEntity<?> addCart(@RequestBody CartItemDto cartItemDto, @RequestParam("name") String name) {
        cartService.addCart(cartItemDto, name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/cart")
    public ResponseEntity<?> getCart(@RequestParam String name) {
        return new ResponseEntity<>(cartService.getCartList(name), HttpStatus.OK);
    }
}
