package com.example.openfeign.Service;

import com.example.openfeign.feignClients.FlipkartClient;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlipkartService {

    @Autowired
    FlipkartClient apicallingService;

    public ResponseEntity getShipmentDetailsfromFlipkart(String shipmentId){
        log.info("Got request to fetch shipment from flipkart : {}", shipmentId);
        try {
            ResponseEntity<String> responseEntity = apicallingService.getFlipkartShipment("Bearer 91473883-fc34-469e-a488-68714e8f169a", shipmentId);
            log.info("Response from Flipkart : {}", responseEntity);
            return ResponseEntity.ok(responseEntity.getBody());
        }
        catch (Exception e){
            log.error("Response from Flipkart : {}", e.getLocalizedMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
