package com.example.openfeign.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreSelfDeliveryModel {

    int pageNumber =1;
    int pageSize= 20;
    String fcId;
}
