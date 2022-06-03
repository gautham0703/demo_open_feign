package com.example.openfeign.feignClients;

import com.example.openfeign.model.StoreSelfDeliveryModel;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static com.example.openfeign.feignClients.OmsClient.*;

@FeignClient(name="omsClient", url = "${oms.baseUrl}", fallbackFactory = OmsClientFallBackFactory.class)
public interface OmsClient {

    @PostMapping("store/orders/storeDelivery")
    public ResponseEntity<String> getConsignmentList(@RequestHeader Map<String, String> headerMap, @RequestBody StoreSelfDeliveryModel storeSelfDeliveryModel);

    @GetMapping("/consignment/{consignmentId}")
    public ResponseEntity<String> getConsignment(@RequestHeader Map<String, String> headerMap, @PathVariable("consignmentId") String consignmentId);


    @Component
    static class OmsClientFallBackFactory implements FallbackFactory<OmsClient> {
        @Override
        public OmsClient create(Throwable cause) {
            return new OmsClient() {
                @Override
                public ResponseEntity<String> getConsignmentList(Map<String, String> headerMap, StoreSelfDeliveryModel storeSelfDeliveryModel) {
                    return new ResponseEntity<String>("Server at capacity. Please retry after sometime", HttpStatus.MULTI_STATUS);
                }

                @Override
                public ResponseEntity<String> getConsignment(Map<String, String> headerMap, String consignmentId) {
                    return new ResponseEntity<String>("Server at capacity. Please retry after sometime", HttpStatus.MULTI_STATUS);
                }
            };
        }
    }
}
