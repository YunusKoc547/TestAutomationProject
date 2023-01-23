#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


@Regression
Feature: Regression Suite
  
Background: 
Given user launched browser and navigated to url


Scenario: User Login with valid credentials
Given user logged in with valid credentials

Scenario: Complete Reaction Time Test
When user navigates to Reaction Time module
When user starts Reaction Time Test
Then user clicks when screen turns green

Scenario: Validate Clicked Too Soon message
When user navigates to Reaction Time module
When user starts Reaction Time Test
Then user clicks while screen is still red

Scenario: Complete Aim Trainer test
When user navigates to Aim Trainer module
And user starts Aim Trainer test
Then user completes Aim Trainer test

Scenario: user logged out successfully
And User logged out successfully

Scenario: teardown
Given tear down





