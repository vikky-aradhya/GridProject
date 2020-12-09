
Feature: Login into an application

  @Login_user
  Scenario: Login
    Given Login page is loaded
    And user take the count of menu items
    And Reterview the menu items
    Then user compare the actual and expected screenshots

  @BrandingPage
  Scenario: Branding page validation
    Given Branding page loaded scuessfully
    And Extract the Header and pargraphs and write into excel
    And Enter the value for required fields

  @TestimonialsPage
  Scenario: Testimonials page validation
    Given Testimonials page loaded scuessfully
    And Extract the client name and testimonials and write to file
    
    
  @End_to_End
  Scenario: E2E
    Given Login page is loaded
    And user take the count of menu items
    And Reterview the menu items
    Then user compare the actual and expected screenshots
    Given Branding page loaded scuessfully
    And Extract the Header and pargraphs and write into excel
    And Enter the value for required fields
    Given Testimonials page loaded scuessfully
    And Extract the client name and testimonials and write to file