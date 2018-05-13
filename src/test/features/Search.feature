@Search
Feature: As an registered user
  I want to search a service
  so that I can select the service

  Background:
    Given an internet user on Firefox browser

#  Scenario: Complete onboarding process
#    Given a registered user
#    When accessing for the first time
#    Then it will complete the onboarding process

  @Search-SelectFirsService
  Scenario: Select first service an a search result
    Given going to pro packlink login page
    And a registered user
    And shipments screen is loaded
    And proceed to create a new shipment
    And shipments create infor is loaded
    When performing a search with the following information:
      | countryOrigin       | cpOrigin       | countryDetination   | cpDestination  | weight | lengthSize | widthSize | heightSize |
      | España - Peninsular | 28001 - Madrid | España - Peninsular | 28002 - Madrid | 1      | 10         | 10        | 10         |
#    Then it will select the first service of the list