
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.securian.calculator.CucumberSpringConfiguration;
import com.securian.calculator.PreRetirementCalculatorPageLocators;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CalculatorApplicationTests extends CucumberSpringConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorApplicationTests.class);

    private Playwright playwright;
    private Browser browser;
    private Page page;

    private final PreRetirementCalculatorPageLocators locators;

    public CalculatorApplicationTests(PreRetirementCalculatorPageLocators locators) {
        this.locators = locators;
    }

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browser.newContext(new com.microsoft.playwright.Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
        page = browser.newPage();
    }

    @After
    public void tearDown() {
        page.close();
        browser.close();
        playwright.close();
    }

    @Given("I am on the retirement calculator page")
    public void i_am_on_the_retirement_calculator_page() {
        try {
            page.navigate("https://www.securian.com/insights-tools/retirement-calculator.html");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }

    @When("I fill in the required fields")
    public void i_fill_in_the_required_fields() {
        try {
            page.fill(locators.getCurrentAge(), "40");
            page.fill(locators.getRetirementAge(), "68");
            page.fill(locators.getCurrentIncome(), "100000");
            page.fill(locators.getCurrentRetirementSavingBalance(), "500000");
            page.fill(locators.getCurrentlySavingForRetirementEachYear(), "10");
            page.fill(locators.getRateOfIncreaseInSavingsEachYear(), "5");
            logger.info("Required fields entered");
        } catch (Exception e) {
            logger.error("error in filling the required values {}", e.getMessage());
        }

    }

    @When("I fill in all the fields")
    public void i_fill_in_all_the_fields() {
        i_fill_in_the_required_fields(); // Reuse the required fields method
        try {
            page.fill(locators.getSpousesAnnualIncome(), "75000");
            page.locator(locators.getSocialSecuirtyIncome_yes()).click();
            page.locator(locators.getMaritalStatusMarriedRadioButton());
            page.fill(locators.getSocialSecurityOverride(), "4000");
            logger.info("All fields entered successfully");
        } catch (Exception e) {
            logger.error("error in filling the All values {}", e.getMessage());
        }

    }

    @When("I update the default calculator values")
    public void i_update_the_default_calculator_values() {
        try {
            page.getByText(locators.getEditInfo()).click();
            page.fill(locators.getSpousesAnnualIncome(), "80000");

            logger.info("fields updated successfully");
        } catch (Exception e) {
            logger.error("error in updating the default calculator values {}", e.getMessage());
        }
    }

    @When("I submit the form")
    public void i_submit_the_form() {
        try {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(locators.getCalculateButton())).click();
            logger.info("submit the form successfully");
        } catch (Exception e) {
            logger.error("error in submitting Form: {}", e.getMessage());
        }

    }

    @When("I toggle the Social Security benefits option")
    public void i_toggle_the_social_security_benefits_option() {
        try {
            page.locator(locators.getSocialSecuirtyIncome_yes()).click();
            logger.info("toggle the Social Security benefits successfully");
        } catch (Exception e) {
            logger.error("error in toggling the Social Security benefits option: {}", e.getMessage());
        }

    }

    @Then("additional Social Security fields should be displayed")
    public void additional_social_security_fields_should_be_displayed() {

        assertThat(page.locator(locators.getSocialSecurityOverride())).isVisible();

    }

    @Then("additional Social Security fields should be hidden")
    public void additional_social_security_fields_should_be_hidden() {

        assertThat(page.locator(locators.getSocialSecurityOverride())).isHidden();
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        assertThat(page.locator(locators.getResultConfirmation())).isVisible();
    }

    @When("I toggle the Social Security benefits option again")
    public void I_toggle_the_Social_Security_benefits_option_again() {
        try {
            page.locator(locators.getSocialSecuirtyIncome_no()).click();
            logger.info("Social Security benefits option toggled again successfully");
        } catch (Exception e) {
            logger.error("error in toggling the Social Security benefits option: {}", e.getMessage());
        }

    }

}
