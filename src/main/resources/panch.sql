SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `panch` ;
CREATE SCHEMA IF NOT EXISTS `panch` DEFAULT CHARACTER SET latin1 ;
USE `panch` ;

-- -----------------------------------------------------
-- Table `panch`.`otts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `panch`.`otts` ;

CREATE  TABLE IF NOT EXISTS `panch`.`otts` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(255) NOT NULL ,
  `status` ENUM('ACTIVE', 'INACTIVE') NOT NULL ,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP ,
  `updated_at` DATETIME ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `panch`.`packages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `panch`.`packages` ;

CREATE  TABLE IF NOT EXISTS `panch`.`packages` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(255) NOT NULL ,
  `num_seats` INT NOT NULL ,
  `basis` ENUM('MON', 'YR') NOT NULL ,
  `pricing` DECIMAL(10,2) NOT NULL ,
  `currency` VARCHAR(5) NOT NULL ,
  `status` ENUM('ACTIVE', 'INACTIVE') NULL ,
  `otts_id` INT NOT NULL ,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP ,
  `updated_at` DATETIME ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`, `otts_id`) ,
  INDEX `fk_packages_otts_idx` (`otts_id` ASC) ,
  CONSTRAINT `fk_packages_otts`
    FOREIGN KEY (`otts_id` )
    REFERENCES `panch`.`otts` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `panch`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `panch`.`users` ;

CREATE  TABLE IF NOT EXISTS `panch`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(255) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `panch`.`inventories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `panch`.`inventories` ;

CREATE  TABLE IF NOT EXISTS `panch`.`inventories` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `num_seats` INT NOT NULL ,
  `status` ENUM('ACTIVE', 'INACTIVE') NOT NULL ,
  `starts_at` DATETIME NOT NULL ,
  `expires_at` DATETIME NOT NULL ,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP ,
  `updated_at` DATETIME ON UPDATE CURRENT_TIMESTAMP ,
  `users_id` INT NOT NULL ,
  `packages_otts_id` INT NOT NULL ,
  PRIMARY KEY (`id`, `users_id`, `packages_otts_id`) ,
  INDEX `fk_inventories_users1_idx` (`users_id` ASC) ,
  INDEX `fk_inventories_packages1_idx` (`packages_otts_id` ASC) ,
  CONSTRAINT `fk_inventories_users1`
    FOREIGN KEY (`users_id` )
    REFERENCES `panch`.`users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inventories_packages1`
    FOREIGN KEY (`packages_otts_id` )
    REFERENCES `panch`.`packages` (`otts_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `panch`.`bookings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `panch`.`bookings` ;

CREATE  TABLE IF NOT EXISTS `panch`.`bookings` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `num_seats` INT NOT NULL ,
  `status` ENUM('IN_PROGRESS', 'FAILED', 'SUCCESS') NULL ,
  `booked_at` VARCHAR(45) NULL ,
  `expires_at` VARCHAR(45) NULL ,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP ,
  `updated_at` DATETIME ON UPDATE CURRENT_TIMESTAMP ,
  `inventories_id` INT NOT NULL ,
  `users_id` INT NOT NULL ,
  PRIMARY KEY (`id`, `inventories_id`, `users_id`) ,
  INDEX `fk_bookings_inventories1_idx` (`inventories_id` ASC) ,
  INDEX `fk_bookings_users1_idx` (`users_id` ASC) ,
  CONSTRAINT `fk_bookings_inventories1`
    FOREIGN KEY (`inventories_id` )
    REFERENCES `panch`.`inventories` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bookings_users1`
    FOREIGN KEY (`users_id` )
    REFERENCES `panch`.`users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `panch` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
