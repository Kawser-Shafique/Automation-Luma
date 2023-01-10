@SmokeTest
Feature: Login Function Test 
@TC_1233
Scenario: 
	As a Luma application user, must do successfully login with valid credential 

	Given Open a browser 
	And go to application URL 
	When Click sign in button 
	And put email 
	And put password 
	And click second sign in button 
	Then validate login was successful 
	
	
	
	
	
	
