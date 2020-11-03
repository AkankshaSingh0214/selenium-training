Feature: Login Functionality


  @Smoke
  Scenario: Test Case to verify Login functionality with valid username and password
    Given Browser should be with login page for testing admin user
    When User should logs in using Username and Password as admin
    And Click on Login button for testing admin user
    Then Home Page should get open and verify page title for admin
    And Close browser

    
    @Sanity
    Scenario: Test Case to verify Login functionality with valid username and password
    Given Browser should be with login page for testing tuser user
    When User should logs in using Username as "tuser" and Password "tuser"
    And Click on Login button for testing tuser user
    Then Home Page should get open and verify page title for tuser
    And Close browser after login
   