#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>

@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
     Given I landed on Ecommerce Page
     When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed.

    Examples: 
      | name  									 | password |
      | vipin.dhiman21@gmail.com | P@ssword3 |
