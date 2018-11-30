-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fog
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fog` DEFAULT CHARACTER SET latin1 ;
USE `fog` ;

-- -----------------------------------------------------
-- Table `fog`.`Carport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Carport` (
  `idCarport` INT(11) NOT NULL AUTO_INCREMENT,
  `Width` VARCHAR(45) NOT NULL,
  `Length` VARCHAR(45) NOT NULL,
  `ShedWidth` VARCHAR(45) NOT NULL,
  `ShedLength` VARCHAR(45) NOT NULL,
  `Roof` TINYINT(1) NOT NULL,
  `Shed` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idCarport`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Customer` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Adress` VARCHAR(45) NULL DEFAULT NULL,
  `City` VARCHAR(45) NULL DEFAULT NULL,
  `Phonenumber` VARCHAR(45) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 55
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog`.`Materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Materials` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `MaterialeNavn` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Order` (
  `OrderID` INT(11) NOT NULL AUTO_INCREMENT,
  `customerID` INT(11) NOT NULL,
  `idCarport` INT(11) NOT NULL,
  `pdf` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`OrderID`, `idCarport`),
  INDEX `FK_Customer_idx` (`customerID` ASC),
  INDEX `fk_Order_Carport1_idx` (`idCarport` ASC),
  CONSTRAINT `FK_Customer`
    FOREIGN KEY (`customerID`)
    REFERENCES `fog`.`Customer` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Carport1`
    FOREIGN KEY (`idCarport`)
    REFERENCES `fog`.`Carport` (`idCarport`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog`.`Produkter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`Produkter` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Navn` VARCHAR(45) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Pris` INT(11) NULL DEFAULT NULL,
  `Beskrivelse` TEXT CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Længde` INT(11) NULL DEFAULT NULL,
  `Enhed` VARCHAR(45) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  `Type` VARCHAR(11) CHARACTER SET 'latin1' NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 41
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_danish_ci;


-- -----------------------------------------------------
-- Table `fog`.`ShedLength`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`ShedLength` (
  `length` INT(11) NOT NULL,
  PRIMARY KEY (`length`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog`.`ShedWidth`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`ShedWidth` (
  `width` INT(11) NOT NULL,
  PRIMARY KEY (`width`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog`.`length`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`length` (
  `length` INT(11) NOT NULL,
  PRIMARY KEY (`length`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog`.`width`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`width` (
  `width` INT(11) NOT NULL,
  PRIMARY KEY (`width`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
