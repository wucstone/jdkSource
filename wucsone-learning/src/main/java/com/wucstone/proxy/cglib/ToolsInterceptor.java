package com.wucstone.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ToolsInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object terget, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib operate before ...");
        Object object = methodProxy.invokeSuper(terget, objects);
        System.out.println("cglib operate after ...");
        return object;
    }
}
