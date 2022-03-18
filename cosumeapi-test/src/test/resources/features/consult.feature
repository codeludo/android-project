Feature: consult geoNames
  As a geoNames user
  I want to consult coordinates
  to verify country and other data

  Background:
    Given that I open the consumeAPI



    Scenario Outline: test different consults
      When I send the data
        | latitude  | <latitude>  |
        | longitude | <longitude> |
      Then I should see the following message
        | message      | <message>      |
        | errorMessage | <errorMessage> |
      Examples:

        | latitude | longitude | message                                   | errorMessage |
        | -10      | 20        | Angola                                    | False        |
        | ?        | @         | error parsing parameter                   | True         |
        |          | 20        | missing parameter                         | True         |
        | -10      |           | missing parameter                         | True         |
        |          |           | missing parameter                         | True         |
        | 90       | 9         | no timezone information found for lat/lng | True         |
        | 100000   | 100000    | invalid lat/lng                           | True         |



