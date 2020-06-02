package com.wucstone.spring;

import java.util.HashMap;
import java.util.Map;

public abstract class HelloWorldService {

    public static Map<String,HelloWorldService> map = new HashMap<>();

    /**
     * 查询商户门店信息
     */
    public String queryMerchantStoreInfo(String merchant, Map data){
        HelloWorldService merchantStoreInfoService = map.get(merchant);
        String json = merchantStoreInfoService.packageParams(merchant,data);
        return "";
    }

    protected abstract String packageParams(String merchant,Map data);


}
