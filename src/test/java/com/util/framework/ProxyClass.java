package com.util.framework;

import org.testng.annotations.BeforeTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyClass implements InvocationHandler
{
    private Object target;
    public ProxyClass(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        ILog log = new CustomLog();
        log.uLog("Executing before");
        return method.invoke(target, args);

    }
}
