package org.desinfector.corona;

public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
