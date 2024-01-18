Feature: Add Product In Cart

  @addProduct
  Scenario: Adding product in cart
    Given the user is on the homepage
    When the user clicks the Product button
    And hovers over the first product and clicks Add to Cart
    And clicks the Continue Shopping button
    And hovers over the second product and clicks Add to Cart
    And clicks the View Cart button
    Then verify that products are added to the cart
    And verify their prices, quantity, and total price
    
    


