CREATE DATABASE `db_shiro`

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

insert  into `users`(`id`,`userName`,`password`) values (1,'java1234','123456');
