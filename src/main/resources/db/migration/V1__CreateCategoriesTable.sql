CREATE TABLE `Categories` (
  `id`          VARCHAR(40) NOT NULL,
  `category`    VARCHAR(45) NOT NULL,
  `subcategory` VARCHAR(45) NOT NULL,
  `active`      BIT(1)      NOT NULL DEFAULT 1,
  `createdOn`   DATETIME    NOT NULL,
  `updatedOn`   DATETIME    NOT NULL,
  PRIMARY KEY (`id`)
);