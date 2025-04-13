package com.example.books.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vendor_code", nullable = true)
    private String vendorCode;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private Long year;

    @Column(name = "brand")
    private String brand;

    @Column(name = "stock")
    private String stock;

    @Column(name = "price")
    private BigDecimal price;

}
