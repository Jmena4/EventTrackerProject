-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fuelmileagedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fuelmileagedb` ;

-- -----------------------------------------------------
-- Schema fuelmileagedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fuelmileagedb` DEFAULT CHARACTER SET utf8 ;
USE `fuelmileagedb` ;

-- -----------------------------------------------------
-- Table `vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vehicle` ;

CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vin` VARCHAR(65) NULL,
  `year` INT NULL,
  `make` VARCHAR(100) NULL,
  `model` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fuel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Fuel` ;

CREATE TABLE IF NOT EXISTS `Fuel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `gallons` DOUBLE NULL,
  `price_per_gallon` DOUBLE NULL,
  `total_purchase_price` DECIMAL(9,2) NULL,
  `estimated_miles` INT NULL,
  `odometer_reading` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vehicle_id_to_vehicle_idx` (`vehicle_id` ASC),
  CONSTRAINT `fk_vehicle_id_to_vehicle`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS fueluser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'fueluser'@'localhost' IDENTIFIED BY 'fuelword';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'fueluser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `vehicle`
-- -----------------------------------------------------
START TRANSACTION;
USE `fuelmileagedb`;
INSERT INTO `vehicle` (`id`, `vin`, `year`, `make`, `model`) VALUES (1, 'xter', 2012, 'Nissan', 'Xterra Pro-4x');
INSERT INTO `vehicle` (`id`, `vin`, `year`, `make`, `model`) VALUES (2, 'dc2', 2001, 'Acura', 'Integra Type-R');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Fuel`
-- -----------------------------------------------------
START TRANSACTION;
USE `fuelmileagedb`;
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (1, '2016-06-30', 5.18, 1.939, 10.04, 169, 1, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (2, '2016-07-04', 11.095, 1.939, 21.51, 366, 1, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (3, '2016-07-13', 5.704, 1.879, 10.72, 184, 1, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (4, '2016-07-15', 10.768, 1.869, 20.13, 332, 1, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (5, '2016-07-21', 10.53, 1.849, 19.47, 307, 1, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (6, '2016-07-27', 10.926, 1.819, 19.87, 314, 1, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (7, '2016-08-04', 11.343, 1.859, 21.09, 376, 1, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (8, '2016-08-12', 10.905, 1.899, 20.71, 332, 21162, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (9, '2016-08-19', 11.415, 2.279, 26.01, 355, 21470, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (10, '2016-08-21', 10.709, 2.499, 26.76, 363, 21782, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (11, '2016-08-24', 10.67, 1.999, 21.33, 394, 22095, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (12, '2017-01-15', 11.03, 2.069, 22.82, 347, 26349, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (13, '2017-02-23', 11.275, 2.039, 22.99, 369, 26683, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (14, '2017-03-09', 11.275, 2.099, 24.21, 369, 26966, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (15, '2017-03-16', 10.456, 2.099, 21.95, 345, 27215, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (16, '2017-03-25', 10.75, 2.099, 22.56, 342, 27489, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (17, '2017-04-01', 10.887, 2.1119, 23.07, 357, 27797, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (18, '2017-04-05', 10.857, 2.119, 23.00, 373, 28114, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (19, '2017-04-16', 9.481, 2.999, 28.43, 1, 50134, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (20, '2017-04-26', 9.897, 2.999, 29.68, 1, 50357, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (21, '2017-05-04', 9.211, 2.999, 27.62, 1, 50574, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (22, '2017-05-23', 9.2, 2.549, 25.00, 1, 50850, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (23, '2017-05-30', 5.001, 2.999, 15.00, 1, 51051, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (24, '2017-06-07', 4.263, 2.349, 10.01, 1, 51188, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (25, '2017-06-10', 9.291, 2.349, 23.45, 1, 51546, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (26, '2017-06-23', 9.315, 2.469, 23.00, 1, 51786, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (27, '2017-06-30', 9.429, 2.519, 23.75, 1, 52034, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (28, '2017-07-29', 9.342, 2.569, 24.00, 1, 52286, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (29, '2017-08-08', 9.099, 2.699, 24.56, 1, 52531, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (30, '2017-08-16', 5.809, 2.639, 15.33, 1, 52780, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (31, '2018-01-23', 9.274, 2.989, 27.72, 1, 53794, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (32, '2018-04-06', 6.54, 3.059, 20.01, 1, 54014, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (33, '2018-08-18', 9.467, 2.656, 28.01, 1, 54437, 2);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (34, '2018-02-11', 10.409, 2.179, 22.68, 328, 81477, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (35, '2018-02-11', 16.815, 2.499, 42.02, 345, 81782, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (36, '2018-02-11', 16.692, 2.399, 40.04, 350, 82097, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (37, '2018-02-15', 15.043, 2.299, 33.98, 328, 82383, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (38, '2018-02-24', 16.38, 2.259, 37.00, 350, 82676, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (39, '2018-03-05', 16.104, 2.409, 38.79, 319, 82961, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (40, '2018-03-15', 15.81, 2.219, 35.08, 364, 83234, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (41, '2018-04-05', 12.201, 2.459, 30.00, 259, 83799, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (42, '2018-04-11', 12.4, 2.459, 34.5, 301, 84018, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (43, '2018-04-15', 17.135, 2.599, 44.53, 325, 84302, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (44, '2018-05-08', 16.514, 2.529, 41.76, 326, 84607, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (45, '2018-05-12', 12.419, 2.619, 32.53, 340, 84811, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (46, '2018-05-17', 14.24, 2.809, 40.00, 334, 85088, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (47, '2018-05-18', 11.752, 2.759, 32.42, 260, 85371, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (48, '2018-05-18', 14.634, 2.479, 36.28, 367, 85598, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (49, '2018-05-20', 16.513, 2.779, 45.85, 364, 86079, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (50, '2018-05-31', 16.855, 2.759, 46.50, 359, 86364, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (51, '2018-06-26', 16.445, 2.459, 41.18, 335, 86635, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (52, '2018-07-04', 16.224, 2.249, 36.49, 328, 86897, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (53, '2018-07-13', 20.148, 2.159, 43.50, 329, 87188, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (54, '2018-07-20', 14.93, 2.499, 37.31, 328, 87443, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (55, '2018-07-27', 14.006, 2.499, 35.00, 319, 87696, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (56, '2018-08-04', 16.514, 2.599, 42.92, 326, 87954, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (57, '2018-08-13', 17.082, 2.689, 45.93, 323, 88229, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (58, '2018-08-22', 16.539, 2.529, 41.83, 320, 88502, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (59, '2018-09-10', 17.404, 2.499, 43.49, 320, 88800, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (60, '2018-10-01', 16.717, 2.989, 49.97, 320, 89717, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (61, '2018-10-02', 17.433, 2.889, 50.36, 335, 90001, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (62, '2018-10-06', 16.864, 2.699, 45.52, 345, 90316, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (63, '2018-10-12', 13.127, 2.779, 36.18, 3.12, 90583, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (64, '2018-10-20', 17.211, 2.419, 41.63, 350, 90862, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (65, '2018-10-25', 17.095, 2.759, 47.17, 344, 91161, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (66, '2018-11-02', 16.235, 2.599, 42.19, 346, 91447, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (67, '2018-11-12', 15.999, 2.399, 39.38, 354, 91752, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (68, '2018-11-15', 17.037, 2.399, 40.87, 345, 92073, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (69, '2018-11-23', 16.38, 2.219, 36.35, 350, 92355, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (70, '2018-12-05', 17.03, 2.199, 37.45, 381, 92642, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (71, '2018-12-12', 16.813, 1.999, 33.61, 356, 92903, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (72, '2018-12-18', 16.716, 1.999, 33.42, 346, 93206, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (73, '2018-12-22', 15.416, 1.929, 30.66, 331, 93462, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (74, '2018-12-26', 17.446, 2.099, 36.62, 329, 39764, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (75, '2019-01-01', 16.641, 1.849, 30.77, 358, 94645, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (76, '2019-01-04', 16.025, 1.969, 31.55, 335, 94943, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (77, '2019-01-11', 16.958, 1.879, 31.86, 322, 95189, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (78, '2019-01-22', 15.603, 1.959, 30.57, 308, 96995, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (79, '2019-01-31', 16.443, 1.859, 30.57, 298, 97252, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (80, '2019-03-02', 15.22, 2.129, 32.4, 288, 97952, 1);
INSERT INTO `Fuel` (`id`, `date`, `gallons`, `price_per_gallon`, `total_purchase_price`, `estimated_miles`, `odometer_reading`, `vehicle_id`) VALUES (81, '3/11/19', 17.299, 2.159, 37.35, 298, 98225, 1);

COMMIT;

