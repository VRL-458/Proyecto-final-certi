package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage {
    WebDriver driver;


    @FindBy(id = "first-name")
    WebElement firstNametext;
    @FindBy(id = "last-name")
    WebElement lastnametext;
    @FindBy(id = "postal-code")
    WebElement postalcodetext;

    @FindBy(name = "continue")
    WebElement continuebtn;

    public CheckoutStepOnePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstname) {firstNametext.sendKeys(firstname);}
    public void setLastname(String lastname) {lastnametext.sendKeys(lastname);}
    public void setPostalcode(String postalcode) {postalcodetext.sendKeys(postalcode);}
    public void clickContinue() {continuebtn.click();}
}

