#Author: your.email@your.domain.com

Feature: Google API
  I want to use this template for my feature file

  Scenario: Add google Location
    Given I want to add payload
    When User submit "POST" api
    Then User validate the status code is 200
   