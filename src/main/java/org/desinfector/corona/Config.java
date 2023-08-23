package org.desinfector.corona;

import org.reflections.Reflections;

public interface Config {

    <T> Class<? extends T> implClass(Class<T> inc);

    Reflections getScanner();
}
