package com.example.shopowner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ShopOwnerController {

    @Autowired
    private ShopOwnerService service;

    @GetMapping("/shopowners")
    public List<ShopOwner> list() {
        return service.listAll();
    }

    @GetMapping("/shopowners/{id}")
    public ResponseEntity<ShopOwner> get(@PathVariable int id) {
        try {
            ShopOwner shopOwner = service.get(id);
            return new ResponseEntity<>(shopOwner, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/shopowners")
    public ResponseEntity<ShopOwner> add(@RequestBody ShopOwner shopOwner) {
        service.addShopOwner(shopOwner);
        return new ResponseEntity<>(shopOwner, HttpStatus.CREATED);
    }

    @PutMapping("/shopowners/{id}")
    public ResponseEntity<ShopOwner> update(@RequestBody ShopOwner shopOwner, @PathVariable int id) {
        try {
            shopOwner.setId(id);
            ShopOwner updatedShopOwner = service.updateShopOwner(shopOwner);
            return new ResponseEntity<>(updatedShopOwner, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/shopowners/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            service.deleteShopOwner(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
