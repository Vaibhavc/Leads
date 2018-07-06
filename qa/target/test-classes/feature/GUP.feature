@GUPLeads
Feature: Get Update Lead Testing
  I want to test Get Update leads used in Project

  Background: 
    Given user is on vehicle Homepage

  @Email
  Scenario Outline: verify Get updates form with email from HomePage
    When user clicks on Get updates Link
    Then user verifies Golf form
    And user enters details firstname as "<firstName>" lastname as "<lastName>" and zip as "<zip>"
    And user enter email as "<email>"
    And user click on submit button
    And user login to handraiser db on new tab
    And user searches for the Lead
    Then user verifies "<lastName>", "<zip>", szBrchr as "NoBlank", szQA as "0799A",szLanguage as "en"
    Then user verifies  "<email>"
    Then user close the tab

    Examples: 
      | firstName | lastName | zip   | email         |
      | Ftest     | LTest    | 48127 | test@test.com |

  @PostalMail
  Scenario Outline: verify Get updates form with mail from HomePage
    When user clicks on Get updates Link
    Then user verifies Golf form
    Then user Checks postal checkbox
    Then user Unchecks email checkbox
    And user enters details firstname as "<firstName>" lastname as "<lastName>" and zip as "<zip>"
    And user enters details street as "<street>", city as "<city>"
    And user click on submit button
    And user login to handraiser db on new tab
    And user searches for the Lead
    Then user verifies "<lastName>", "<zip>", szBrchr as "", szQA as "0848312720",szLanguage as "en"
    Then user verifies "<street>" and "<city>"
    Then user close the tab

    Examples: 
      | firstName | lastName | zip   | street      | city     |
      | Ftest     | LTest    | 48127 | TestAddress | TestCity |

  @Email&PostalMail
  Scenario Outline: verify Get updates form with mail and email from HomePage
    When user clicks on Get updates Link
    Then user verifies Golf form
    Then user Checks postal checkbox
    And user enters details firstname as "<firstName>" lastname as "<lastName>" and zip as "<zip>"
    And user enters details street as "<street>", city as "<city>"
    And user enter email as "<email>"
    And user click on submit button
    And user login to handraiser db on new tab
    And user searches for the Lead
    Then user verifies "<lastName>", "<zip>", szBrchr as "", szQA as "0848312720|0799A",szLanguage as "en"
    Then user verifies "<street>" and "<city>"
    Then user verifies  "<email>"
    Then user close the tab

    Examples: 
      | firstName | lastName | zip   | street      | city     | email         |
      | Ftest     | LTest    | 48127 | TestAddress | TestCity | test@test.com |
