Feature: Add Review 
	Description: This feature will test given scenario as part of Assesment

@automated @wallethub
Scenario Outline: As a user, I want to add the review for an Insuarance company and view it on the profile screen 
	Given I am on the review screen
	When I naviage to sign in screen
	Then I enter the "<username>" and "<password>"
	And I click on the sign in button 
	When I click on reviews
	Then I hover on the fourth star for rating  
	And  I click on the fourth star  
	Then I select "<insuranceType>" from the dropdown
	And I write my review comments
	When I click on submit button
	Then I verify I am on the review confirmation screen
	And I click on the continue button
	When I go to the profile screen
	Then I verify added review is displayed on the screen
	Then I delete the added review
	
	Examples:
		|username									 |password|insuranceType	 |
		|sarputheenabbash@gmail.com|Test@123|Health Insurance|
		
		
		