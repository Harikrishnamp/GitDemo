@tag
Feature: Error validatione
  
  Background:
  Given I landed on the site
  @Error
  Scenario Outline: Error validation checkingo
    Given I landed on the site
    When Logged in with email <name> and password <password>
    Then "Incorrect email or password." message is displayed
    
    Examples:
	|       name     | password | 
	| Hari@gmail.com | Hari@12  | 