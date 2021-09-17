Feature: User Registration
  I want to check that user can register in our e-commerce website

  Scenario Outline: User Registration
    Given The User in home page
    When the user click on register link
    And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>" , "<cpassword>"
    And the registration page display successfully
    Then the user can logout


    Examples:
      | firstname | lastname | email          | password | cpassword |
      | marko     | jan      | 442211@yahoo.com | 123456   | 123456    |
      | hisham    | sief     | 1512@yahoo.com   | 123456   | 123456    |