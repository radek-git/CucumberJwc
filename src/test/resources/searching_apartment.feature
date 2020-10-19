Feature: Searching apartment feature
  Scenario Outline: User inputs data and apartment is found
    Given User opens page
    And User closes warning pop-up
    And User selects location <location>
    And User selects number of rooms <number_of_rooms>
    And User selects living space from <space_from> to <space_to>
    And User selects property type <property_type>
    When User selects Search button
    Then List of available apartments is displayed
    Examples:
      | location                        | number_of_rooms | space_from  | space_to    | property_type |
      | "Warszawa - Bliska Wola Tower"  | "2"             | "40"        | "60"        | "Apartament"  |
#      | "Warszawa - Bliska Wola Tower"  | "4"             | "60"        | "100"       | "Apartament"  |


