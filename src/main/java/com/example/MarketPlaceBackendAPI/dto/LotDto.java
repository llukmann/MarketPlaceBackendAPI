package com.example.MarketPlaceBackendAPI.dto;

import com.example.MarketPlaceBackendAPI.models.Lot;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class LotDto {
    private Long id;
    private Long sellerId;
    private String header;
    private String text;
    private BigDecimal price;
    private Date date;

    public Lot toLot(){
        Lot lot = new Lot();
        lot.setId(id);
        lot.setSellerId(sellerId);
        lot.setHeader(header);
        lot.setText(text);
        lot.setPrice(price);
        lot.setDate(date);

        return lot;
    }

    public static LotDto fromLot(Lot lot){
        LotDto lotDto = new LotDto();
        lotDto.setId(lot.getId());
        lotDto.setSellerId(lot.getSellerId());
        lotDto.setHeader(lot.getHeader());
        lotDto.setText(lot.getText());
        lotDto.setPrice(lot.getPrice());
        lotDto.setDate(lot.getDate());

        return lotDto;
    }
}
