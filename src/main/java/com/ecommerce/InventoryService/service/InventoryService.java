package com.ecommerce.InventoryService.service;

import com.ecommerce.InventoryService.dto.InventoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InventoryService {
    ResponseEntity<InventoryDto> getInventoryByProductId(Integer productId);
    ResponseEntity<List<InventoryDto>> getAllInventories();
    ResponseEntity<String> updateInventory(InventoryDto inventoryDto);
}
