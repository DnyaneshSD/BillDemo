package com.micro.adminService.controller;

import com.micro.adminService.dto.AddItemRequest;
import com.micro.adminService.dto.AddItemResponse;
import com.micro.adminService.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    ItemService itemService;
    @PostMapping("/item/add")
    public ResponseEntity<AddItemResponse> addNewItem(@RequestBody AddItemRequest addItemRequest){
        return new ResponseEntity<>(itemService.addNewItem(addItemRequest), HttpStatus.OK);
    }
}
