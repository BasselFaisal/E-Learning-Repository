-- -----------------------------------------------------
-- Schema full-stack-ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `elearning`;

CREATE SCHEMA `elearning`;
USE `elearning` ;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`user_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`tutorial_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tutorial_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `categoryname` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`tutorial`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS`tutorial` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(255) DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `unitprice` double(13,2) DEFAULT NULL,
  `imageurl` VARCHAR(255) DEFAULT NULL,
  `active` BIT DEFAULT 1,
  `unitsinstock` INT(11) DEFAULT NULL,
  `datecreated` DATETIME(6) DEFAULT NULL,
  `lastupdated` DATETIME(6) DEFAULT NULL,
  `category_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `tutorial_category` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;

DROP TABLE IF EXISTS `cart_tutorials`;

CREATE TABLE `cart_tutorials` (
  `cart_id` int(11) NOT NULL,
  `tutorial_id` BIGINT(11) NOT NULL,
  
  PRIMARY KEY (`cart_id`,`tutorial_id`),
  
  KEY `FK_USER_idx` (`tutorial_id`),
  
  CONSTRAINT `FK_cart_05` FOREIGN KEY (`cart_id`) 
  REFERENCES `cart` (`id`) 
  ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_tutorial` FOREIGN KEY (`tutorial_id`) 
  REFERENCES `tutorial` (`id`) 
  ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user_tutorials`;

CREATE TABLE `user_tutorials` (
  `user_id` int(11) NOT NULL,
  `tutorial_id` BIGINT(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`tutorial_id`),
  
  KEY `FK_USER_idx` (`tutorial_id`),
  
  CONSTRAINT `FK_user_05` FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`) 
  ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_tutorial_05` FOREIGN KEY (`tutorial_id`) 
  REFERENCES `tutorial` (`id`) 
  ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- -----------------------------------------------------
-- Categories
-- -----------------------------------------------------
INSERT INTO tutorial_category(categoryname) VALUES ('Books');
INSERT INTO tutorial_category(categoryname) VALUES ('Coffee Mugs');
INSERT INTO tutorial_category(categoryname) VALUES ('Mouse Pads');
INSERT INTO tutorial_category(categoryname) VALUES ('Luggage Tags');

-- -----------------------------------------------------
-- Books
-- -----------------------------------------------------
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1000', 'Crash Course in Python', 'Learn Python at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1000.png', 1, 100, 14.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1001', 'Become a Guru in JavaScript', 'Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1001.png', 1, 100, 20.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1002', 'Exploring Vue.js', 'Learn Vue.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1002.png', 1, 100, 14.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1003', 'Advanced Techniques in Big Data', 'Learn Big Data at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1003.png', 1, 100, 13.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1004', 'Crash Course in Big Data', 'Learn Big Data at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1004.png', 1, 100, 18.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1005', 'JavaScript Cookbook', 'Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1005.png', 1, 100, 23.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1006', 'Beginners Guide to SQL', 'Learn SQL at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1006.png', 1, 100, 14.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1007', 'Advanced Techniques in JavaScript', 'Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1007.png', 1, 100, 16.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1008', 'Introduction to Spring Boot', 'Learn Spring Boot at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1008.png', 1, 100, 25.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1009', 'Become a Guru in React.js', 'Learn React.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1009.png', 1, 100, 23.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1010', 'Beginners Guide to Data Science', 'Learn Data Science at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1010.png', 1, 100, 24.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1011', 'Advanced Techniques in Java', 'Learn Java at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1011.png', 1, 100, 19.99, 4, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1012', 'Exploring DevOps', 'Learn DevOps at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1012.png', 1, 100, 24.99, 4, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1013', 'The Expert Guide to SQL', 'Learn SQL at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1013.png', 1, 100, 19.99, 4, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1014', 'Introduction to SQL', 'Learn SQL at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1014.png', 1, 100, 22.99, 4, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1015', 'The Expert Guide to JavaScript', 'Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1015.png', 1, 100, 22.99, 4, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1016', 'Exploring React.js', 'Learn React.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1016.png', 1, 100, 27.99, 4, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1017', 'Advanced Techniques in React.js', 'Learn React.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1017.png', 1, 100, 13.99, 1, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1018', 'Introduction to C#', 'Learn C# at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1018.png', 1, 100, 26.99, 2, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1019', 'Crash Course in JavaScript', 'Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1019.png', 1, 100, 13.99, 2, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1020', 'Introduction to Machine Learning', 'Learn Machine Learning at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1020.png', 1, 100, 19.99, 2, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1021', 'Become a Guru in Java', 'Learn Java at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1021.png', 1, 100, 18.99, 2, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1022', 'Introduction to Python', 'Learn Python at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1022.png', 1, 100, 26.99, 2, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1023', 'Advanced Techniques in C#', 'Learn C# at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1023.png', 1, 100, 22.99, 3, NOW());
INSERT INTO tutorial (SKU, NAME, DESCRIPTION, imageurl, ACTIVE, unitsinstock, unitprice, CATEGORY_ID,datecreated) VALUES ('BOOK-TECH-1024', 'The Expert Guide to Machine Learning', 'Learn Machine Learning at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/tutorials/books/book-luv2code-1024.png', 1, 100, 16.99, 3, NOW());
