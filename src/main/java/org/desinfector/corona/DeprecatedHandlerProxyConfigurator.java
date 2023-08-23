package org.desinfector.corona;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {

            if (implClass.getInterfaces().length == 0) {
                return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler) (o, method, args) -> getInvocationHandlerObject(t, method, args));
            }
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerObject(t, method, args));
        } else {
            return t;
        }

    }

    private Object getInvocationHandlerObject(Object t, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println("******** Deprecated method");
        return method.invoke(t, args);
    }
}
