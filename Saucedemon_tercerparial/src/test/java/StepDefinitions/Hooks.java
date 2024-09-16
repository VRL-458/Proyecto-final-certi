package StepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario() {
        // Inicializar el WebDriver antes de que inicie el escenario
        DriverManager.getDriver();
    }

    @After
    public void afterScenario() {
        // Cerrar y limpiar el WebDriver después de que termine el escenario
        DriverManager.getDriver().quitDriver();
    }
}
