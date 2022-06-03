package com.example.openfeign.feignClients;

/*
@author Gowtham on 2022-02-04
*/

import com.example.openfeign.config.FeignConfig;
import com.example.openfeign.model.EoisEanMappingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


import java.util.List;
import java.util.Map;

@FeignClient(name = "galactusClient", url = "${galactus.baseUrl}", configuration = FeignConfig.class)
public interface GalactusClient {

    @PostMapping(value = "/eanMapping/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertEanMapping(@RequestHeader Map<String, String> headerMap,
                                           @RequestBody List<EoisEanMappingDTO> eoisEanMappingDTO);
}
