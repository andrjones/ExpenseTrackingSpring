CREATE TABLE `Expenses` (
  `id`         VARCHAR(40)    NOT NULL,
  `categoryId` VARCHAR(40)    NOT NULL,
  `date`       DATETIME       NOT NULL,
  `amount`     DECIMAL(13, 2) NOT NULL,
  `place`      VARCHAR(100)   NULL,
  `note`       VARCHAR(255)   NULL,
  `createdOn`  DATETIME       NOT NULL,
  `updatedOn`  DATETIME       NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY fk_category(`categoryId`)
  REFERENCES `Categories` (`id`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);
