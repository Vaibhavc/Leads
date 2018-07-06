package com.practice.qa;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener extends Base implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("OnFinish");

		if (getDriver() != null) {
			getDriver().quit();
		}
	}

	public void onStart(ITestContext arg0) {
		System.out.println("Onstatrt");
		setDriver();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("On trst Start ....................");

	}

	public void onTestSuccess(ITestResult arg0) {

	}

}
