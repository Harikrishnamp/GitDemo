@tag
Feature: purchase the order from  websitee
  
  Background:
  Given I landed on the site
  
  @Regressiong
  Scenario Outline: positive test for submitting the ordero
    Given Logged in with email <name> and password <password>
    When I added product <productName> to cart 	
    And checkout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on confirmation page
    
    Examples:
	|       name    | password | productName |
	| Har@gmail.com | Hari@123 | ZARA COAT 3 |