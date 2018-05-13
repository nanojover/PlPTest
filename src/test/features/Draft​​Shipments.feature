@Draft

Feature: As an Internet user
  I want to save a shipment as a draft

  @Draft-SaveShipments
  Scenario: Save shipments as a draft
    Given an internet user on Firefox browser
    And a registered user
    When performing a search with the following information:
      | countryOrigin       | cpOrigin       | countryDetination   | cpDestination  | weight | lengthSize | widthSize | heightSize |
      | España - Peninsular | 28001 - Madrid | España - Peninsular | 28002 - Madrid | 1      | 10         | 10        | 10         |
    #    Then it will select the first service of the list
    Then it will save the shipment as a draft
    Then it will appear in the shipment list
