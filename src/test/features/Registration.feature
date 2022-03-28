Feature: This feature is to test the registration functionality.

  Scenario Outline: Verify user is able to register.
    Given User is on landing page
    When User enter email as "<email>"
    And User enter username as "<username>"
    And User enter password as "<password>"
    And User click on Sign Up
    Then Verify if data is correct then user should be able to register else error "<errorMessage>" should be displayed

    Examples:
      | email                        | username                                                                 | password   | errorMessage                           |
      #positive case - change email and username everytime
      | test-automation100@gmail.com | test_user                                                                | Test@12345 |                                        |
      #long username - more than 100 characters
      | a@a.com                      | test_user123141414141241241414121241241412414124124124141241412414       | Test@12345 |                                        |
      #user already busy - use already existing email
      | test-automation100@gmail.com | TestUser1231414141412412414141212412414124141241241241412414124141231233 | Test@12345 | Please check your entry and try again. |
      #e-mail is missing
      |                              | TestUser1231414141412412414141212412414124141241241241412414124141231233 | Test@12345 | Please check your entry and try again. |
