Feature: Login

  Scenario: Login successfully
    Given I access the login page
    And I insert valid credentials
    When I click login button
    Then I check if user was logged in

  Scenario: Login with wrong credentials
    Given I access the login page
    And I insert invalid credentials
    When I click login button
    Then I expect invalid credential message

  Scenario: Login with no password
    Given I access the login page
    When I enter "aa@fast.com"/"" credentials
    And I click login button
    Then I expect "Please enter your password!" error message

  Scenario: Login with no email
    Given I access the login page
    When I enter ""/"aa.pass" credentials
    And I click login button
    Then I expect "Please enter your email!" error message

  Scenario: Login with no email and password
    Given I access the login page
    When I enter ""/"" credentials
    And I click login button
    Then I expect "Please enter your email and password!" error message

  Scenario Outline: Failed at login
    Given I access the login page
    When I enter "<email>"/"<pass>" credentials
    And I click login button
    Then I expect "<message>" error message
    Examples:
      | email       | pass     | message                     |
      | aa@fast.com |          | Please enter your password! |
      |             | onlypass | Please enter your email!    |
      | aa@fast.com | aa       | Invalid user or password!   |
      |             |          | Please enter your email!    |