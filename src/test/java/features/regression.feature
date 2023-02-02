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
When user navigates to "Reaction Time" module
When user starts Reaction Time Test
Then user clicks when screen turns green

Scenario: Start Reaction Time Test and Validate Clicked Too Soon message
When user navigates to "Reaction Time" module
When user starts Reaction Time Test
Then user clicks while screen is still red

Scenario: Complete Aim Trainer test
When user navigates to "Aim Trainer" module
And user starts Aim Trainer test
Then user completes Aim Trainer test

Scenario: Complete Sequence Memory Test
When user navigates to "Sequence Memory" module
And user starts Sequence Memory Test
Then user complete Sequence Memory Test

Scenario: Fail Sequence Memory Test and validate
When user navigates to "Sequence Memory" module
And user starts Sequence Memory Test
Then user fail Sequence Memory Test

Scenario: Fail Sequence Memory Test and click Try again button and validate
When user navigates to "Sequence Memory" module
And user starts Sequence Memory Test
Then user fail Sequence Memory Test
Then user click try again button

Scenario: Complete Number Memory Test
When user navigates to "Number Memory" module
And user starts Number Memory Test
Then user completes Number Memory Test

Scenario: Fail Number Memory Test and validate
When user navigates to "Number Memory" module
And user starts Number Memory Test
Then user fails Number Memory Test

Scenario: Start Verbal Memory Test
When user navigates to "Verbal Memory" module
And user starts Verbal Memory Test

Scenario: Complete Verbal Memory Test
When user navigates to "Verbal Memory" module
And user starts Verbal Memory Test
Then user complete Verbal Memory Test

Scenario: Start then fail Verbal Memory Test
When user navigates to "Verbal Memory" module
And user starts Verbal Memory Test
Then user fail Verbal Memory Test

Scenario: Complete Chimp Test
When user navigates to "Chimp Test" module
And user starts Chimp Test
And user completes Chimp Test

Scenario: user logged out successfully
And User logged out successfully

Scenario: teardown
Given tear down




