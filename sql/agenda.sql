DROP SCHEMA IF EXISTS `agenda` ;
CREATE SCHEMA IF NOT EXISTS `agenda` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `agenda` ;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;


-- -----------------------------------------------------
-- Table `agenda`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agenda`.`persona` (
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(150) NULL DEFAULT NULL,
  `apellido1` VARCHAR(150) NULL DEFAULT NULL,
  `apellido2` VARCHAR(150) NULL DEFAULT NULL,
  `edad` INT(3),
  PRIMARY KEY (`dni`)
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `agenda`.`telefono`persona
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agenda`.`telefono` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NOT NULL,
  `telefono` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_telefono_persona` FOREIGN KEY (`dni`) REFERENCES `agenda`.`persona` (`dni`)
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `agenda`.`email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agenda`.`email` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_email_persona` FOREIGN KEY (`dni`) REFERENCES `agenda`.`persona` (`dni`)
)ENGINE = InnoDB;

INSERT INTO `persona` (`dni`, `nombre`, `apellido1`, `apellido2`, `edad`) VALUES
('00000000A','Airam','Brito','Triana',10),
('11111111A','Brian','Escobar','Rubio',20),
('22222222A','Adrian','Ferradas','Gutierrez',30),
('33333333A','Miguel Angel','Fuente','Rosado',40),
('44444444A','Aitor','Gallastegui','Borreguero',50),
('55555555A','Irune','Guinea','Zufiaurre',20),
('66666666A','Alejandro','Lopez de Guereñu','Macazaga',20),
('77777777A','Alayn','Marcos','Vacas',30),
('88888888A','Emma','Velez','Garcia',40);


INSERT INTO `email` (`dni`,`email`) VALUES
('00000000A','airam@dm2.com'),
('11111111A','brian@dm2.com'),
('22222222A','adrian@dm2.com'),
('33333333A','miguelangel@dm2.com'),
('33333333A','miguelangel1@dm2.com'),
('55555555A','irune@dm2.com'),
('66666666A','alejandro@dm2.com'),
('77777777A','alayn@dm2.com'),
('88888888A','emma@dm2.com'),
('00000000A','brito@dm2.com'),
('11111111A','escobar@dm2.com'),
('22222222A','geradas@dm2.com'),
('33333333A','fuente@dm2.com'),
('55555555A','irune1@dm2.com'),
('55555555A','guinea@dm2.com'),
('66666666A','lopezdeguereñu@dm2.com'),
('77777777A','marcos@dm2.com'),
('88888888A','velez@dm2.com'),
('88888888A','garcia@dm2.com'),
('88888888A','emma1@dm2.com'),
('88888888A','emma2@dm2.com');

INSERT INTO `telefono` (`dni`,`telefono`) VALUES
('77777777A','111111111'),
('11111111A','111111112'),
('22222222A','111111113'),
('33333333A','111111114'),
('44444444A','111111115'),
('55555555A','111111116'),
('66666666A','111111117'),
('77777777A','111111118'),
('88888888A','111111119'),
('66666666A','222333442'),
('11111111A','222333443'),
('22222222A','222333444'),
('33333333A','222333445'),
('55555555A','222333446'),
('55555555A','222333447'),
('66666666A','222333448'),
('77777777A','222333449'),
('88888888A','555666771'),
('88888888A','555666772'),
('88888888A','555666773'),
('88888888A','555666774');

COMMIT;