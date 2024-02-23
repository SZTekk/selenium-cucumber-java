Feature: As a User I want to test Add to cart product and checkout functionality
				 of the application
				 
	
 Background: User Logged In to Application
    Given I Log into the Demo application		 
				 

  @AddToCartAndCheckout
  Scenario Outline: Verify user add product into cart and complete checkout scenario
    When I Click on shop menu
    And  I Add book "<BookName1>" into cart
    And  I Add book "<BookName2>" into cart
    And  I Click on cart icon and move to basket page
    And  I Store the total amount of products
    And  I Click on proceed to checkout button
    And  I Click on place order button
    Then I Verify order confirmation message
    Then I Verify the total amount is correct

    Examples: 
      | BookName1  					      | BookName2                    | OrderConfirmationMessage     |
      | HTML5 Forms               | Functional Programming in JS | Your order has been received |
     