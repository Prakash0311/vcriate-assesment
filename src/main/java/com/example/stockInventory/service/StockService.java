package com.example.stockInventory.service;

import com.example.stockInventory.entity.Item;
import com.example.stockInventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item updatedItem) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Item item = existingItem.get();
            item.setName(updatedItem.getName());
            item.setDescription(updatedItem.getDescription());
            item.setPrice(updatedItem.getPrice());
            item.setQuantity(updatedItem.getQuantity());
            return itemRepository.save(item);
        }
        return null;
    }

    public void removeItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
