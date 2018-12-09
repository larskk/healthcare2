package util;

import java.lang.reflect.Method;

public class misc {
    public static int noOfGettersOf(Class clazz) {
    int noOfGetters = 0;
    Method[] methods = clazz.getDeclaredMethods();
    for(Method method : methods) {
        String methodName = method.getName();
        if(methodName.startsWith("get")) {
            noOfGetters++;
        }
    }
    return noOfGetters;
}
}
