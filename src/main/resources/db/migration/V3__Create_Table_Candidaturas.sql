DROP TABLE IF EXISTS `candidatura`;

CREATE TABLE `candidatura` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `titulo_vaga` varchar(255) DEFAULT NULL,
  `nome_empresa` varchar(255) DEFAULT NULL,
  `requisitos_vaga` varchar(255) DEFAULT NULL,
  `local_candidatura` varchar(255) DEFAULT NULL,
  `descricao_vaga` varchar(255) DEFAULT NULL,
  `data_candidatura` date DEFAULT NULL,
  `status_candidatura` enum('AGUARDANDO_RESPOSTA', 'SEM_RESPOSTA', 'RESPOSTA_POSITIVA', 'RESPOSTA_NEGATIVA') DEFAULT NULL,
  `userLogin_id` bigint,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_login_id` FOREIGN KEY (`userLogin_id`) REFERENCES `users` (`id`)
);

