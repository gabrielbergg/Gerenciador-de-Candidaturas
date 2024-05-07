
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `login` varchar(255) UNIQUE KEY NOT NULL,
  `password` varchar(255) NOT NULL,
  `roles` enum('USER','VISITOR') NOT NULL
);