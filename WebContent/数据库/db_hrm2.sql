/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 5.5.24 : Database - db_hrm2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_hrm2` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `t_attendance_detail` */

DROP TABLE IF EXISTS `t_attendance_detail`;

CREATE TABLE `t_attendance_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` date DEFAULT NULL,
  `recordComeTime` datetime DEFAULT NULL,
  `recordLeaveTime` datetime DEFAULT NULL,
  `reportComeTime` datetime DEFAULT NULL,
  `reportLeaveTime` datetime DEFAULT NULL,
  `isAnnualLeave` tinyint(4) DEFAULT NULL,
  `isSickLeave` tinyint(4) DEFAULT NULL,
  `isAPersonalLeave` tinyint(4) DEFAULT NULL,
  `empId` int(11) DEFAULT NULL,
  `adState` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_attendance_detail` */

insert  into `t_attendance_detail`(`id`,`day`,`recordComeTime`,`recordLeaveTime`,`reportComeTime`,`reportLeaveTime`,`isAnnualLeave`,`isSickLeave`,`isAPersonalLeave`,`empId`,`adState`) values (1,'2017-04-01','2017-04-01 07:50:12','2017-04-01 17:10:13',NULL,NULL,NULL,NULL,NULL,2,1),(2,'2017-04-02','2017-04-02 08:20:45','2017-04-02 17:05:14',NULL,NULL,NULL,NULL,NULL,2,1),(3,'2017-04-03','2017-04-03 07:45:15','2017-04-03 16:35:14',NULL,NULL,NULL,NULL,NULL,2,1),(4,'2017-04-04',NULL,'2017-04-04 17:05:14',NULL,NULL,NULL,NULL,NULL,2,0),(5,'2017-04-05','2017-04-04 07:56:12',NULL,NULL,NULL,NULL,NULL,NULL,2,0),(6,'2017-04-06',NULL,NULL,NULL,NULL,8,NULL,NULL,2,0),(7,'2017-04-07',NULL,NULL,NULL,NULL,NULL,8,NULL,2,0),(8,'2017-04-08',NULL,NULL,NULL,NULL,NULL,NULL,8,2,1),(9,'2017-04-09',NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,1),(10,'2017-04-10','2017-04-10 07:45:15','2017-04-10 17:10:13',NULL,NULL,NULL,NULL,NULL,2,1),(11,'2017-04-11','2017-04-11 07:45:15','2017-04-11 17:10:13',NULL,NULL,NULL,NULL,NULL,2,1),(12,'2017-04-12','2017-04-12 07:45:15','2017-04-12 17:10:13',NULL,NULL,NULL,NULL,NULL,2,1),(13,'2017-04-13','2017-04-13 07:45:15','2017-04-13 17:10:13',NULL,NULL,NULL,NULL,NULL,2,1),(14,'2017-04-14','2017-04-14 07:45:15','2017-04-14 17:10:13',NULL,NULL,NULL,NULL,NULL,2,1),(15,'2017-04-15','2017-04-15 07:45:15',NULL,NULL,NULL,NULL,NULL,NULL,2,1);

/*Table structure for table `t_contract` */

DROP TABLE IF EXISTS `t_contract`;

CREATE TABLE `t_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `idcard` varchar(20) DEFAULT NULL,
  `contractLength` int(11) DEFAULT NULL,
  `interviewer` varchar(20) DEFAULT NULL,
  `isOk` int(11) DEFAULT NULL,
  `missReason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_contract` */

insert  into `t_contract`(`id`,`name`,`sex`,`idcard`,`contractLength`,`interviewer`,`isOk`,`missReason`) values (1,'周友卉','女','430981199101089322',3,'杜拉拉',1,'OK'),(2,'元正光','男','430202198206153599',0,'杜拉拉',-1,'专业技能不足'),(3,'倪荣胜','男','370683199203263512',0,'夏小沫',-1,'形象不符'),(4,'谷恒浩','男','441521198709266710',0,'夏小沫',0,''),(5,'毕夏瑶','女','350723199304195788',0,'杜拉拉',0,'');

/*Table structure for table `t_datadic` */

DROP TABLE IF EXISTS `t_datadic`;

CREATE TABLE `t_datadic` (
  `ddId` int(11) NOT NULL AUTO_INCREMENT,
  `ddTypeId` int(11) DEFAULT NULL,
  `ddValue` varchar(20) DEFAULT NULL,
  `ddDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ddId`),
  KEY `FK_t_datadic` (`ddTypeId`),
  CONSTRAINT `FK_t_datadic` FOREIGN KEY (`ddTypeId`) REFERENCES `t_datadictype` (`ddTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=373 DEFAULT CHARSET=utf8;

/*Data for the table `t_datadic` */

insert  into `t_datadic`(`ddId`,`ddTypeId`,`ddValue`,`ddDesc`) values (1,1,'男','1'),(2,1,'女',NULL),(3,2,'中共党员',NULL),(4,2,'中共预备党员',NULL),(5,2,'共青团员',NULL),(6,2,'民革党员',NULL),(7,2,'民盟盟员',NULL),(8,2,'民建会员',NULL),(9,2,'民进会员',NULL),(10,2,'农工党党员',NULL),(11,2,'致公党党员',NULL),(12,2,'九三学社社员',NULL),(13,2,'台盟盟员',NULL),(14,2,'无党派人士',NULL),(15,2,'普通公民',NULL),(16,2,'港澳同胞',NULL),(17,2,'叛徒',NULL),(18,2,'反革命分子',NULL),(334,3,'汉族',NULL),(335,3,'蒙古族',NULL),(336,3,'回族',NULL),(337,3,'藏族',NULL),(338,3,'维吾尔族',NULL),(339,3,'门巴族',NULL),(340,3,'外国血统',NULL),(342,3,'鬼族','11'),(345,10,'学士','学士'),(346,10,'硕士','硕士'),(347,10,'博士','博士'),(348,9,'研究生毕业','研究生...'),(349,9,'研究生肄业','研究生...'),(350,9,'大学毕业','大学本科...'),(351,9,'相当大学毕业','大学本科...'),(352,9,'大学肄业','大学本科...'),(353,9,'专科毕业','大专和专科学校...'),(354,9,'相当专科毕业','大专和专科学校...'),(355,9,'专科肄业','大专和专科学校...'),(356,9,'中专毕业','中专和中技...'),(357,9,'中技毕业','中专和中技...'),(358,9,'相当中专/中技毕业','中专和中技...'),(359,9,'中专/中技肄业','中专和中技...'),(360,9,'技校毕业','技工学校...'),(361,9,'技校肄业','技工学校...'),(362,9,'高中毕业','高中...'),(363,9,'职高毕业','高中...'),(364,9,'相当高中毕业','高中...'),(365,9,'高中肄业','高中...'),(366,9,'初中毕业','初中...'),(367,9,'相当初中毕业','初中...'),(368,9,'初中肄业','初中...'),(369,9,'小学毕业','小学...'),(370,9,'相当小学毕业','小学...'),(371,9,'小学肄业','小学...'),(372,9,'文盲或半文盲','文盲或半文盲');

/*Table structure for table `t_datadictype` */

DROP TABLE IF EXISTS `t_datadictype`;

CREATE TABLE `t_datadictype` (
  `ddTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `ddTypeName` varchar(20) DEFAULT NULL,
  `ddTypeDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ddTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_datadictype` */

insert  into `t_datadictype`(`ddTypeId`,`ddTypeName`,`ddTypeDesc`) values (1,'性别','男-女'),(2,'政治面貌',NULL),(3,'民族',NULL),(7,'资位','试用员-员-师'),(8,'职位','职位'),(9,'学历','学习经历'),(10,'学位','');

/*Table structure for table `t_dept` */

DROP TABLE IF EXISTS `t_dept`;

CREATE TABLE `t_dept` (
  `deptId` int(11) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_dept` */

insert  into `t_dept`(`deptId`,`deptName`) values (3,'财务部'),(4,'人资部'),(5,'宣传部'),(6,'企划部'),(7,'研发中心'),(10,'安全部');

/*Table structure for table `t_employee` */

DROP TABLE IF EXISTS `t_employee`;

CREATE TABLE `t_employee` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `employeeNo` varchar(20) DEFAULT NULL,
  `empName` varchar(20) DEFAULT NULL,
  `empSex` varchar(10) DEFAULT NULL,
  `empIdcard` varchar(20) DEFAULT NULL,
  `empNation` varchar(20) DEFAULT NULL,
  `empZzmm` varchar(20) DEFAULT NULL,
  `empRecord` varchar(20) DEFAULT NULL,
  `empDegree` varchar(20) DEFAULT NULL,
  `school` varchar(100) DEFAULT NULL,
  `empPic` varchar(20) DEFAULT NULL,
  `deptId` int(11) DEFAULT NULL,
  `major` varchar(100) DEFAULT NULL,
  `empDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `uk_employeeNo` (`employeeNo`),
  KEY `FK_t_student` (`deptId`),
  CONSTRAINT `t_employee_ibfk_1` FOREIGN KEY (`deptId`) REFERENCES `t_dept` (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_employee` */

insert  into `t_employee`(`employeeId`,`employeeNo`,`empName`,`empSex`,`empIdcard`,`empNation`,`empZzmm`,`empRecord`,`empDegree`,`school`,`empPic`,`deptId`,`major`,`empDesc`) values (2,'170002','测试员工','男','370306199901011001','蒙古族','民革党员','大学毕业','学士','测试2','nophoto.jpg',5,'测试2','测试2'),(4,'170004','212','男','370306199901011001','蒙古族','中共预备党员',NULL,NULL,NULL,'nophoto.jpg',4,NULL,'21'),(6,'170006','陈宝','男','370306199901011001','蒙古族',NULL,NULL,NULL,NULL,'chenbao.jpg',4,NULL,NULL),(7,'170007','11','男','370306199901011001','汉族','中共党员',NULL,NULL,NULL,'nophoto.jpg',4,NULL,'测试图片'),(8,'170008','21','女','370306199901011001','汉族','中共党员',NULL,NULL,NULL,'nophoto.jpg',5,NULL,'是'),(9,'170009','王宗达',NULL,'370306199901011001',NULL,NULL,NULL,NULL,NULL,'wangzongda.jpg',4,NULL,NULL),(10,'170010','王鲁悦',NULL,'370306199901011001',NULL,NULL,NULL,NULL,NULL,'wangluyue.jpg',4,NULL,NULL),(11,'170011','田志超',NULL,'370306199901011001',NULL,NULL,NULL,NULL,NULL,'tianzhichao.jpg',4,NULL,NULL),(12,'170012','齐双',NULL,'370306199901011001',NULL,NULL,NULL,NULL,NULL,'qishuang.jpg',4,NULL,NULL),(13,'170013','程彦瑞',NULL,'370306199901011001',NULL,NULL,NULL,NULL,NULL,'chengyanrui.jpg',4,NULL,NULL),(14,'170014','Allen','男','370306199901011001','回族','共青团员',NULL,NULL,NULL,'nophoto.jpg',5,NULL,'美女12222222'),(19,'170015','张凯','男','22','蒙古族','普通公民','相当高中毕业','博士','22','zhangkai.jpg',4,'22','22'),(20,'170016','谢黎明','女','370306','汉族','共青团员','相当专科毕业','学士','清华大学','xieliming.jpg',3,'电气','学生');

/*Table structure for table `t_recruit` */

DROP TABLE IF EXISTS `t_recruit`;

CREATE TABLE `t_recruit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `idcard` varchar(20) DEFAULT NULL,
  `recruitFrom` varchar(20) DEFAULT NULL,
  `healthyState` int(11) DEFAULT '0',
  `idcardState` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_recruit` */

insert  into `t_recruit`(`id`,`name`,`sex`,`idcard`,`recruitFrom`,`healthyState`,`idcardState`) values (5,'贺兰芳','女','420106199406229802','58同城',1,1),(6,'辛恒浩','男','130981198403034452','智联招聘',1,0),(7,'米灵松','女','61030019920927854X','智联招聘',0,0);

/*Table structure for table `t_salary` */

DROP TABLE IF EXISTS `t_salary`;

CREATE TABLE `t_salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hoursOfG1` decimal(10,2) DEFAULT NULL,
  `hoursOfG2` decimal(10,2) DEFAULT NULL,
  `hoursOfG3` decimal(10,2) DEFAULT NULL,
  `hoursOfG4` decimal(10,2) DEFAULT NULL,
  `hoursOfAnnualLeave` decimal(10,2) DEFAULT NULL,
  `hoursOfSickLeave` decimal(10,2) DEFAULT NULL,
  `hoursOfPersonalLeave` decimal(10,2) DEFAULT NULL,
  `absenteeism` decimal(10,2) DEFAULT NULL,
  `monthlyPay` decimal(10,2) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `employeeNo` varchar(20) DEFAULT NULL,
  `empName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_salary` */

insert  into `t_salary`(`id`,`hoursOfG1`,`hoursOfG2`,`hoursOfG3`,`hoursOfG4`,`hoursOfAnnualLeave`,`hoursOfSickLeave`,`hoursOfPersonalLeave`,`absenteeism`,`monthlyPay`,`month`,`employeeNo`,`empName`) values (1,'32.00','10.00','8.00','0.00','8.00','0.00','0.00','0.00',NULL,4,'170002','测试员工');

/*Table structure for table `t_train` */

DROP TABLE IF EXISTS `t_train`;

CREATE TABLE `t_train` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `joinTime` date DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `empName` varchar(20) DEFAULT NULL,
  `isOk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_train` */

insert  into `t_train`(`id`,`name`,`joinTime`,`content`,`empName`,`isOk`) values (1,'礼仪培训','2017-04-04','礼仪规范','王宗达',1),(2,'消防安全培训','2017-04-10','防火灭火','田志超',1),(7,'334','2017-04-15','334','334',NULL);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `trueName` varchar(20) DEFAULT NULL,
  `role` int(11) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`userId`,`userName`,`password`,`trueName`,`role`) values (1,'web','123','King',-1),(2,'Allen','123','Allen',0),(3,'Smith','123','Smith',0),(4,'杜拉拉','123','杜拉拉',1),(5,'夏小沫','123','夏小沫',1),(6,'拉克丝','123','拉克丝',2),(7,'盲僧','123','盲僧',3),(9,'222','222','222',0),(10,'333','333','33',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
