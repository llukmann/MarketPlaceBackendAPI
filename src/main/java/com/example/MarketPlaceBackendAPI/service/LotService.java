package com.example.MarketPlaceBackendAPI.service;

import com.example.MarketPlaceBackendAPI.dto.LotDto;
import com.example.MarketPlaceBackendAPI.models.Lot;

import java.util.List;

public interface LotService {
    Lot findById(Long id);
    List<Lot> findAll();
    Lot create(LotDto lotDto);
    List<Lot> findAllBySellerId(Long id);
    void delete(LotDto lotDto);
}
