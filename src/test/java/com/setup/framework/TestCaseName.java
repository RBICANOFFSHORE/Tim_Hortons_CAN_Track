package com.setup.framework;

import org.openqa.selenium.WebDriver;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestCaseName {
    String name() default "No_Name_Provided";
}
