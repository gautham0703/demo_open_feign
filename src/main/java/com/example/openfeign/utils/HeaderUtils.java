package com.example.openfeign.utils;

/*
@author Gowtham on 2022-02-03
*/

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HeaderUtils {

    public static final String X_TENANT_ID ="X-Tenant-Id";
    private static final String X_ROLES ="X-Roles";
    private static final String ROLE_SUPER_WOMAN ="ROLE_SUPER_WOMAN";
    private static final String X_FC_ID = "X-FC-ID";


    public Map<String, String> getHttpHeader(String tenantId) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put(X_TENANT_ID, tenantId);
        headerMap.put(X_ROLES,ROLE_SUPER_WOMAN);
        headerMap.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return headerMap;
    }

    public Map<String, String> getHttpHeaderForFcId(String tenantId, String fcId) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put(X_TENANT_ID, tenantId);
        headerMap.put(X_ROLES,"ROLE_SUPER_WOMAN");
        headerMap.put(X_FC_ID, fcId);
        headerMap.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return headerMap;
    }


}
