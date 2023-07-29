package com.example.MarketPlaceBackendAPI.service.impl;

import com.example.MarketPlaceBackendAPI.dto.LotDto;
import com.example.MarketPlaceBackendAPI.models.Lot;
import com.example.MarketPlaceBackendAPI.models.User;
import com.example.MarketPlaceBackendAPI.repo.LotRepository;
import com.example.MarketPlaceBackendAPI.security.jwt.JwtUser;
import com.example.MarketPlaceBackendAPI.service.LotService;
import com.example.MarketPlaceBackendAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LotServiceImpl implements LotService {
    private final LotRepository lotRepository;
    private final UserService userService;

    @Autowired
    public LotServiceImpl(LotRepository lotRepository, UserService userService) {
        this.lotRepository = lotRepository;
        this.userService = userService;
    }

    @Override
    public Lot findById(Long id) {
        return lotRepository.getLotById(id);
    }

    @Override
    public List<Lot> findAll() {
        return lotRepository.findAll();
    }

    @Override
    public Lot create(LotDto lotDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtUser jwtUser = (JwtUser)authentication.getPrincipal();
        User seller = userService.findByUsername(jwtUser.getUsername());

        Lot newLot = new Lot();
        newLot.setId(lotDto.getId());
        newLot.setSellerId(seller.getId());
        newLot.setHeader(lotDto.getHeader());
        newLot.setText(lotDto.getText());
        newLot.setPrice(lotDto.getPrice());
        Date date = new Date();
        newLot.setDate(date);
        return lotRepository.save(newLot);
    }

    @Override
    public List<Lot> findAllBySellerId(Long id) {
        return lotRepository.findAllBySellerId(id);
    }

    @Override
    public void delete(LotDto lotDto) {
        lotRepository.deleteById(lotDto.getId());
    }
}
