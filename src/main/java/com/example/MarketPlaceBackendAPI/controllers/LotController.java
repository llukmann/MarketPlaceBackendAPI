package com.example.MarketPlaceBackendAPI.controllers;

import com.example.MarketPlaceBackendAPI.dto.LotDto;
import com.example.MarketPlaceBackendAPI.models.Lot;
import com.example.MarketPlaceBackendAPI.service.LotService;
import com.example.MarketPlaceBackendAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lots/")
public class LotController {
    private final LotService lotService;
    private final UserService userService;

    @Autowired
    public LotController(LotService lotService, UserService userService) {
        this.lotService = lotService;
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LotDto> findLotById(@PathVariable("id") Long id){
        Lot lot = lotService.findById(id);

        if(lot == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        LotDto result = LotDto.fromLot(lot);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("all")
    public List<Lot> findAll(){
        return lotService.findAll();
    }

    @GetMapping("all/user{id}")
    public List<Lot> findAllBySellerId(@PathVariable("id") Long id){
        return lotService.findAllBySellerId(id);
    }

    @PostMapping("new")
    public ResponseEntity create(@RequestBody LotDto lotDto){
        Lot lot = lotService.create(lotDto);
        LotDto response = LotDto.fromLot(lot);

        return ResponseEntity.ok(response);
    }
}
