Feature: Checking Google search functionality. I want to check if it is possible to find a proper resources

  Scenario Outline: Finding information about Cucumber
    Given I am on the Google search page
    When I search for <keyword>
    Then the page title should start with <result>

    Examples: 
      | keyword      | result       |
      | Cucumber     | cucumber     |
      | how2automate | how2automate |