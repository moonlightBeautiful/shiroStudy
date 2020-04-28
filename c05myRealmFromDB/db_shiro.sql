DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
insert  into `t_role`(`id`,`roleName`) values (1,'admin'),(2,'teacher');


DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `userName` varchar(20) DEFAULT NULL,
    `password` varchar(20) DEFAULT NULL,
    `roleId` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `roleId` (`roleId`),
    CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`)
);
insert  into `t_user`(`id`,`userName`,`password`,`roleId`) values (1,'java1234','123456',1),(2,'jack','123',2),(3,'marry','234',NULL),(4,'json','345',NULL);



DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(50) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `t_permission_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`)
);
insert  into `t_permission`(`id`,`permissionName`,`roleId`) values (1,'user:*',1),(2,'student:*',2);