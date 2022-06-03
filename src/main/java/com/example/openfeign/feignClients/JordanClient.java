package com.example.openfeign.feignClients;/*
@author Gowtham on 2022-02-04
*/

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

@FeignClient(name = "jordanClient", url = "${jordan.baseUrl}")
public interface JordanClient {

    @DeleteMapping(value = "/bucket/sambhaCache/evictAll")
    public ResponseEntity<?> evictAllSambhaBucketDetailsInCache();
}
