-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema shopr
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shopr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopr` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `shopr` ;

-- -----------------------------------------------------
-- Table `shopr`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`article` (
  `type` VARCHAR(31) NOT NULL,
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `distributor` VARCHAR(255) NULL DEFAULT NULL,
  `price` INT(11) NOT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`book` (
  `author` VARCHAR(255) NULL DEFAULT NULL,
  `isbn` VARCHAR(255) NULL DEFAULT NULL,
  `nr_pages` INT(11) NOT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`fiction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`fiction` (
  `fiction_genre_enum` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`game` (
  `age` INT(11) NOT NULL,
  `game_genre_enum` VARCHAR(255) NULL DEFAULT NULL,
  `studio` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`lp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`lp` (
  `artist` VARCHAR(255) NULL DEFAULT NULL,
  `lp_genre_enum` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`non_fiction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`non_fiction` (
  `about` VARCHAR(255) NULL DEFAULT NULL,
  `non_fiction_genre_enum` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`order_article_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`order_article_list` (
  `order_id` BIGINT(20) NOT NULL,
  `article_list_id` BIGINT(20) NOT NULL,
  UNIQUE INDEX `UK_npevxpwo9nofxv6aptfc51nh5` (`article_list_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`order_from_shop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`order_from_shop` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `order_date` DATETIME NULL DEFAULT NULL,
  `user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKl8rt4re2e67sovw42vgp3hqtj` (`user_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`order_from_shop_article_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`order_from_shop_article_list` (
  `order_from_shop_id` BIGINT(20) NOT NULL,
  `article_list_id` BIGINT(20) NOT NULL,
  UNIQUE INDEX `UK_8ylk46y6fgopn1ycsmx2jis0w` (`article_list_id` ASC) VISIBLE,
  INDEX `FKfq31llabn31ehvp6213g274mw` (`order_from_shop_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`order_line`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`order_line` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `amount` INT(11) NOT NULL,
  `price_order_date` INT(11) NOT NULL,
  `article_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKgyaq7gsm6vugjkw4smqwxsn4b` (`article_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`rating` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(255) NULL DEFAULT NULL,
  `score` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `user_role_enum` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`user_article_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`user_article_list` (
  `user_id` BIGINT(20) NOT NULL,
  `article_list_id` BIGINT(20) NOT NULL,
  INDEX `FK76ce5t29linrc8stwfrc03rpy` (`article_list_id` ASC) VISIBLE,
  INDEX `FKctw6lf0wu8ikrlp4hr53gq0cn` (`user_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`user_rating_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`user_rating_list` (
  `user_id` BIGINT(20) NOT NULL,
  `rating_list_id` BIGINT(20) NOT NULL,
  INDEX `FKmx7rl5j25ll6swyx70yfm3unc` (`rating_list_id` ASC) VISIBLE,
  INDEX `FK2ul8rbpb4d2veaidoyf21c3ke` (`user_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
