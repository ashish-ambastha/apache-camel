package com.flipkart.apache.camel.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class DI {
    private static Injector INJECTOR = Guice.createInjector(new Module[0]);

    public DI() {
    }

    public static void install(Module module) {
        Class var1 = DI.class;
        synchronized(DI.class) {
            INJECTOR = Guice.createInjector(new Module[]{module});
        }
    }

    public static Injector di() {
        return INJECTOR;
    }
}
