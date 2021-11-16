Feature: Post Status 
	Description: This feature will test given scenario as part of Assesment

@automated @facebook 
Scenario Outline: As a user, I want to post my status in facebook and verify it on the home screen 
	Given I am on the facebook login screen
	When I enter the "<username>" and "<password>" in the facebook input field
	Then I click on the login button  
	And  I am on the facebook homepage  
	When I click on what is on your mind input field
	Then I enter "<statusText>" as status
	And I click on the post button
	Then I verify the "<statusText>" post is displayed on the home screen
	Then I delete the post from home screen
	And I logout from the facebook website
	Examples:
		|username												|password	|statusText	|
		|kbumnvzgro_1618476638@tfbnw.net|QuitBuddy|Hello World|