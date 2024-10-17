package com.example.shopowner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ShopOwnerService {

    @Autowired
    private ShopOwnerRepository repo;

    public List<ShopOwner> listAll() {
        return repo.findAll();
    }

    public ShopOwner get(int id) {
        Optional<ShopOwner> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new NoSuchElementException("ShopOwner with ID " + id + " does not exist!");
        }
    }

    public ShopOwner addShopOwner(ShopOwner shopOwner) {
        return repo.save(shopOwner);
    }

    public ShopOwner updateShopOwner(ShopOwner shopOwner) {
        if (repo.existsById(shopOwner.getId())) {
            return repo.save(shopOwner);
        } else {
            throw new NoSuchElementException("ShopOwner with ID " + shopOwner.getId() + " does not exist!");
        }
    }

    public void deleteShopOwner(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new NoSuchElementException("ShopOwner with ID " + id + " does not exist!");
        }
    }
}
