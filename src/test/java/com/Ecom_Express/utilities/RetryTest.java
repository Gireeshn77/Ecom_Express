package com.Ecom_Express.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {

    int retryCount = 0; 
    int maxRetryCount = 2; // run failed test maximum 2 times

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // re-run the failed test
        }
        return false; // stop retrying
    }
}
