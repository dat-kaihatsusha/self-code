package com.example.demo.Service;

import com.example.demo.Entity.Item;
import com.example.demo.dto.ItemDTO;

public interface ItemService {
  Item create(ItemDTO request);

  Item findById(Integer itemId);

  void delete(Integer itemId);

  Item update(ItemDTO request, Integer itemId);
}
