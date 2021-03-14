@MapsynqTCs
Feature: Mapsynq application Demo Test Cases

  Background: Launch MapSynq application
    Given User on the home page 'mapSYNQ - Live Traffic Information Platform'

  @invalidLoginTest
  Scenario Outline: Login the application with invalid credential and validate the error message
    When User login with <username> and <password>
    Then User validate the login error message as <errorMessage>

    Examples:
      | username   | password   | errorMessage                        |
      | 'subhrayu' | 'subhrayu' | 'Invalid user/password combination' |

  @galactioPageNavigation
  Scenario Outline: Navigate to the Galactio Page
    When User click on Galactio button
    Then User validate the Galactio page <pageTitle>
    Examples:
      | pageTitle  |
      | 'Galactio' |