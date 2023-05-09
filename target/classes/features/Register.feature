Feature: Registeration functionality

Background: User navigates to Register Account page

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the details into below  fields
|firstName |Arun                      |
|lastName  |Mootori                   |
|telephone |1234567890                |
|password  |12345                     |
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates an account  with all fields
Given User navigates to Register Account page
When User enters the details into below  fields
|firstName |Arun                      |
|lastName  |Mootori                   |
|telephone |1234567890                |
|password  |12345                     |
And User selects Yes for Newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully

	    

Scenario: User created a duplicate account
Given User navigates to Register Account page
When User enters the details into below  fields with duplicate email
|firstName |Arun                      |
|lastName  |Mootori                   |
|email     |amotooricap9@gmail.com|
|telephone |1234567890                |
|password  |12345                     |
And User selects Yes for Newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get a proper warning about duplicate email.

Scenario: User creates a account without filling any details
Given User navigates to Register Account page
When User dont enter any details into fields
And User clicks on continue button
Then User should get proper warning messages for every mandatory field.




