package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStep {

    HomePage homePage = new HomePage(DriverManager.getDriver().driver);



    @And("select the slide bar")
    public void selectTheSlideBar() {
        homePage.clicksetSlideBar();
    }


    @And("reset the state app")
    public void resetTheStateApp() {
        homePage.optionResetSlideBar();
    }

    @Then("I order some products {string}")
    public void orderdSomeProducts(String producto) {
        homePage.addProductToCart(producto);
    }

    @And("Check if the state is now reseted")
    public void checkIfTheStateIsNowReseted() {
        homePage.checkResetState();
    }

    @When("I click on the cart button")
    public void iClickOnTheCartButton() {
        homePage.clickCartButton();
    }

    @And("I click on the sortedComboBox option")
    public void iClickOnTheSortedComboBoxOption() {
        homePage.clicksetSlideBar();
    }

}
