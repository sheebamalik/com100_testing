Feature: com100 Login Page

Scenario: Verify user is able to login to the portal
Given User is in login page
When User enters Username 
And User enters Password
And User clicks on login button
Then User is able to login to his account
