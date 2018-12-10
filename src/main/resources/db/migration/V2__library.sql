CREATE TABLE `library`.`library` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `library`.`library_book_xref` (
  `id_library` INT NOT NULL,
  `id_book` INT NOT NULL,
  INDEX `fk_library_book_xref_1_idx` (`id_book` ASC) VISIBLE,
  INDEX `fk_library_book_xref_2_idx` (`id_library` ASC) VISIBLE,
  CONSTRAINT `fk_library_book_xref_1`
    FOREIGN KEY (`id_book`)
    REFERENCES `library`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_library_book_xref_2`
    FOREIGN KEY (`id_library`)
    REFERENCES `library`.`library` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
