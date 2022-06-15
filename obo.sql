-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.8.3-MariaDB-1:10.8.3+maria~jammy - mariadb.org binary distribution
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for ems
DROP DATABASE IF EXISTS `ems`;
CREATE DATABASE IF NOT EXISTS `ems` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `ems`;

-- Dumping structure for table ems.advance
DROP TABLE IF EXISTS `advance`;
CREATE TABLE IF NOT EXISTS `advance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_time` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ems.advance: ~4 rows (approximately)
/*!40000 ALTER TABLE `advance` DISABLE KEYS */;
INSERT INTO `advance` (`id`, `date_time`, `employee_id`, `money`) VALUES
	(6, '2022-6-14', 44, 10),
	(7, '2022-06-14 09:03:03.229', 1, 20000),
	(8, '2022-06-14 07:00:00.000', 1, 20000),
	(9, '2023-02-14 07:00:00.000', 1, 20000),
	(10, '2022-01-14 07:00:00.000', 1, 20000);
/*!40000 ALTER TABLE `advance` ENABLE KEYS */;

-- Dumping structure for table ems.employees
DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `money_per_hour` double DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `team_team_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKpnuosnqvbbxlnpn10i9vtcs1d` (`team_team_id`),
  CONSTRAINT `FKpnuosnqvbbxlnpn10i9vtcs1d` FOREIGN KEY (`team_team_id`) REFERENCES `teams` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ems.employees: ~2 rows (approximately)
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`employee_id`, `address`, `age`, `full_name`, `money_per_hour`, `position`, `sex`, `team_team_id`) VALUES
	(10, 'Vinh Long', 20, 'Huynh Huu Nhan', 150000, 'Enginer', 'Male', 4),
	(11, 'Long An', 30, 'Huynh loc phu', 300000, 'Designer', 'Male', 1);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;

-- Dumping structure for table ems.statistics
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE IF NOT EXISTS `statistics` (
  `no_of_employee` int(11) NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL,
  PRIMARY KEY (`no_of_employee`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ems.statistics: ~10 rows (approximately)
/*!40000 ALTER TABLE `statistics` DISABLE KEYS */;
INSERT INTO `statistics` (`no_of_employee`, `money`) VALUES
	(1, 1200000),
	(2, 96900000),
	(3, 0),
	(4, 0),
	(5, 60),
	(6, 0),
	(7, 0),
	(8, 0),
	(9, 0),
	(10, 1650000),
	(11, 2400000);
/*!40000 ALTER TABLE `statistics` ENABLE KEYS */;

-- Dumping structure for table ems.teams
DROP TABLE IF EXISTS `teams`;
CREATE TABLE IF NOT EXISTS `teams` (
  `team_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ems.teams: ~4 rows (approximately)
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` (`team_id`, `name`) VALUES
	(1, 'QA'),
	(2, 'Dev'),
	(3, 'BA'),
	(4, 'E2C');
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;

-- Dumping structure for table ems.working
DROP TABLE IF EXISTS `working`;
CREATE TABLE IF NOT EXISTS `working` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_time` datetime DEFAULT NULL,
  `employee_id` bigint(20) NOT NULL,
  `number_hour` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table ems.working: ~4 rows (approximately)
/*!40000 ALTER TABLE `working` DISABLE KEYS */;
INSERT INTO `working` (`id`, `date_time`, `employee_id`, `number_hour`) VALUES
	(6, '2022-06-10 07:00:00', 10, 5),
	(7, '2022-06-09 07:00:00', 10, 6),
	(8, '2022-06-09 07:00:00', 11, 4),
	(9, '2022-06-10 07:00:00', 11, 4);
/*!40000 ALTER TABLE `working` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
