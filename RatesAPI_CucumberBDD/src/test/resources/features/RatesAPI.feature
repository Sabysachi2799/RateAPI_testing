Feature: Test the Rates API cases


	@latestDataCheck @rateAPI
  Scenario: Check rateAPI should return latest currency rates
    Given Rates API should be up and Running
    When I call the Rates API 
    Then I verify API response status as "200" within "30" second SLA
    And I verify "INR" should be available in the response
    
    
    @latestDataCheck @latestDataCheckWithSymbol @rateAPI
  Scenario Outline: Check rateAPI should return latest currency rate of given symbols
    Given Rates API should be up and Running
    When I call the Rates API with "<Symbols>" symbols
    Then I verify API response status as "200" within "30" second SLA
    And I verify latest "<Check_Currency>" rate in the response
    Examples:
    |Symbols  |  Check_Currency|
    |USD,GBP   |   USD          |
    
    
    @latestDataCheck @latestDataCheckWithBase @rateAPI
  Scenario Outline: Check rateAPI should return latest currencies based on given currency
    Given Rates API should be up and Running
    When I call the Rates API with "<Base>" Base
    Then I verify API response status as "200" within "30" second SLA
    And I verify latest "<Check_Currency>" rate in the response
    Examples:
    |Base  |  Check_Currency|
    |USD   |   INR          |
    
    @latestDataCheck @latestDataCheckWithBaseAndSymbol @rateAPI
  Scenario Outline: Check rateAPI should return latest currencies of given symbols based on given currency
    Given Rates API should be up and Running
    When I call the Rates API with "<Base>" and "<Symbols>"
    Then I verify API response status as "200" within "30" second SLA
    And I verify latest "<Check_Currency>" rate in the response
    Examples:
    |Base  |  Check_Currency|  Symbols |
    |USD   |   GBP          |  GBP     |
    
    @rateAPIforDate @rateAPI
    Scenario Outline: Check rateAPI should return currency rates of given date
    Given Rates API should be up and Running
    When I call the Rates API for particular "<Date>"
    Then I verify API response status as "200" within "30" second SLA
    And I verify latest "<Check_Currency>" rate in the response
    Examples:
    |Date      |  Check_Currency|
    |2010-01-12|  INR      		  |
    
    @rateAPIforDateSymbol @rateAPI
    Scenario Outline: Check rateAPI should return given currency rates of given date
    Given Rates API should be up and Running
    When I call the Rates API for particular "<Date>" and "<Symbols>"
    Then I verify API response status as "200" within "30" second SLA
    And I verify latest "<Check_Currency>" rate in the response
    Examples:
    |Date      |  Check_Currency|  Symbols  |
    |2010-01-12|  USD      		  |  USD,GBP  |
    
    
    @rateAPIforDateAndBase @rateAPI
    Scenario Outline: Check rateAPI should return currency rates of given date of given base currency
    Given Rates API should be up and Running
    When I call the Rates API for particular "<Date>" with "<base>"
    Then I verify API response status as "200" within "30" second SLA
    And I verify latest "<Check_Currency>" rate in the response
    Examples:
    |Date      |  Check_Currency|  base  |
    |2010-01-12|  INR      		  |  USD  |
    
    @rateAPIforDateAndBase @rateAPI
    Scenario Outline: Check rateAPI should return rates of given currencies on given date with given base currency
    Given Rates API should be up and Running
    When I call the Rates API for particular "<Date>" with "<base>" and "<symbol>" given
    Then I verify API response status as "200" within "30" second SLA
    And I verify latest "<Check_Currency>" rate in the response
    Examples:
    |Date      |  Check_Currency|  base  |  symbol   |
    |2010-01-12|  GBP      		  |  USD   |   GBP     |
    
    
    @NegativeTesting @WrongURL @rateAPI
  Scenario Outline: Check rateAPI should return error message if correct URL is not used to call
    Given Rates API should be up and Running
    When I call the Rates API with "<URL>" 
    Then I verify API response status as "200" within "30" second SLA
    And I verify latest "<Check_Currency>" rate in the response
    Examples:
    |URL  													|  Check_Currency|
    |https://api.ratesapi.io/api/   |   USD          |