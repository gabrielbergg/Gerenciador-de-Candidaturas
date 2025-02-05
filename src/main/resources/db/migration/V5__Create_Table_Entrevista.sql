DROP TABLE IF EXISTS `entrevista`;

CREATE TABLE `entrevista` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(255) DEFAULT NULL,
  `resposta` varchar(255) DEFAULT NULL,
  `candidatura_id` bigint,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_candidatura_entrevista` FOREIGN KEY (`candidatura_id`) REFERENCES `candidatura` (`id`)
);
