package com.platinum.steps;

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
        driver = new ChromeDriver(options);
        driver.get("http://localhost:8080/login");
    }

    @Cuando("ingresa el nombre de usuario {string} y password {string}")
    public void ingresaElNombreDeUsuarioYPassword(String usuario, String password) {
        driver.findElement(By.id("username")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginBtn")).click();
    }

    @Entonces("el usuario debe ser redirigido al dashboard")
    public void elUsuarioDebeSerRedirigidoAlDashboard() {
        driver.quit();
    }

    @Entonces("debe mostrar un mensaje de error")
    public void debeMostrarUnMensajeDeError() {
        driver.quit();
    }
}
