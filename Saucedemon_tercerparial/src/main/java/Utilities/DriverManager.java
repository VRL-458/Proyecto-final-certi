package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static DriverManager instance;
    public WebDriver driver;

    // Constructor privado para garantizar el uso de getDriver()
    private DriverManager() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    // Método estático para obtener la instancia única de DriverManager
    public static DriverManager getDriver() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    // Método para cerrar el WebDriver
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            instance = null; // Reiniciar la instancia para el siguiente escenario
        }
    }
}
