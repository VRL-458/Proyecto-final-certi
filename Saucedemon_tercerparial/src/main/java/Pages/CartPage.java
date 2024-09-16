package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;



    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkEmptyCart(){

        WebElement buttoncheckout = driver.findElement(By.name("checkout"));
        Assertions.assertFalse(buttoncheckout.isEnabled());
    }

    public void checkProductinTheCart() {

        List<WebElement> productos = driver.findElements(By.className("inventory_item"));
        List<String> nombresProductosSeleccionados = new ArrayList<>();


        for (WebElement producto : productos) {
            //se gurda el nombre del boton de dicho producto iterado
            WebElement boton = producto.findElement(By.cssSelector(".btn_inventory"));
            String textoBoton = boton.getText();


            if (textoBoton.equalsIgnoreCase("Remove")) {
                WebElement nombreProducto = producto.findElement(By.className("inventory_item_name"));
                nombresProductosSeleccionados.add(nombreProducto.getText());
            }
        }
        System.out.println("estoy antes del carrito click");
        //click boton carrito
        WebElement cartbutton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("shopping_cart_link")));
        cartbutton.click();
        System.out.println("estoy despues del carrito click");

        //Lista de productos en carrito
        List<WebElement> nombreProductosCarrito = driver.findElements(By.className("inventory_item_name"));
        List<String> nombreStringproductos = new ArrayList<>();
        for (WebElement nombreProducto : nombreProductosCarrito) {
            nombreStringproductos.add(nombreProducto.getText());
        }
        Assertions.assertEquals(nombresProductosSeleccionados, nombreStringproductos);
    }
    public void ClickonCheckoutButton(){
        WebElement buttoncheckout = driver.findElement(By.name("checkout"));
        buttoncheckout.click();
    }

}
