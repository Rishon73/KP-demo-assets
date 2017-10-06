#Auto generated Octane revision tag
@TID148001REV0.3.0
Feature: Add product to shopping cart
	Scenario: When a user likes an item, they are able to "Add to Cart"
		Given User is viewing the product
		When "Add to Cart" is selected
		Then Product should then be seen in the shopping cart.
