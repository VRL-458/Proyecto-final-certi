package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CartSteps {

    CartPage cartPage = new CartPage(DriverManager.getDriver().driver);

    @Then("The cart should no be empty")
    public void CheckEmptyCart() { cartPage.checkEmptyCart();}

    @Then("Check the products name")
    public void checkTheProductsName() {
        cartPage.checkProductinTheCart();

    }

    @And("I click on checkout button")
    public void ClickOnCheckoutButton() {
        cartPage.ClickonCheckoutButton();
    }
}
