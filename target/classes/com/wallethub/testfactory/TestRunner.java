package com.wallethub.testfactory;

import org.testng.annotations.DataProvider;

import com.wallethub.driverInit.DriverInitialization;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = { "classpath:com.wallethub.stepDefinitions" }, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@automated")
public class TestRunner extends DriverInitialization {

	@Override
	@DataProvider()
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
