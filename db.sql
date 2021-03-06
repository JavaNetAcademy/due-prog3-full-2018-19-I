-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: thejumper203.ddns.net    Database: hoe
-- ------------------------------------------------------
-- Server version	5.7.20-log
--
--  heroClass
--

use hoe;
DROP TABLE IF EXISTS `heroClass`;
CREATE TABLE `heroClass` (
  `name` varchar(100) NOT NULL,
  `description` varchar(150) NOT NULL DEFAULT '',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
--- feltöltés
INSERT INTO `heroClass` VALUES 
('Warrior','A strong fighter who engages in close combat.'),
('Paladin','A holy warrior who uses the light as his/her weapon.'),
('Hunter','A ranged class who trains pets.'),
('Mage','Powerful sorcerer who uses powerful spells to defeat his/her foes.');

--
-- Table structure for table `empire`
--
create database hoe;
use hoe;
DROP TABLE IF EXISTS `empire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empire` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL DEFAULT '',
  `description` varchar(150) NOT NULL DEFAULT '',
  `level` int(10) unsigned NOT NULL DEFAULT '0',
  `userid` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_empire_1` (`userid`),
  CONSTRAINT `FK_empire_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empire`
--

LOCK TABLES `empire` WRITE;
/*!40000 ALTER TABLE `empire` DISABLE KEYS */;
INSERT INTO `empire` VALUES (1,'Birodalom1','elso birodalom',3,1),(2,'Birodalom2','m├ísodik birodalom',4,2),(3,'Birodalom3','harmadik birodalom :) :) :)',13,1);
/*!40000 ALTER TABLE `empire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hero`
--

DROP TABLE IF EXISTS `hero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hero` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL DEFAULT '',
  `description` varchar(150) NOT NULL DEFAULT '',
  `userid` int(10) unsigned NOT NULL DEFAULT '0',
  `classid` varchar(100) NOT NULL DEFAULT 'Warrior',
  PRIMARY KEY (`id`),
  KEY `FK_hero_1` (`userid`),
  CONSTRAINT `FK_hero_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  KEY `FK_heroclass_1` (`classid`),
  CONSTRAINT `FK_heroclass_1` FOREIGN KEY (`classid`) REFERENCES `heroClass` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hero`
--

LOCK TABLES `hero` WRITE;
/*!40000 ALTER TABLE `hero` DISABLE KEYS */;
INSERT INTO `hero` VALUES (1,'hos1','első hős',1,'Hunter'),(2,'jóska','masikhos',2,'Paladin'),(3,'hos3','majdnem admin op',1,'Warrior'),(4,'xXxDaKrneSsxXx','Boring gamer',1,'Hunter'),(5,'Brang','Hunter mate',2,'Hunter');
/*!40000 ALTER TABLE `hero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `description` varchar(150) NOT NULL DEFAULT '',
  `empid` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_location_1` (`empid`),
  CONSTRAINT `FK_location_1` FOREIGN KEY (`empid`) REFERENCES `empire` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'falu1','kis falu',1),(2,'v├íros1','kisv├íros',1),(3,'falu3','nagyobbfalu',1),(4,'v├íros2','nagyobb v├íros',1),(5,'city1','nagyon nagy v├â┬íros',1);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','user'),(2,'asdasd','asdasd');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

--
-- spellek cuccok enyém
--

use hoe;
DROP TABLE IF EXISTS `spell`;
CREATE TABLE `spell` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `classid` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `description` varchar(150) NOT NULL DEFAULT '',
  `attpower` int(10) unsigned NOT NULL DEFAULT '0',
  `deffpower` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);
--- feltöltés
INSERT INTO `spell` VALUES 
(1,'Warrior','Mortal Strike','A vicious blow.',5,1),
(2,'Warrior','Raging blow','A vicious blow very much.',50,1),
(3,'Mage','Pyroblast','Strong magical spell.',20,0),
(4,'Mage','Ice Block','Strong magical defense spell.',0,100),
(5,'Hunter','Track','A hunting ability outside the wild.',10,10);

--
-- Table structure for table `mobs`
--
DROP TABLE IF EXISTS `mobs`;
CREATE TABLE `mobs` (
`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
`name` varchar(100) NOT NULL DEFAULT '',
`lvl` int(10) unsigned NOT NULL DEFAULT '0',
`attackpoints` int(10) unsigned NOT NULL DEFAULT '0',
`defensepoints` int(10) unsigned NOT NULL DEFAULT '0',
`posx` double NOT NULL DEFAULT '0',
`posy` double NOT NULL DEFAULT '0',
PRIMARY KEY (`id`)) DEFAULT CHARSET=utf8;

-- Dump completed on 2018-11-01 18:24:00
--
--  hero status
--

use hoe;
DROP TABLE IF EXISTS `heroStatus`;
CREATE TABLE `heroStatus` (
  `heroid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `health` int(10) unsigned NOT NULL DEFAULT '100',
  `mana` int(10) unsigned NOT NULL DEFAULT '100',
  `level` int(10) unsigned NOT NULL DEFAULT '1',
  `experience` int(10) unsigned NOT NULL DEFAULT '0',
  `intellect` int(10) unsigned NOT NULL DEFAULT '5',
  `strength` int(10) unsigned NOT NULL DEFAULT '5',
  `agility` int(10) unsigned NOT NULL DEFAULT '5',
  PRIMARY KEY (`heroid`),
  KEY `FK_location_1` (`heroid`),
  CONSTRAINT `FK_herostatus_1` FOREIGN KEY (`heroid`) REFERENCES `hero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
--- feltöltés
INSERT INTO `heroStatus` VALUES 
(1,100,100,2,25,10,4,8),
(2,500,100,5,15,6,5,6),
(3,100,250,8,20,4,5,5),
(4,100,110,1,50,15,5,3),
(5,100,115,3,25,6,5,7);

-- Dump completed on 2018-11-01 18:24:00
