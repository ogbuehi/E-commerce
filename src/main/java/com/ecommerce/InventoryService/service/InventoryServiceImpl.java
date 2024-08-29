package com.ecommerce.InventoryService.service;

import com.ecommerce.InventoryService.dao.InventoryDao;
import com.ecommerce.InventoryService.dto.InventoryDto;
import com.ecommerce.InventoryService.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryDao inventoryDao;
    @Override
    public ResponseEntity<InventoryDto> getInventoryByProductId(Integer productId) {
        Inventory inventory = inventoryDao.findById(productId).orElse(null);
        InventoryDto inventoryDto = new InventoryDto();
        assert inventory != null;
        inventoryDto.setProductId(inventory.getProductId());
        inventoryDto.setQuantity(inventory.getQuantity());
        return new ResponseEntity<>(inventoryDto, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<InventoryDto>> getAllInventories() {
        List<Inventory> inventories = inventoryDao.findAll();
        InventoryDto inventoryDto = new InventoryDto();
        for (Inventory inventory:
             inventories) {
            inventoryDto.setProductId(inventory.getProductId());
            inventoryDto.setQuantity(inventory.getQuantity());
        }
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        inventoryDtos.add(inventoryDto);
        return new ResponseEntity<>(inventoryDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateInventory(InventoryDto inventoryDto) {
        Inventory inventory = new Inventory();
        inventory.setProductId(inventoryDto.getProductId());
        inventory.setQuantity(inventoryDto.getQuantity());
        inventoryDao.save(inventory);
        return new ResponseEntity<>("UPDATED INVENTORY", HttpStatus.OK);
    }
}
