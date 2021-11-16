package com.wallethub.stepDefinitions;

import com.wallethub.driverInit.DriverManager;
import com.wallethub.pageObjects.Facebook;
import com.wallethub.pageObjects.Wallethub;
import com.wallethub.webUtilities.PropertyUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assesment2WellethubStepDef {
	
	
	
	@Given("I am on the review screen")
	public void i_am_on_the_review_screen() {
		DriverManager.getDriver().get(PropertyUtils.configProperty("wallethub_url"));
		DriverManager.getDriver().manage().window().maximize();
		Wallethub.presenceOfReviewScreen();
	}
	
	@When("I naviage to sign in screen")
	public void I_naviage_to_sign_in_screen() {
		
		Wallethub.navToSignInScreen();
	}
	
	
	@Then("I enter the {string} and {string}")
	public void i_enter_the_and_username_password(String string1, String string2) {
		Wallethub.setUsername(string1);
		Wallethub.setPassword(string2);
	}

	@And("I click on the sign in button")
	public void i_click_on_the_signin_button() {
		Wallethub.clickOnloginButton();
	}
	
	
	@When("I click on reviews")
	public void i_click_on_reviews() {
	    Wallethub.clickOnReviewLink();
	}

	@Then("I hover on the fourth star for rating")
	public void i_hover_the_star() {
		Wallethub.hoverOnTheStar();
	}

	@Then("I click on the fourth star")
	public void i_click_on_the_fourth_star() {
		Wallethub.clickOnTheStar();
	}

	@Then("I select {string} from the dropdown")
	public void i_select_from_the_dropdown(String value) {
		Wallethub.selectDropDown(value);
	}

	@Then("I write my review comments")
	public void i_write_my_review_comments() {
		Wallethub.writeReviewComments();
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() {
		Wallethub.clickOnSubmitButton();
	}

	@Then("I verify I am on the review confirmation screen")
	public void i_verify_i_am_on_the_review_confirmation_screen() {
		Wallethub.presenceOfReviewConfirmationScreen();
	}

	@Then("I click on the continue button")
	public void i_click_on_the_continue_button() {
		Wallethub.clickOnContinueButton();
	}

	@When("I go to the profile screen")
	public void i_go_to_the_profile_screen() {
		Wallethub.navigateToProfileScreen();
	}

	@Then("I verify added review is displayed on the screen")
	public void i_verify_added_review_is_displayed_on_the_screen() {
		Wallethub.verifyReviewPresense();
	}

	

	@Then("I delete the added review")
	public void i_delete_the_added_review() {
		Wallethub.deleteAddedReview();
	}
}