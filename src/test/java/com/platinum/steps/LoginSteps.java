package com.platinum.steps;

import io.cucumber.java.After;
import io.cucumber.java.es.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginSteps {
    private WebDriver driver;

    @Dado("que el usuario está en la página de login")
    public void queElUsuarioEstaEnLaPaginaDeLogin() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-logging"});
        driver = new ChromeDriver(options);
        driver.get("http://192.168.3.100:8881/login");
    }

    @Cuando("ingresa el nombre de usuario {string} y password {string}")
    public void ingresaElNombreDeUsuarioYPassword(String usuario, String password) {
        driver.findElement(By.id("username")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginBtn")).click();
    }

    @Entonces("el usuario debe ser redirigido al dashboard")
    public void elUsuarioDebeSerRedirigidoAlDashboard() throws InterruptedException {
        Thread.sleep(1000);
        if (!driver.getCurrentUrl().contains("dashboard")) {
            throw new AssertionError("No se redirigió al dashboard");
        }
    }

    @Entonces("debe mostrar un mensaje de error")
    public void debeMostrarUnMensajeDeError() throws InterruptedException {
        Thread.sleep(1000);
        if (!driver.getPageSource().contains("Credenciales incorrectas")) {
            throw new AssertionError("No se mostró mensaje de error");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
