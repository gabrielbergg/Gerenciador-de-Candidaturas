DROP TABLE IF EXISTS `melhorar_skills`;

CREATE TABLE `melhorar_skills` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `melhorias` varchar(255) DEFAULT NULL,
  `candidatura_id` bigint,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_candidatura_melhorar_skills` FOREIGN KEY (`candidatura_id`) REFERENCES `candidatura` (`id`)
);
