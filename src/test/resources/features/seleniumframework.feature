Feature: Access seleniumframework.com website
  Use selenium java with cucumber-jvm and navigate to website

  Scenario: Print title, url
    When I open seleniumframework website
    Then I validate title and URL
