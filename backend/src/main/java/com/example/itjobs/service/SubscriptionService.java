package com.example.itjobs.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import com.example.itjobs.repository.SubscriptionRepository;
import com.example.itjobs.entity.Subscription;

@Service
public class SubscriptionService {

    private final SubscriptionRepository SubscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository SubscriptionRepository) {
        this.SubscriptionRepository = SubscriptionRepository;
    }

    public boolean existsById(Long id) {
        return SubscriptionRepository.existsById(id);
    }

    public List<Subscription> getAllSubscriptions() {
        return SubscriptionRepository.findAll();
    }

    public Optional<Subscription> getSubscriptionById(Long id) {
        return SubscriptionRepository.findById(id);
    }

    public Subscription saveSubscription(Subscription Subscription) {
        return SubscriptionRepository.save(Subscription);
    }

    public void deleteSubscription(Long id) {
        SubscriptionRepository.deleteById(id);
    }
}