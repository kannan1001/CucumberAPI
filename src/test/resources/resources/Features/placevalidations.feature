Feature: validating place Api

@addplace @Regression
Scenario Outline: verify if place is added using Addplace Api
Given add place payload with "<name>" "<language>" "<address>"
When user calls "AddplaceAPI" with "post" http request
Then Api call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id created maps to "<name>" using "getplaceAPI"

Examples:
	|name|language|address|
	|BlueLane House|Parsi|142, WinterDame cohane |
#	|Purple lane House|German|132, GeorgeDame cohelen|

@deleteplace @Regression
Scenario: Verify if deleteplaceAPI is working

Given DeletePlace payload
When user calls "deleteplaceAPI" with "post" http request
Then Api call is success with status code 200
And "status" in response body is "OK"

