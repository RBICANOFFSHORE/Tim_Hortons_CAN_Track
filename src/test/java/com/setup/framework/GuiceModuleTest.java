package com.setup.framework;

public class GuiceModuleTest extends com.google.inject.AbstractModule{
    @Override
    protected void configure() {
        bind(IDriver.class).toProvider(WebDriverProvider.class);
    }
}
