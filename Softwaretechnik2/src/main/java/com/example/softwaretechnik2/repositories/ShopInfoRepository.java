package com.example.softwaretechnik2.repositories;

import com.example.softwaretechnik2.model.ShopInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ShopInfoRepository extends CrudRepository<ShopInformation, String> {

    // Find shop information by its name
    public ShopInformation findShopInformationByName(String name);

    // Delete shop information by its name
    @Transactional
    public void deleteShopInformationByName(String name);
}

