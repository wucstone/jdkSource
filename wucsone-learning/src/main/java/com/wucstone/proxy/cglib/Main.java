package com.wucstone.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Main {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tools.class);
        enhancer.setCallback(new ToolsInterceptor());
        Tools proxy= (Tools)enhancer.create();
        proxy.operate();
    }

}
