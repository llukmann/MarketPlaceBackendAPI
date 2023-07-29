package com.example.MarketPlaceBackendAPI.repo;

import com.example.MarketPlaceBackendAPI.models.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotRepository extends CrudRepository<Lot, Long> {
    Lot getLotById(Long id);
    List<Lot> findAll();
    List<Lot> findAllBySellerId(Long id);
    void deleteById(Long id);
    Lot save(Lot lot);
}
