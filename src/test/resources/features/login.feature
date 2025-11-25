# language: es
Característica: Login de usuarios del Banco Platinum

  Escenario: Ingreso exitoso con credenciales correctas
    Dado que el usuario está en la página de login
    Cuando ingresa el nombre de usuario "admin" y password "admin123"
    Entonces el usuario debe ser redirigido al dashboard

  Escenario: Ingreso fallido con credenciales incorrectas
    Dado que el usuario está en la página de login
    Cuando ingresa el nombre de usuario "usuario_invalido" y password "password_invalido"
    Entonces debe mostrar un mensaje de error
