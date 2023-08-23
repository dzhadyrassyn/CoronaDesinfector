package org.desinfector.corona;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        JavaConfig config = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext applicationContext = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(applicationContext);
        applicationContext.setObjectFactory(objectFactory);

        return applicationContext;
    }
}
