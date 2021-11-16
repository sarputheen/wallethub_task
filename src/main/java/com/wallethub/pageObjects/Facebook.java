package com.wallethub.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.wallethub.webUtilities.PropertyUtils;

public class Facebook extends BasePage {

	/**
	 * Page Objects and methods are associated based on the steps from the Feature
	 * File
	 */
	
	private static By userName = By.id("email");
	private static By password = By.id("pass");
	private static By loginButton = By.xpath("//button[contains(text(),'Log In')]");
	
	private static By homeScreenButton = By.xpath("//a[@aria-label='Home' and @aria-current='page']");
	private static By statusInputLabel = By.xpath("//span[contains(text(),'on your mind')]");
	private static By statusInputField = By.xpath("//div[@data-contents='true']/div/div");
	private static By statusPostButton = By.xpath("//div[@aria-label='Post']");
	private static By statusText = By.xpath("(//div[contains(text(),'Hello World')])[1]");
	private static By statusAction = By.xpath("//div[@aria-haspopup='menu' and @aria-label='Actions for this post']");
	private static By moveToTrashLink = By.xpath("//span[contains(text(),'Move to trash')]");
	private static By moveAction = By.xpath("(//span[contains(text(),'Move')])[2]");
	private static By accountsSettings = By.xpath("//div[@aria-label='Account']");
	private static By logoutButton = By.xpath("//span[contains(text(),'Log Out')]");
	private static By allowCookies = By.xpath("//button[@data-cookiebanner='accept_button']");
	
	

	public static void presenceOfLoginScreen() {
		checkAllowCookesPopup();
		List<WebElement> review = listOfElements(accountsSettings);
		if(review.size()>0) {		
			logoutFacebookWebSite();
			}
		ExtentCucumberAdapter.addTestStepLog("This case is running in " + getBrowserName() + " Browser");
		Assert.assertTrue(isElementDisplayed(userName), "There is some issue in Loading Login Page");
	}
	
	public static void setUsername(String username) {
		pause(3);
		sendKeysOn(userName, username);
	}
	
	public static void setPassword(String password1) {
		pause(3);
		sendKeysOn(password, password1);
	}
	
	public static void clickOnloginButton() {
		pause(2);
		clickOn(loginButton);
	}
	
	public static void presenceOfHomeScreen() {
		pause(5);
		checkAllowCookesPopup();
		Assert.assertTrue(isElementDisplayed(homeScreenButton), "There is some issue in Loading Home Page");
	}
	
	
	public static void clickOnStatusInputLabel() {
		pause(2);
		clickOnJS(statusInputLabel);
	}

	public static void setFacebookStatus(String status) {
		pause(2);
		sendKeysOn(statusInputField, status);
	}
	
	public static void clickOnPostButton() {
		pause(2);
		clickOn(statusPostButton);
	}
	
	public static void presenceOfPostedStatus(String status) {
		pause(3);
		refreshPage();
		pause(3);
		String text =getTextOn(statusText);
		Assert.assertTrue(text.equals(status), "There is some issue in Loading Login Page");
	}
	
	
	public static void deletePost() {
		pause(2);
		clickOnJS(statusAction);
		pause(2);
		clickOnJS(moveToTrashLink);
		pause(2);
		clickOnJS(moveAction);
		pause(2);
	}

	

	public static void checkAllowCookesPopup() {
		pause(2);
		List<WebElement> review = listOfElements(allowCookies);
		if(review.size()>0) {		
			clickOnJS(allowCookies);
			pause(2);
			}
	}
	
	public static void logoutFacebookWebSite() {
			pause(2);	
			clickOnJS(accountsSettings);
			pause(2);
			clickOnJS(logoutButton);
			pause(2);
			
	}

}