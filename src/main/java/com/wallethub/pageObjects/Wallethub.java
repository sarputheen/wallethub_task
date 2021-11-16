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

public class Wallethub extends BasePage {

	/**
	 * Page Objects and methods are associated based on the steps from the Feature
	 * File
	 */
	private static By loginButton = By.xpath("//span[contains(text(),'Login')]");
	private static By userName = By.id("email");
	private static By password = By.id("password");
	
	private static By reviewLink = By.xpath("//span[@class='nav-txt' and contains(text(),'Reviews')]");
	private static By ratingIcon = By.xpath("(//review-star[@class='rvs-svg']//*[name()='svg'])[4]");
	private static By ratingSummary = By.xpath("//div[@class='pr-rating-top']");
	private static By dropDown = By.xpath("//div[@class='dropdown second']");
	private static By dropDownVal = By.xpath("//li[contains(text(),'Health Insurance')]");
	private static By reviewCommentField = By.xpath("//div[@class='android']/textarea");
	private static String reviewComments = "The most common types of cancer in men are lung cancer,"
			+ " prostate cancer, colorectal cancer, and stomach cancer."
			+ " In females, the most common types are breast cancer, colorectal cancer, lung cancer, "
			+ "and cervical cancer. If skin cancer other than melanoma was included in the total "
			+ "number of new cancer cases each year, it would account for approximately 40% of cases";
	private static By submitButton = By.xpath("//div[contains(text(),'Submit')]");
	private static By reviewConfirmation = By.xpath("//h4[contains(text(),'Your review has been posted.')]");
	private static By continueButton = By.xpath("//div[@class='btn rvc-continue-btn']");
	private static By userNameText = By.xpath("//div[@class='brgm-button brgm-user brgm-list-box']/span");
	private static By profileLink = By.xpath("//a[contains(text(),'Profile')]");
	private static By logOutLink = By.xpath("//span[contains(text(),'Logout')]");
	private static By reviewList = By.xpath("//div[@class='pr-rec-container']/div ");
	private static By reviewNavLink = By.xpath("(//a[contains(text(),'Test Insurance Company')])[1] ");
	private static By reviewEditButton = By.xpath("//button[contains(text(),'edit')] ");
	private static By reviewCommentsInputField = By.xpath("//textarea[@name='reviewcomment']");
	private static By reviewSubmitButton = By.xpath("//span[@class='bt-text']");
	

	public static void presenceOfReviewScreen() {
		ExtentCucumberAdapter.addTestStepLog("This case is running in " + getBrowserName() + " Browser");
		pause(5);
		Assert.assertTrue(isElementDisplayed(ratingSummary), "There is some issue in Loading Rewview Page");
		List<WebElement> element = listOfElements(userNameText);
		if(element.size()>0) {
			 mouseHover(userNameText);
			clickOnByScrollIntoView(logOutLink);
		}
	}
	
	public static void navToSignInScreen() {
		pause(2);
		clickOn(loginButton);
	}
	
	public static void setUsername(String username) {
		pause(2);
		sendKeysOn(userName, username);
	}
	
	public static void setPassword(String password1) {
		pause(2);
		sendKeysOn(password, password1);
	}
	
	public static void clickOnloginButton() {
		pause(2);
		clickOn(loginButton);
	}
	
	public static void clickOnReviewLink() {
		pause(2);
		clickOn(reviewLink);
	}
	
	public static void hoverOnTheStar() {
		pause(3);
		mouseHover(ratingIcon);
		pause(3);
	}

	public static void clickOnTheStar() {
		pause(2);
		clickOn(ratingIcon);
	}

	public static void selectDropDown(String value) {
		pause(2);
		clickOn(dropDown);
		clickOn(dropDownVal);
	}

	public static void writeReviewComments() {
		pause(2);
		sendKeysOn(reviewCommentField, reviewComments);
	}
	
	public static void clickOnSubmitButton() {
		pause(2);
		clickOn(submitButton);
	}
	
	public static void presenceOfReviewConfirmationScreen() {
		pause(3);
		Assert.assertTrue(isElementDisplayed(reviewConfirmation), "There is some issue in Loading Confirmation Page");
	}
	
	public static void clickOnContinueButton() {
		pause(2);
		clickOn(continueButton);
	}
	public static void navigateToProfileScreen() {
		pause(2);
		mouseHover(userNameText);
		clickOnByScrollIntoView(profileLink);
	}
	
	public static void verifyReviewPresense() {
		pause(3);
		List<WebElement> review = listOfElements(reviewList);
		Assert.assertTrue(review.size()>0, "No Reviews found");
	}
	
	
	public static void deleteAddedReview() {
		List<WebElement> review = listOfElements(reviewNavLink);
		if(review.size()>0) {	
			clickOn(reviewNavLink);
			pause(2);
			clickOn(reviewEditButton);
			pause(2);
			sendActionKeysOn(reviewCommentsInputField,"a");
			pause(3);
			clickOn(reviewSubmitButton);
			pause(5);
			refreshPage();
			pause(5);
				
		}		
		
	}
	
	

}