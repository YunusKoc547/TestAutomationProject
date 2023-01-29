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

@NumberMemory
Feature: Number Memory

Background:
Given user launched browser and navigated to url

Scenario: Complete Number Memory Test
Given user logged in with valid credentials
When user navigates to home page
When user navigates to "Number Memory" module
And user starts Number Memory Test
Then user completes Number Memory Test

Scenario: Fail Number Memory Test and validate
When user navigates to "Number Memory" module
And user starts Number Memory Test
Then user fails Number Memory Test

Scenario: teardown
And tear down




