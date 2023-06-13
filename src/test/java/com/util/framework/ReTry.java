package com.util.framework;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTry implements IRetryAnalyzer {

    private int counter = 0;
    int retryLimit = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter < retryLimit)
        {
            counter++;
            return true;
        }
        return false;
    }
}
