package com.shop.repository;

import com.shop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.dto.CartDetailDto;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByCartIdAndItemId(Long cartId, Long itemId);

    @Query("select new com.shop.dto.CartDetailDto(ci.id, ci.cart.member.name, i.itemNm, i.price, ci.count, i.imgUrl) " +
            "from CartItem ci " +
            "join ci.item i " +
            "where ci.cart.member.name = :memberId " +
            "and i.id = ci.item.id " +
            "order by ci.regTime desc"
            )
    List<CartDetailDto> findCartDetailDtoList(String memberId);

}