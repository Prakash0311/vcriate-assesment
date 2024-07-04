package com.example.stockInventory.repository;

import com.example.stockInventory.entity.RestockOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestockOrderRepository extends JpaRepository<RestockOrder, Long> {
}
