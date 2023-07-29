package com.example.MarketPlaceBackendAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lots")
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "seller_id")
    private Long sellerId;

    @Column(name = "header")
    private String header;

    @Column(name = "text")
    private String text;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "datetime")
    private Date date;
}
