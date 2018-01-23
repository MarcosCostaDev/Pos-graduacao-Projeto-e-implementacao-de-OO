-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pioopublicidade
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `anunciante`
--

LOCK TABLES `anunciante` WRITE;
/*!40000 ALTER TABLE `anunciante` DISABLE KEYS */;
INSERT INTO `anunciante` VALUES ('6c8c380d-b5d4-44b8-835b-b317b51053c2','novo anunciante tira isso aqui','0123456789','teste endereco','0123456789','2018-01-21 09:52:44','testetse'),('76258549-14c2-4ddd-85c3-ab7810ff44de','Marcos Aureliano Lima Costa','012345679','rua modesta, 120','85987752207','2018-01-21 09:50:41','fortaleza');
/*!40000 ALTER TABLE `anunciante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `anuncio`
--

LOCK TABLES `anuncio` WRITE;
/*!40000 ALTER TABLE `anuncio` DISABLE KEYS */;
INSERT INTO `anuncio` VALUES ('11639eca-befd-4268-9b08-94f43b2a7411','76258549-14c2-4ddd-85c3-ab7810ff44de','2e8a8188-8915-40cd-80e7-d956ff36019e','2018-01-21 18:10:33','2018-01-21 18:10:33'),('443c5e20-3bc0-4e8b-b11d-faf188146ee5','6c8c380d-b5d4-44b8-835b-b317b51053c2','229678bb-79f9-4bbb-ac01-7346396b0100','2018-01-21 18:10:29','2018-01-21 18:10:29');
/*!40000 ALTER TABLE `anuncio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES ('229678bb-79f9-4bbb-ac01-7346396b0100','Profissional'),('2e8a8188-8915-40cd-80e7-d956ff36019e','Cama mesa e banho'),('7a96b7be-7ea8-409b-9ce8-719583bb9d61','Casa e cozinha'),('9d3467ce-de59-4ca0-845e-e4dc283f146a','Beleza'),('ff0d19c7-3932-416c-bd7a-6a77e70f4f7d','transporte');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('280d14c1-5533-4ec0-9db7-1409be862126','novoUsuario','teste3','teste4'),('43617ae9-1549-45bf-bf02-32964be0bfa6','novoUsuario','teste3','123456'),('47324185-4735-4157-9cb2-304858f15793','teste1','teste1','123546'),('581e3a86-9126-42ad-9b1e-7f80a522bb18','teste5','teste6','123456'),('7df6d488-35c9-4d78-8268-7ba152124282','teste','teste','123456'),('87832965-dd06-4ae2-a002-6b8562f206f8','novoUsuario','teste3','teste4'),('889bca0b-ea79-47ae-bccf-0f51d6b0079b','admin','admin','123456'),('9a65e8ef-203f-4b7f-9bae-4db68afe1244','teste6','teste6','123456'),('a010cb4b-76bc-4282-91b9-2b0413bbc828','novoUsuario','teste3','teste4'),('c3baa831-47a0-4bb8-a1df-9387d71155c2','novoUsuario','teste3','123456'),('d8766aa7-0cfd-4fae-9e9b-541c5342201c','login1','teste5','123456');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-22 21:16:26
