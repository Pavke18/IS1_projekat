-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: bankais1
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `transakcija`
--

DROP TABLE IF EXISTS `transakcija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transakcija` (
  `IdTran` int NOT NULL AUTO_INCREMENT,
  `DatumVremeObavljanja` datetime NOT NULL,
  `Iznos` decimal(10,2) NOT NULL,
  `RedniBr` int NOT NULL,
  `Vrsta` int NOT NULL,
  `Svrha` varchar(45) NOT NULL,
  `IdRacunNa` int DEFAULT NULL,
  `IdRacunSa` int DEFAULT NULL,
  `IdFilijala` int DEFAULT NULL,
  PRIMARY KEY (`IdTran`),
  KEY `IdRacun_Transakcija_idx` (`IdRacunSa`),
  KEY `IdFilijala_Transakcija_idx` (`IdFilijala`),
  KEY `IdRacun_Transakcija_idx1` (`IdRacunNa`),
  CONSTRAINT `IdFilijala_Transakcija` FOREIGN KEY (`IdFilijala`) REFERENCES `filijala` (`IdFil`) ON UPDATE CASCADE,
  CONSTRAINT `IdRacunNa_Transakcija` FOREIGN KEY (`IdRacunNa`) REFERENCES `racun` (`IdRac`),
  CONSTRAINT `IdRacunSa_Transakcija` FOREIGN KEY (`IdRacunSa`) REFERENCES `racun` (`IdRac`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transakcija`
--

LOCK TABLES `transakcija` WRITE;
/*!40000 ALTER TABLE `transakcija` DISABLE KEYS */;
INSERT INTO `transakcija` VALUES (1,'2022-07-04 20:11:50',500.00,1,2,'prijava ispita',5,NULL,5),(2,'2022-07-04 20:18:20',1000.00,1,2,'ponistavanje ocene',1,NULL,3),(3,'2022-07-04 20:51:32',1000.00,2,2,'poklon',5,NULL,3),(4,'2022-07-04 21:00:23',200.00,1,3,'poklon za rodjendan',NULL,2,1),(5,'2022-07-04 21:01:47',100.00,2,3,'troskovi',NULL,2,5),(6,'2022-07-04 21:06:42',500.00,1,3,'racun za telefon',NULL,4,2),(7,'2022-07-04 21:07:52',200.00,2,2,'povracaj novca',4,NULL,4),(8,'2022-07-04 21:09:22',50.00,3,2,'dodatak',4,NULL,5),(9,'2022-07-04 22:57:51',1000.00,1,1,'donacija',2,5,NULL),(10,'2022-07-07 22:10:05',200.00,4,2,'uplata',2,NULL,6);
/*!40000 ALTER TABLE `transakcija` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-07 22:38:10
