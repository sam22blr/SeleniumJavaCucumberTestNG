Feature: Login feature

  Scenario Outline: Successful login
    Given I am on the login page
    When I enter <username> and <password>
    And I click on login button
    Then I see the <message>

    Examples: 
      | username        | password     | message                      |
      | abc321@abcd.com | 12345678!aA  | Login Successfully           |
      | abc321@abc.com  | 12345678!aAa | Incorrect email or password. |
