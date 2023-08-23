package org.desinfector.corona;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    private Map<Class, Class> ifc2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        this.ifc2ImplClass = ifc2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }
    @Override
    public <T> Class<? extends T> implClass(Class<T> inc) {
        return ifc2ImplClass.computeIfAbsent(inc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(inc);
            if (classes.size() != 1) {
                throw new RuntimeException(inc + "Should be one or more impl");
            }

            return classes.iterator().next();
        });
    }
}
