package com.example.openfeign.controller;

import com.example.openfeign.Service.FlipkartService;
import com.example.openfeign.Service.GalactusService;
import com.example.openfeign.Service.OmsService;
import com.example.openfeign.feignClients.OmsClient;
import com.example.openfeign.model.EoisEanMappingDTO;
import com.example.openfeign.model.StoreSelfDeliveryModel;
import com.example.openfeign.utils.HeaderUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.openfeign.utils.HeaderUtils.X_TENANT_ID;

@RestController
@RequestMapping(value = "/demo")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Controller {

    @Autowired
    FlipkartService flipkartService;

    @Autowired
    OmsService omsService;

    @Autowired
    GalactusService galactusService;

    @Autowired
    HeaderUtils headerUtils;

    @Autowired
    OmsClient omsClient;


    @GetMapping(value = "/shipment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFlipkartShipment(@RequestParam(value = "shipmentId") String shipmentId) {
        return flipkartService.getShipmentDetailsfromFlipkart(shipmentId);
    }

    @PostMapping(value = "/consignemntList")
    public ResponseEntity<?> getconsignmentList(@RequestBody StoreSelfDeliveryModel storeSelfDeliveryModel,
                                                @RequestHeader("X-Tenant-Id") String tenantId) {
        return omsService.getConsignemntList(storeSelfDeliveryModel, tenantId);
    }


    @GetMapping(value = "/consignemnt")
    public ResponseEntity<?> getConsignment(@RequestParam(value = "consignmentId") String consignmentId,
                                            @RequestHeader(X_TENANT_ID) String tenantId) {
        return omsService.getConsignment(consignmentId, tenantId);
    }

    @PostMapping(value = "/insertEoisMap", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertEoisMap(@RequestBody List<EoisEanMappingDTO> eoisEanMappingDTOS,
                                           @RequestHeader(X_TENANT_ID) String tenantId) {
        return galactusService.insertEoisMap(eoisEanMappingDTOS, tenantId);
    }
    @GetMapping(value = "/hello")
    public ResponseEntity<?> getHello(@RequestParam(value = "consignmentId") String consignmentId,
                                            @RequestHeader(X_TENANT_ID) String tenantId) {
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }

}