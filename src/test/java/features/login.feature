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

@login
Feature: Login Suite

Background:
Given user launched browser and navigated to url
Given connected to database
  
Scenario: User Login with valid credentials
Given user logged in with valid credentials
Given user logged in with valid credentials

Scenario: user logged out successfully
And User logged out successfully

Scenario: teardown
And tear down

  
  
