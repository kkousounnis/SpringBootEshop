DROP DATABASE `eshop1`;
CREATE DATABASE `eshop1`;
USE eshop1;

CREATE TABLE `products` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`name` VARCHAR (40), 
`price` DECIMAL(10,3) NOT NULL, 
`quantity` INT NOT NULL);
INSERT INTO `eshop1`.`products` (`name`, `price`, `quantity`) VALUES ('Smart Watch', '100', '1');


CREATE TABLE `customers` (
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`first_name` VARCHAR (40) NOT NULL, 
`last_name` VARCHAR (40) NOT NULL,  
`tel` VARCHAR (40) NOT NULL, 
`email` VARCHAR (40) NOT NULL);
INSERT INTO `eshop1`.`customers` (`first_name`, `last_name`, `tel`, `email`) VALUES ('George', 'Pasparakis', '210111', 'paspa@hotmail.com');

CREATE TABLE `orders2` (
`id` int NOT NULL AUTO_INCREMENT,
`date` datetime NOT NULL,
`customers_id` int NOT NULL,
`total_price` decimal(10,3) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `fk_orders2_customers_id__customers_id_idx` (`customers_id`),
CONSTRAINT `fk_orders2_customers_id__customers_id` FOREIGN KEY (`customers_id`) REFERENCES `customers` (`id`)
);

CREATE TABLE `eshop1`.`orders2_details` (
`id` INT NOT NULL AUTO_INCREMENT,
`orders2_id` INT NOT NULL,
`products_id` INT NOT NULL,
`price` DECIMAL(10,3) NOT NULL,
`quantity` INT NOT NULL,
PRIMARY KEY (`id`), 
CONSTRAINT `fk_orders2_details_orders2_id__orders2_id` FOREIGN KEY (`orders2_id`) REFERENCES `eshop1`.`orders2` (`id`),
CONSTRAINT `fk_orders2_details_products_id__products_id` FOREIGN KEY (`products_id`) REFERENCES `eshop1`.`products` (`id`));
