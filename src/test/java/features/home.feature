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

#//div[@class='css-o34a3t e19owgy75']//a[text()='HUMAN BENCHMARK']
@home
Feature: Home Suite

	Background:
		Given user launched browser and navigated to url

Scenario: Navigate to Reaction Time module
Given user logged in with valid credentials
When user navigates to home page
Then user navigates to Reaction Time module

Scenario: teardown
Given tear down


  
