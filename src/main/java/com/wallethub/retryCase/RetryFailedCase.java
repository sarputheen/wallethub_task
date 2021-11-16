package com.wallethub.retryCase;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedCase implements IRetryAnalyzer {

	/**
	 * On Failure, the failed cases will be re ran twice and gives the actual
	 * failures.
	 */
	private int retrycount = 0;
	private static final int maxcount = 2;

	public boolean retry(ITestResult result) {
		if (retrycount < maxcount) {
			retrycount++;
			return true;
		}
		return false;
	}
}
