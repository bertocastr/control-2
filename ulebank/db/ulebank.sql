SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `ULEBANK` ;
USE `ULEBANK` ;

-- -----------------------------------------------------
-- Table `ULEBANK`.`OFFICES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ULEBANK`.`OFFICES` (
  `office_id` VARCHAR(64) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `bank_id` VARCHAR(64) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `local_cost` INT(11) NOT NULL,
  `utilities_cost` INT(11) NOT NULL,
  `employee_cost` INT(11) NOT NULL,
  `total_expenses` INT(11) NOT NULL,
  `total_income` INT(11) NOT NULL,
  `balance` INT(11) NOT NULL,
  `account_number` VARCHAR(64) NOT NULL,
  `next_account_number` INT(12) NOT NULL,
  `address` VARCHAR(64) NOT NULL,
  `zip` VARCHAR(64) NOT NULL,
  `phone` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`office_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `ULEBANK`.`ACCOUNTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ULEBANK`.`ACCOUNTS` (
  `account_number` VARCHAR(64) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `balance` DOUBLE NOT NULL,
  `last_liquidation` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `liquidation_frequency` INT(11) NOT NULL,
  `max_overdraft` DOUBLE NOT NULL,
  `office_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`account_number`),
  INDEX `fk_ACCOUNTS_OFFICES1_idx` (`office_id` ASC),
  CONSTRAINT `fk_ACCOUNTS_OFFICES1`
    FOREIGN KEY (`office_id`)
    REFERENCES `ULEBANK`.`OFFICES` (`office_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `ULEBANK`.`EMPLOYEES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ULEBANK`.`EMPLOYEES` (
  `employee_id` VARCHAR(64) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `name` VARCHAR(64) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `surnames` VARCHAR(128) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `salary` FLOAT NOT NULL,
  `address` VARCHAR(256) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `office_id` VARCHAR(64) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  INDEX `id` (`employee_id` ASC),
  INDEX `office_id` (`office_id` ASC),
  PRIMARY KEY (`employee_id`),
  CONSTRAINT `EMPLOYEE_ibfk_1`
    FOREIGN KEY (`office_id`)
    REFERENCES `ULEBANK`.`OFFICES` (`office_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `ULEBANK`.`CLIENTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ULEBANK`.`CLIENTS` (
  `client_id` VARCHAR(12) NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `surnames` VARCHAR(64) NOT NULL,
  `address` VARCHAR(256) NOT NULL,
  `civil_state` VARCHAR(2) NOT NULL,
  `phone_number1` VARCHAR(20) NOT NULL,
  `phone_number2` VARCHAR(20) NULL,
  `profession` VARCHAR(64) NOT NULL,
  `birth_date` DATE NOT NULL,
  `enterprise_name` VARCHAR(32) NULL,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ULEBANK`.`ACCOUNTS_CLIENTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ULEBANK`.`ACCOUNTS_CLIENTS` (
  `client_id` VARCHAR(64) NOT NULL,
  `account_number` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`client_id`, `account_number`),
  INDEX `fk_ACCOUNTS_CLIENTS_ACCOUNTS1_idx` (`account_number` ASC),
  CONSTRAINT `fk_ACCOUNTS_CLIENTS_CLIENTS1`
    FOREIGN KEY (`client_id`)
    REFERENCES `ULEBANK`.`CLIENTS` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ACCOUNTS_CLIENTS_ACCOUNTS1`
    FOREIGN KEY (`account_number`)
    REFERENCES `ULEBANK`.`ACCOUNTS` (`account_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
