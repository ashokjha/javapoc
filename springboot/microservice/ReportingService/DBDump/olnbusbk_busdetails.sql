-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: olnbusbk
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `busdetails`
--

DROP TABLE IF EXISTS `busdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `busdetails` (
  `busid` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `fromloc` varchar(20) NOT NULL,
  `toloc` varchar(20) NOT NULL,
  `starttime` varchar(10) NOT NULL,
  `stoptime` varchar(10) NOT NULL,
  `totalseat` varchar(2) NOT NULL,
  `fare` varchar(4) NOT NULL,
  PRIMARY KEY (`busid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busdetails`
--

LOCK TABLES `busdetails` WRITE;
/*!40000 ALTER TABLE `busdetails` DISABLE KEYS */;
INSERT INTO `busdetails` VALUES ('bs001','Picnik Travel','Mumbai','Ranchi','4:00AM','2:00PM','35','2500'),('bs002','Distance at Tips','Baroda','Pune','7 AM','14 PM','40','500'),('bs003','Picnik Travel','Mumbai','Kolkata','6AM','8AM','35','1500'),('bs004','Good Luck Travel','Kolkata','Mumbai','6:30 AM','16:30 PM','40','1500'),('bs005','Sakti Travel','Pune','Delhi','4AM','6AM','30','2000');
/*!40000 ALTER TABLE `busdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-15 14:41:44
