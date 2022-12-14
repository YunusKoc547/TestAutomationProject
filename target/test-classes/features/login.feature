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
Feature: Navigate to Application and login
  
Background:
Given user launched browser and navigated to url

Scenario Outline: Navigate to "<moduleName>" module
Given user click All button
Then user click on "<moduleName>" link
Examples:
| moduleName   |
| Best Sellers |
| New Releases |

@db
Scenario: Login with valid credentials
Given user connected to database
Given user logged in with valid credentials

@db
Scenario: teardown
And tear down





