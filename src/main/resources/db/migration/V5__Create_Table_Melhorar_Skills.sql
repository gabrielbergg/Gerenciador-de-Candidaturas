
DROP TABLE IF EXISTS `melhorar_skills`;
CREATE TABLE `melhorar_skills` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `melhorias` varchar(255) DEFAULT NULL,
  `candidatura_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgvghbfwsng975vbkdel4n9wd1` (`candidatura_id`),
  CONSTRAINT `FKgvghbfwsng975vbkdel4n9wd1` FOREIGN KEY (`candidatura_id`) REFERENCES `candidatura` (`id`)
);