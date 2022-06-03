package com.example.openfeign.feignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


@FeignClient(name="flipkartClient", url = "https://api.flipkart.net/sellers/v3")
public interface FlipkartClient {

    @GetMapping(value = "/shipments")
    public ResponseEntity<String> getFlipkartShipment(@RequestHeader("Authorization") String authorization, @RequestParam("shipmentIds") String shipmentId);

}
