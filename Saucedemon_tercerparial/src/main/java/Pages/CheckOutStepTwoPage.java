package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;
import java.util.List;

public class CheckOutStepTwoPage {
    WebDriver driver;

    @FindBy(className = "inventory_item_price")
    List<WebElement> precio;

    @FindBy(className = "summary_subtotal_label")
    WebElement textPrecio;

    public CheckOutStepTwoPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void checktotalPrice(){
        Double precio_total= 0.0;
        for(WebElement element : precio){
            String precioProducto = element.getText();
            precioProducto = precioProducto.replace("$", "");
            double precioItem = Double.parseDouble(precioProducto);
            precio_total += precioItem;

        }

        String textPrecioSummary = textPrecio.getText();
        textPrecioSummary = textPrecioSummary.replace("Item total: $", "");
        double summaryPrecio = Double.parseDouble(textPrecioSummary);
        //que el precio calculado sea igual al precio total del carrito
        Assertions.assertEquals(precio_total, summaryPrecio);


    }
}
