package com.micro.adminService.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddItemResponse {
    private String status;
    private Integer statusCode;
    private JsonNode data;
    private String message;
}
