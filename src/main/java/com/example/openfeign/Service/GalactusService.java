package com.example.openfeign.Service;

/*
@author Gowtham on 2022-02-04
*/

import com.example.openfeign.feignClients.GalactusClient;
import com.example.openfeign.model.EoisEanMappingDTO;
import com.example.openfeign.utils.HeaderUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GalactusService {

    @Autowired
    GalactusClient galactusClient;

    @Autowired
    HeaderUtils headerUtils;

    public ResponseEntity insertEoisMap(List<EoisEanMappingDTO> eoisEanMappingDTOList, String tenantId){
        long t1 = System.currentTimeMillis();
        ResponseEntity<?> responseEntity = galactusClient.insertEanMapping(headerUtils.getHttpHeader(tenantId), eoisEanMappingDTOList);
        log.info("time to fetch consignment list from openFeign : {}", System.currentTimeMillis()-t1);
        return responseEntity;
    }
}
