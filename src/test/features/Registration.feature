Feature: This feature is to test the registration functionality.

  Scenario Outline: Verify user is able to register.
    Given User is on landing page
    When User enter email as "<email>"
    And User enter username as "<username>"
    And User enter password as "<password>"
    And User click on Sign Up
    Then Verify if data is correct then user should be able to register

    Examples:
      | email                             | username                          | password   |
      #positive case - change email and username everytime
      | test-automation19041253@gmail.com | test-automation19041253@gmail.com | Test@12345 |

  Scenario Outline: Verify user is not able to register with username with more than 100 characters.
    Given User is on landing page
    When User enter email as "<email>"
    And User enter username as "<username>"
    And User enter password as "<password>"
    And User click on Sign Up
    Then Verify error "<errorMessage>" for user name greater than 100 characters is displayed

    Examples:
      | email                        | username                                                                                                        | password   | errorMessage                                |
      #long username - more than 100 characters - change email and username everytime
      | test-automation100@gmail.com | test_user123141414141241241414121241241412414124124124141352523525235235235235235235235235235235235235219041248 | Test@12345 | Enter a value less than 100 characters long |

  Scenario Outline: Verify error message is displayed for already existing username.
    Given User is on landing page
    When User enter email as "<email>"
    And User enter username as "<username>"
    And User enter password as "<password>"
    And User click on Sign Up
    Then Verify error "<errorMessage>" for already existing username is displayed

    Examples:
      | email                        | username  | password   | errorMessage                                                                       |
      #user already busy - username already existing
      | test-automation100@gmail.com | test_user | Test@12345 | Another user with this username already exists. Maybe it's your evil twin. Spooky. |


  Scenario Outline: Verify error message is displayed for missing email.
    Given User is on landing page
    When User enter email as "<email>"
    And User enter username as "<username>"
    And User enter password as "<password>"
    And User click on Sign Up
    Then Verify error "<errorMessage>" for missing email is displayed

    Examples:
      | email | username | password   | errorMessage         |
      #e-mail is missing
      |       | TestUser | Test@12345 | Please enter a value |
