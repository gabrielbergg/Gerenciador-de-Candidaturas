DROP TABLE IF EXISTS `entrevista`;
CREATE TABLE `entrevista` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(255) DEFAULT NULL,
  `resposta` varchar(255) DEFAULT NULL,
  `candidatura_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmyuse8f4xpke29iv9f82lbcwq` (`candidatura_id`),
  CONSTRAINT `FKmyuse8f4xpke29iv9f82lbcwq` FOREIGN KEY (`candidatura_id`) REFERENCES `candidatura` (`id`)
);