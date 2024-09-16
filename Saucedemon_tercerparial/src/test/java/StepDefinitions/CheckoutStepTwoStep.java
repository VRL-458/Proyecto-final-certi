package StepDefinitions;

import Pages.CheckOutStepTwoPage;
import Pages.CheckoutStepOnePage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CheckoutStepTwoStep {

    CheckOutStepTwoPage checkoutStepTwoPage = new CheckOutStepTwoPage(DriverManager.getDriver().driver);

    @And("Check the total price calculated and the total products price")
    public void checkTheTotalPriceCalculatedAndTheTotalProductsPrice() {
        checkoutStepTwoPage.checktotalPrice();
    }
}