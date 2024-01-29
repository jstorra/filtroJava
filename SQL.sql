DROP DATABASE IF EXISTS db_misiones;
CREATE DATABASE db_misiones;
USE db_misiones;

CREATE TABLE ninja (
    ninjaId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    rango ENUM("rango1", "rango2", "rango3") NOT NULL,
    aldea VARCHAR(255) NOT NULL
);

CREATE TABLE mision (
    misionId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    rango ENUM("rango1", "rango2", "rango3") NOT NULL,
    recompensa DECIMAL(10,2) NOT NULL
);

CREATE TABLE misionNinja (
    ninjaId INT NOT NULL,
    misionId INT NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFin DATE,
    PRIMARY KEY (ninjaId, misionId),
    FOREIGN KEY (ninjaId) REFERENCES ninja(ninjaId),
    FOREIGN KEY (misionId) REFERENCES mision(misionId)
);

CREATE TABLE habilidad (
    ninjaId INT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    FOREIGN KEY (ninjaId) REFERENCES ninja(ninjaId)
);

INSERT INTO ninja VALUES
(1, "naruto", "rango1", "hoja"),
(2, "sakura", "rango2", "hoja"),
(3, "pachon", "rango3", "hoja");

INSERT INTO mision VALUES
(1, "derrotar el filtro de Java", "rango3", 500),
(2, "ganar una batalla con cualquier aldea", "rango2", 700),
(3, "derrotar a los maliantes", "rango1", 800);

INSERT INTO misionNinja VALUES
(1, 3, "2024-01-29", NULL),
(2, 1, "2024-02-29", NULL),
(3, 2, "2024-03-29", NULL);

INSERT INTO habilidad VALUES
(1, "fuegito", "escupe fuego :O"),
(2, "aguita", "escupe agua :)"),
(3, "tierra", "escupe tierra :/");