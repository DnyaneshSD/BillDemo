package com.micro.userService.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.micro.userService.entity.Item;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemResponse {
    private Integer statusCode;
    //private JsonNode data;
    private List<Item> itemList;
//    private String message;
}
