package com.saimen;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public static boolean hasFailed = false;

    @Override
    public void onTestFailure(ITestResult result) {
        hasFailed = true;
    }
}