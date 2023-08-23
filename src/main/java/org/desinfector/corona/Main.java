package org.desinfector.corona;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        CoronaDesinfector coronaDesinfector = ObjectFactory.getInstance().createObject(CoronaDesinfector.class);
        ApplicationContext context = Application.run("org.desinfector.corona", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronaDesinfector coronaDesinfector = context.getObject(CoronaDesinfector.class);
        coronaDesinfector.start(new Room());
    }
}
