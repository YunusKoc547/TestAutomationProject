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

@VerbalMemory
Feature: Verbal Memory

Background:
Given user launched browser and navigated to url

Scenario: Start Verbal Memory Test
When user navigates to home page
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

Scenario: teardown
And tear down




