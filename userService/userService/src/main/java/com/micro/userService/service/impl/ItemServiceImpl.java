package com.micro.userService.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.userService.dto.ItemResponse;
import com.micro.userService.entity.Item;
import com.micro.userService.repository.ItemRepository;
import com.micro.userService.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ObjectMapper objectMapper;

    public ItemResponse findAllItems(){
       ItemResponse itemResponse = new ItemResponse();
       try{
           itemResponse.setItemList(itemRepository.findAll());
           itemResponse.setStatusCode(objectMapper.convertValue(HttpStatus.OK.value(), Integer.class));
       }catch(Exception e){
           log.info("Exception occurred while fetching items: ", e);
           itemResponse.setStatusCode(objectMapper.convertValue(HttpStatus.INTERNAL_SERVER_ERROR.value(), Integer.class));
           itemResponse.setItemList(null);
       }
       return itemResponse;
    }
}
