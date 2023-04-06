package com.micro.userService.controller;


import com.micro.userService.dto.ItemResponse;
import com.micro.userService.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    ItemService itemService;
    @GetMapping("/item/finaAll")
    public ResponseEntity<ItemResponse> findAllItems(){
        return new ResponseEntity<>(itemService.findAllItems(), HttpStatus.OK);
    }
}
