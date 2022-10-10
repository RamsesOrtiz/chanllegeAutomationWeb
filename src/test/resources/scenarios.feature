Feature: Automation Web Challenge on demoblaze.com

  @SignUpUser
  Scenario: Sign Up User
    Given a user visits the webpage
    When select Sign up option
    And fill in username and password fields
    Then the system response is successful

  @LoginUser
  Scenario: Login User
    Given a user sign up in the webpage
    When select Login option
    And write the username and password fields
    Then the system login successfully

  @LogoutUser
  Scenario: Logout User
    Given a user logged in the webpage
    When select Logout option
    Then the system logout successfully

  @AddLaptopToCart
  Scenario: Add Laptop to Cart
    Given a user visits the homepage
    When goes to Laptops Categories
    And select some laptop
    And select add to cart option
    Then the system confirm that the product was added

  @CheckCart
  Scenario: Check that Laptop was added to cart
    Given a user who added a Laptop to cart
    When goes to Cart option
    Then the product added is present in the cart