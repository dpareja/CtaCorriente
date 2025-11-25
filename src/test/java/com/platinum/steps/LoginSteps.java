package com.platinum.steps;

import io.cucumber.java.es.*;

public class LoginSteps {
    private String usuario;
    private String password;
    private boolean loginExitoso;

    @Dado("que el usuario está en la página de login")
    public void queElUsuarioEstaEnLaPaginaDeLogin() {
        // Simular que el usuario está en la página de login
        loginExitoso = false;
    }

    @Cuando("ingresa el nombre de usuario {string} y password {string}")
    public void ingresaElNombreDeUsuarioYPassword(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        // Simular validación de credenciales
        if ("admin".equals(usuario) && "admin123".equals(password)) {
            loginExitoso = true;
        }
    }

    @Entonces("el usuario debe ser redirigido al dashboard")
    public void elUsuarioDebeSerRedirigidoAlDashboard() {
        if (!loginExitoso) {
            throw new AssertionError("Login no fue exitoso");
        }
    }

    @Entonces("debe mostrar un mensaje de error")
    public void debeMostrarUnMensajeDeError() {
        if (loginExitoso) {
            throw new AssertionError("Login fue exitoso cuando debería fallar");
        }
    }
}
