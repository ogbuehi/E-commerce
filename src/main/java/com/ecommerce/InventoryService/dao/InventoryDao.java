package com.ecommerce.InventoryService.dao;

import com.ecommerce.InventoryService.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDao extends JpaRepository<Inventory, Integer> {
}
