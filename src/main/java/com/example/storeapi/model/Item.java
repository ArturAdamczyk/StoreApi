package com.example.storeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String serialNumber;
    private ItemType itemType;
    private LocalDate warrantyExpirationDate;

    public enum ItemType {
        COMPUTER,
        TV,
        MOBILE_PHONE,
        TABLET,
        WATCH,
        LAPTOP,
        OTHER
    }

    public boolean isWarrantyExpired(){
        return this.getWarrantyExpirationDate()
                .isBefore(LocalDate.now());
    }
}
