package com.wucstone.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ToolsHander implements InvocationHandler {

    private Object object;

    public ToolsHander(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("tools operate before ...");
        method.invoke(object);
        System.out.println("tools operate after ...");

        return null;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),object.getClass().getInterfaces(),this);
    }
}
