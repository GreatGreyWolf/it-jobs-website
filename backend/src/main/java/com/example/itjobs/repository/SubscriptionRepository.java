package com.example.itjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.itjobs.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
