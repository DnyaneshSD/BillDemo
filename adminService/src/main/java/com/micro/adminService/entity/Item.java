package com.micro.adminService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "item_name", nullable = false, length = 20)
    private String itemName;
    @Column(name = "description", nullable = true, length = 200)
    private String description;
    @Column(name = "price", nullable = false, length = 20)
    private int price;

}
