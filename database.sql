CREATE DATABASE IF NOT EXISTS Cuentas_clientes;
USE Cuentas_clientes;

CREATE TABLE IF NOT EXISTS ejecutivo (
    rutEjecutivo VARCHAR(12) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    departamento VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreUsuario VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Persona (
    Rut VARCHAR(12) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    correo VARCHAR(100),
    telefono VARCHAR(20),
    nombreMascota VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS CtaCorriente (
    idCuenta INT AUTO_INCREMENT PRIMARY KEY,
    RutCliente VARCHAR(12),
    monto DECIMAL(15,2),
    ejecutivo VARCHAR(12),
    FOREIGN KEY (RutCliente) REFERENCES Persona(Rut),
    FOREIGN KEY (ejecutivo) REFERENCES ejecutivo(rutEjecutivo)
);

CREATE TABLE IF NOT EXISTS Transaccion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rutCliente VARCHAR(12),
    rutDueno VARCHAR(12),
    idCuenta INT,
    montoTransferencia DECIMAL(15,2),
    cuentaTransferencia VARCHAR(50),
    TipoCuenta VARCHAR(50),
    FOREIGN KEY (rutCliente) REFERENCES Persona(Rut),
    FOREIGN KEY (rutDueno) REFERENCES Persona(Rut),
    FOREIGN KEY (idCuenta) REFERENCES CtaCorriente(idCuenta)
);

-- Datos de ejemplo
INSERT INTO ejecutivo VALUES ('12345678-9', 'Juan Pérez', 'Comercial');
INSERT INTO usuario VALUES (1, 'admin', 'admin123');
INSERT INTO Persona VALUES ('11111111-1', 'María', 'González', 'Av. Principal 123', 'maria@email.com', '912345678', 'Firulais');
