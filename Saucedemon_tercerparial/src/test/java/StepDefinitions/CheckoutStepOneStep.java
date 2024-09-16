package StepDefinitions;

import Pages.CheckoutStepOnePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;

public class CheckoutStepOneStep {

    CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(DriverManager.getDriver().driver);

    @And("Set the name with {string}")
    public void setTheNameWith(String firstname) {
        checkoutStepOnePage.setFirstName(firstname);
    }


    @And("Set the lastname with {string}")
    public void setTheLastnameWith(String lastname) {
        checkoutStepOnePage.setLastname(lastname);
    }

    @And("Set the Postal Code with {string}")
    public void setThePostalCodeWith(String postalcode) {
        checkoutStepOnePage.setPostalcode(postalcode);
    }

    @And("Click on Continue Button")
    public void clickOnContinueButton() {
        checkoutStepOnePage.clickContinue();
    }

}
