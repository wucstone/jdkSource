package com.wucstone.spring;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.TreeMap;

@Configurable
@ComponentScan("com.wucstone.spring.*")
public class AppConfig {

    public static void main(String[] args) {
        System.out.println(calc(new BigDecimal(3), new BigDecimal(9),new BigDecimal(9)));

    }
    public static BigDecimal calc(BigDecimal a,BigDecimal b,BigDecimal c){

        if(mal(b,a).intValue()<=c.intValue()){
            return b;
        }else{
            return calc(a,b.divide(new BigDecimal(2)),c);
        }

    }
    public static BigDecimal mal(BigDecimal x,BigDecimal y){
        BigDecimal result = new BigDecimal(1);
        for(int i=0;i<y.intValue();i++){
            result = result.multiply(x) ;
        }
        return result;
    }
}
