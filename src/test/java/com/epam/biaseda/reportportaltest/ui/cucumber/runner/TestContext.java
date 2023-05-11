package com.epam.biaseda.reportportaltest.ui.cucumber.runner;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private final Map<String, Object> testContexts = new HashMap<>();

    private static final ThreadLocal<TestContext> instance = new ThreadLocal<>();

    private TestContext() {
    }

    public static TestContext getInstance() {
        if (instance.get() == null) {
            instance.set(new TestContext());
        }
        return instance.get();
    }

    public <T> T get(String name) {
        return (T) testContexts.get(name);
    }

    public <T> T set(String name, T object) {
        testContexts.put(name, object);
        return object;
    }

    public void reset() {
        testContexts.clear();
    }
}
