package com.ecommerce.InventoryService.controller;

import com.ecommerce.InventoryService.dto.InventoryDto;
import com.ecommerce.InventoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping("/{productId}")
    public ResponseEntity<InventoryDto> findInventoryByProductId(
            @PathVariable Integer productId){
        return inventoryService.getInventoryByProductId(productId);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<InventoryDto>> findAllInventories(){
        return inventoryService.getAllInventories();
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateInventory(@RequestBody InventoryDto inventoryDto){
        return inventoryService.updateInventory(inventoryDto);
    }
}
