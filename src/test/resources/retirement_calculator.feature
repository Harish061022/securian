@retirement_calc
Feature: Retirement Calculator
  

@retirement_calc1
  Scenario: Submit form with all required fields filled in
    Given I am on the retirement calculator page
    When I fill in the required fields
    And I submit the form
    Then I should see a confirmation message

  @retirement_calc2
  Scenario: Toggle Social Security benefits
    Given I am on the retirement calculator page
    When I toggle the Social Security benefits option
    Then additional Social Security fields should be displayed
    When I toggle the Social Security benefits option again
    Then additional Social Security fields should be hidden

 @retirement_calc3
  Scenario: Submit form with all fields filled in
    Given I am on the retirement calculator page
    When I fill in all the fields
    And I submit the form
    Then I should see a confirmation message

@retirement_calc4
  Scenario: Update default calculator values
    Given I am on the retirement calculator page
    When I fill in all the fields
    And I submit the form
    When I update the default calculator values
    And I submit the form
    Then I should see a confirmation message
