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

@SequenceMemory
Feature: Sequence Memory

Background:
Given user launched browser and navigated to url
Given user logged in with valid credentials

Scenario: Complete Sequence Memory Test
When user navigates to home page
When user navigates to Sequence Memory module
And user starts Sequence Memory Test
Then user complete Sequence Memory Test

Scenario: teardown
And tear down




