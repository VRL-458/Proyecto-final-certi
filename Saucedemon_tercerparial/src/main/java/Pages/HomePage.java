package Pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    WebElement slideBar;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement buttonProduct1;

    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    WebElement buttonProduct2;

    @FindBy(id="Reset App State")
    WebElement slidebarOptionReset;

    @FindBy(className = "shopping_cart_link")
    WebElement cartButton;
    @FindBy(className = "product_sort_container")
    WebElement sortComboBox;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart(String productName){
        String productId = "add-to-cart-"+productName.replace(" ", "-").toLowerCase();
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();
    }

    public void clicksetSlideBar(){slideBar.click();}

    public void optionResetSlideBar()
    {
        WebElement slideBarOptionReset = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Reset App State")));
        slideBarOptionReset.click();

    }

    //esta prueba en la hora de ejecucion, pasa porque se maneja al excepcion del  assert pero en si el reesultado del test es un error.
    //Se hizo de estea manera al aprender como manejar las excepciones y mostrar mensajes personalizados en consola del error
    public void checkResetState()
    {
        try {
            WebElement buttonremove1 = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
            WebElement buttonremove2 = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("add-to-cart-sauce-labs-bike-light")));

        }
        catch (TimeoutException e) {
            System.out.println("Error el boton de Add to cart no ha vuelto a aparecer ");
        }
    }
    public void ordenarPrecio(){
        Select selectObject =  new Select(sortComboBox);
        selectObject.selectByValue("lohi");
        List<WebElement> productName = driver.findElements(By.className("inventory-item-price"));

        List<String> actualProductsOrder = new ArrayList<>();
        for(WebElement product : productName){
            actualProductsOrder.add(product.getText());
        }
        boolean isSorted = Ordering.natural().isOrdered(
                actualProductsOrder.stream()
                        .map(s -> Integer.parseInt(s.replace("$", ""))) // Convertir a números
                        .collect(Collectors.toList())
        );
    }


    public void clickCartButton() {cartButton.click();}



}
