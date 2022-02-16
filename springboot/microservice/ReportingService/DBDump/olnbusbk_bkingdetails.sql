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
-- Table structure for table `bkingdetails`
--

DROP TABLE IF EXISTS `bkingdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bkingdetails` (
  `passid` varchar(6) NOT NULL,
  `busid` varchar(5) NOT NULL,
  `passname` varchar(20) NOT NULL,
  `seatno` varchar(3) NOT NULL,
  `mobileno` varchar(13) NOT NULL,
  `dateofjourney` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`passid`),
  KEY `busid` (`busid`),
  CONSTRAINT `bkingdetails_ibfk_1` FOREIGN KEY (`busid`) REFERENCES `busdetails` (`busid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bkingdetails`
--

LOCK TABLES `bkingdetails` WRITE;
/*!40000 ALTER TABLE `bkingdetails` DISABLE KEYS */;
INSERT INTO `bkingdetails` VALUES ('p0001','bs001','Abhirup Das','6','1234000034','2022-01-28','CANCELED'),('p0002','bs002','Raju Raj','9','244253636','2022-01-05','CANCELED'),('p0003','bs004','Shriyans Bhawmik','5','1284000034','2022-01-04','CONFIRMED'),('p0004','bs002','Raju Day','10','1234002000','2022-01-07','CANCELED'),('p0005','bs005','Ramu Ganguli','5','432235556','2022-01-06','CONFIRMED'),('p0006','bs001','Ved Patel','10','1000230011','2022-01-28','CONFIRMED');
/*!40000 ALTER TABLE `bkingdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-15 14:41:45
