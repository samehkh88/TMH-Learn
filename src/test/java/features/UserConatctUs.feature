Feature: User Contact Us form
  I want to check that user can send mail to the system

  Scenario Outline: User can Contact the system
    Given The User in home page
    When the scroll down to the footer
    And  the user click on contact form us form
    And the user enter the data "<name>" , "<email>" , "<message>"
    Then the success message displayed successfully "<SuccessMessage>"


    Examples:
      | name  | email          | message                 | SuccessMessage                                              |
      | marko | 4421@yahoo.com | test message from sameh | Your enquiry has been successfully sent to the store owner. |


