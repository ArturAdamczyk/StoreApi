package com.example.storeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private String serialNumber;
    private String itemType;
    private String warrantyExpirationDate;
}