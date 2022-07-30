package com.example.demo.Service.Impl;

import com.example.demo.Entity.Item;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.Service.ItemService;
import com.example.demo.Service.UserService;
import com.example.demo.dto.ItemDTO;
import com.example.demo.handlerexception.CustomException;
import common.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

  private ItemRepository itemRepository;

  private UserService userService;

  public ItemServiceImpl(ItemRepository itemRepository,
                         UserService userService) {
    this.itemRepository = itemRepository;
    this.userService = userService;
  }
  @Override
  public Item create(ItemDTO request) throws CustomException{
    Integer userId = request.getUserId();

    Optional<User> userOpt = userService.findById(userId);
    userOpt.orElseThrow(() -> new CustomException("user not found", Constant.ERROR_TITLE, 1001, HttpStatus.NOT_FOUND));
//    if(!userOpt.isPresent()){
//      throw new CustomException("item exist", "duplicate", 1001, HttpStatus.CONFLICT);
//    }

    Optional<Item> itemOpt = itemRepository.findByName(request.getName());
    if (itemOpt.isPresent()) {
      throw new CustomException("item exist", "duplicate", 1001, HttpStatus.CONFLICT);
    }

    Item item = new Item();
    item.setName(request.getName());
    item.setUserId(request.getUserId());
    Item newItem = itemRepository.saveAndFlush(item);
    return newItem;
  }

  @Override
  public Item findById(Integer itemId) throws CustomException{
    Optional<Item> opt = itemRepository.findById(itemId);
    opt.orElseThrow(() -> new CustomException("item not found", Constant.ERROR_TITLE, 1001, HttpStatus.NOT_FOUND));

    return opt.get();
  }

  @Override
  public void delete(Integer itemId) throws CustomException{
    Optional<Item> opt = itemRepository.findById(itemId);
    opt.orElseThrow(() -> new CustomException("item not found", Constant.ERROR_TITLE, 1001, HttpStatus.NOT_FOUND));

    itemRepository.deleteById(itemId);
  }

  @Override
  public Item update(ItemDTO request, Integer itemId) throws CustomException{
    Optional<Item> opt = itemRepository.findById(itemId);
    opt.orElseThrow(() -> new CustomException("item not found", Constant.ERROR_TITLE, 1001, HttpStatus.NOT_FOUND));

    Item item = opt.get();
    item.setName(request.getName());
    item.setUserId(request.getUserId());

    Item item1 = itemRepository.saveAndFlush(item);
    return item1;
  }
}