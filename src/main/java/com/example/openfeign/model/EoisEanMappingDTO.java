package com.example.openfeign.model;

/*
@author Gowtham on 2022-02-04
*/

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.cloud.openfeign.FeignClient;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EoisEanMappingDTO {

    String source;

    String eoisEan;

    String omuniEan;


}
