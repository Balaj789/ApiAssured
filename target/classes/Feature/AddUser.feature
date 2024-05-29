Feature: Adding the users to the List.
Scenario Outline: Add users
Given user is in Reqres URL
When User enters the "<name>" and "<job>"
And User hit the users API
Then user added to the list
Examples:
|name|job|
|shankar|Sr.Engg|
|rao|Consultant|