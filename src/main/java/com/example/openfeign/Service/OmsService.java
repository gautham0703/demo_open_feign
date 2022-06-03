package com.example.openfeign.Service;

import com.example.openfeign.feignClients.OmsClient;
import com.example.openfeign.model.StoreSelfDeliveryModel;
import com.example.openfeign.utils.HeaderUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OmsService {

    @Autowired
    OmsClient omsClient;

    @Autowired
    HeaderUtils headerUtil;

    public ResponseEntity getConsignemntList(StoreSelfDeliveryModel storeSelfDeliveryModel, String tenantId){
        long t1 = System.currentTimeMillis();
        log.info("Request to fetch store self delivery consignment list :",storeSelfDeliveryModel);

        ResponseEntity<?> responseEntity = omsClient.getConsignmentList(headerUtil.getHttpHeaderForFcId(tenantId, storeSelfDeliveryModel.getFcId()), storeSelfDeliveryModel);
        log.info("time to fetch consignment list from openFeign : {}", System.currentTimeMillis()-t1);
        return responseEntity;
    }

    public ResponseEntity getConsignment(String consignmentId, String tenantId){
        long t1 = System.currentTimeMillis();
        ResponseEntity<?> responseEntity = omsClient.getConsignment(headerUtil.getHttpHeader(tenantId), consignmentId);
        log.info("time to fetch consignment list from openFeign : {}", System.currentTimeMillis()-t1);
        return responseEntity;
    }
}
