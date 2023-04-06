package com.micro.adminService.service;

import com.micro.adminService.dto.AddItemRequest;
import com.micro.adminService.dto.AddItemResponse;

public interface ItemService {
    AddItemResponse addNewItem(AddItemRequest addItemRequest);
}
