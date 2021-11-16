package com.wallethub.stepDefinitions;

import com.wallethub.driverInit.DriverManager;
import com.wallethub.pageObjects.Facebook;
import com.wallethub.webUtilities.PropertyUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assesment1FacebookStepDef {
	
	
	
	@Given("I am on the facebook login screen")
	public void i_am_on_the_facebook_login_screen() {
		DriverManager.getDriver().get(PropertyUtils.configProperty("facebook_url"));
		DriverManager.getDriver().manage().window().maximize();
		Facebook.presenceOfLoginScreen();
	}

	@When("I enter the {string} and {string} in the facebook input field")
	public void i_enter_the_and(String string1, String string2) {
		Facebook.setUsername(string1);
		Facebook.setPassword(string2);
	}

	@Then("I click on the login button")
	public void i_click_on_the_login_button() {
	    Facebook.clickOnloginButton();
	}

	@Then("I am on the facebook homepage")
	public void i_am_on_the_facebook_homepage() {
	    Facebook.presenceOfHomeScreen();
	}

	@When("I click on what is on your mind input field")
	public void i_click_on_what_is_on_your_mind_input_field() {
	   Facebook.clickOnStatusInputLabel();
	}

	@Then("I enter {string} as status")
	public void i_enter_as_status(String string) {
	    Facebook.setFacebookStatus(string);
	}

	@Then("I click on the post button")
	public void i_click_on_the_post_button() {
	    Facebook.clickOnPostButton();
	}

	@Then("I verify the {string} post is displayed on the home screen")
	public void i_verify_the_post_is_displayed_on_the_home_screen(String string) {
	    Facebook.presenceOfPostedStatus(string);
	}
	
	@Then("I delete the post from home screen")
	public void i_delete_the_post_from_home_screen() {
		Facebook.deletePost();
	}

	@Then("I logout from the facebook website")
	public void i_logout_from_the_facebook_website() {
		Facebook.logoutFacebookWebSite();
	}
	
	
	
}