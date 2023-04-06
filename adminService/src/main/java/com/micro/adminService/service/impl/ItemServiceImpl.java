package com.micro.adminService.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.adminService.dto.AddItemRequest;
import com.micro.adminService.dto.AddItemResponse;
import com.micro.adminService.entity.Item;
import com.micro.adminService.repository.ItemRepository;
import com.micro.adminService.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ObjectMapper objectMapper;

    public AddItemResponse addNewItem(AddItemRequest addItemRequest){
       AddItemResponse addItemResponse = new AddItemResponse();
       try{
           if (Objects.nonNull(addItemRequest)){
               Item item = new Item();
               item.setItemName(addItemRequest.getItemName());
               Optional.ofNullable(addItemRequest.getDescription()).ifPresent(item::setDescription);
               item.setPrice((addItemRequest.getPrice()));
               Item savedItem = itemRepository.save(item);
               addItemResponse.setMessage("Item Added Successfully with ID :: " + savedItem.getId());
               addItemResponse.setStatus("Success");
               addItemResponse.setStatusCode(objectMapper.convertValue(HttpStatus.OK.value(), Integer.class));
               addItemResponse.setData(objectMapper.convertValue(item, JsonNode.class));
           }
       }catch(Exception e){
           log.info("Exception occurred while creating user: ", e);
           addItemResponse.setStatus(e.getMessage());
           addItemResponse.setMessage("Failed to add Item :: " + e.getMessage());
           addItemResponse.setStatusCode(objectMapper.convertValue(HttpStatus.BAD_REQUEST.value(), Integer.class));
           addItemResponse.setData(null);
       }
       return addItemResponse;
    }
}
