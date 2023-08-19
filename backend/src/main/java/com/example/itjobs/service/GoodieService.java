package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.GoodieRepository;
import com.example.itjobs.entity.Goodie;

@Service
public class GoodieService {

    private final GoodieRepository GoodieRepository;

    @Autowired
    public GoodieService(GoodieRepository GoodieRepository) {
        this.GoodieRepository = GoodieRepository;
    }

    public boolean existsById(Long id) {
        return GoodieRepository.existsById(id);
    }

    public List<Goodie> getAllGoodies() {
        return GoodieRepository.findAll();
    }

    public Optional<Goodie> getGoodieById(Long id) {
        return GoodieRepository.findById(id);
    }

    public Goodie saveGoodie(Goodie Goodie) {
        return GoodieRepository.save(Goodie);
    }

    public void deleteGoodie(Long id) {
        GoodieRepository.deleteById(id);
    }
}