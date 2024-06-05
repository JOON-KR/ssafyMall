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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_nm")
    private Item item;

    @Column(name = "weight", nullable = false)
    private Double weight;
}
