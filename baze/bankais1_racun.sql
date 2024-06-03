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
-- Table structure for table `racun`
--

DROP TABLE IF EXISTS `racun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `racun` (
  `IdRac` int NOT NULL AUTO_INCREMENT,
  `Stanje` decimal(10,2) NOT NULL DEFAULT '0.00',
  `DozvoljenMinus` decimal(10,2) NOT NULL,
  `DatumVremeOtvaranja` datetime NOT NULL,
  `BrojTransakcija` int NOT NULL DEFAULT '0',
  `Aktivan` varchar(2) NOT NULL DEFAULT 'da',
  `IdKomitent` int NOT NULL,
  `IdMesto` int NOT NULL,
  PRIMARY KEY (`IdRac`),
  KEY `IdKomitent_Racun_idx` (`IdKomitent`),
  KEY `IdMesto_Racun_idx` (`IdMesto`),
  CONSTRAINT `IdKomitent_Racun` FOREIGN KEY (`IdKomitent`) REFERENCES `komitent` (`IdKom`) ON UPDATE CASCADE,
  CONSTRAINT `IdMesto_Racun` FOREIGN KEY (`IdMesto`) REFERENCES `mesto` (`IdMes`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `racun`
--

LOCK TABLES `racun` WRITE;
/*!40000 ALTER TABLE `racun` DISABLE KEYS */;
INSERT INTO `racun` VALUES (1,1000.00,3000.00,'2022-07-02 20:57:20',1,'z',3,13),(2,900.00,250.00,'2022-07-02 22:23:04',4,'da',4,13),(3,0.00,300.00,'2022-07-02 22:23:21',0,'z',4,1),(4,-250.00,300.00,'2022-07-02 23:30:14',3,'da',1,2),(5,500.00,600.00,'2022-07-03 12:38:00',3,'da',4,1),(6,0.00,600.00,'2022-07-07 17:20:43',0,'da',4,12),(7,0.00,100.00,'2022-07-07 17:21:23',0,'da',4,10),(8,0.00,350.00,'2022-07-07 21:26:56',0,'z',1,16);
/*!40000 ALTER TABLE `racun` ENABLE KEYS */;
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
