-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema lab6nuevo
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rol` (
  `id_rol` INT NOT NULL,
  `nombre_rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuarios` (
  `idusuario` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(256) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `activo` INT NOT NULL,
  `idRol` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `fk_usuarios_Rol_idx` (`idRol` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_Rol`
    FOREIGN KEY (`idRol`)
    REFERENCES `mydb`.`rol` (`id_rol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`mesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`mesas` (
  `id_mesa` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `cantidad` INT NOT NULL,
  `disponibilidad` INT NOT NULL,
  `eliminado` INT NOT NULL,
  PRIMARY KEY (`id_mesa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reserva` (
  `id` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `fechafin` VARCHAR(45) NOT NULL,
  `fechainicio` VARCHAR(45) NOT NULL,
  `id_cliente` INT NOT NULL,
  `id_mesa` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reservas_usuarios1_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_reservas_dispositivos1_idx` (`id_mesa` ASC) VISIBLE,
  CONSTRAINT `fk_reservas_usuarios1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `mydb`.`usuarios` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservas_dispositivos1`
    FOREIGN KEY (`id_mesa`)
    REFERENCES `mydb`.`mesas` (`id_mesa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
