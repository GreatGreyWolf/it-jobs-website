package com.example.itjobs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import com.example.itjobs.service.GoodieService;
import com.example.itjobs.entity.Goodie;

@RestController
@RequestMapping("/api/goodies")
public class GoodieController {

    private final GoodieService goodieService;

    @Autowired
    public GoodieController(GoodieService goodieService) {
        this.goodieService = goodieService;
    }

    @GetMapping
    public List<Goodie> getAllGoodies() {
        return goodieService.getAllGoodies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goodie> getGoodieById(@PathVariable Long id) {
        Optional<Goodie> goodie = goodieService.getGoodieById(id);
        if (goodie.isPresent()) {
            return ResponseEntity.ok(goodie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Goodie> createGoodie(@Valid @RequestBody Goodie goodie) {
        Goodie createdGoodie = goodieService.saveGoodie(goodie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGoodie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goodie> updateGoodie(@PathVariable Long id, @Valid @RequestBody Goodie updatedGoodie) {
        if (!goodieService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedGoodie.setId(id);
        Goodie savedGoodie = goodieService.saveGoodie(updatedGoodie);
        return ResponseEntity.ok(savedGoodie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoodie(@PathVariable Long id) {
        if (!goodieService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        goodieService.deleteGoodie(id);
        return ResponseEntity.noContent().build();
    }
}