package com.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "entities")
@Getter @Setter
@ToString
public class Entities {

    @Id
    @Column(name = "entities_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "item_nm", nullable = false)
    private String itemNm;

    @Column(name = "entity", nullable = false)
    private String entity;

    @Column(name = "weight", nullable = false)
    private Double weight;
}
