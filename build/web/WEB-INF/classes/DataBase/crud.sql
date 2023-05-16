/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : crud

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2023-05-16 16:26:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for docentes
-- ----------------------------
DROP TABLE IF EXISTS `docentes`;
CREATE TABLE `docentes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(30) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `blog` varchar(100) NOT NULL,
  `profesional` varchar(100) NOT NULL,
  `escalafon` varchar(3) NOT NULL,
  `idioma` varchar(50) NOT NULL,
  `añosExperiencia` varchar(3) NOT NULL,
  `areaTrabajo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of docentes
-- ----------------------------
INSERT INTO `docentes` VALUES ('6', '12345', 'GLEVYS ', 'Lopez ', 'yurian0000@hotmail.com', '3014567433', '@glevys', 'contdora', '3', 'Inglés', '6', 'FDF');
INSERT INTO `docentes` VALUES ('7', '123456', 'MAria José', 'Aparicio', 'maria@unicartagena.edu.co', '3014567433', '@majo', 'Direcccion', '45', 'Patúa', '2', 'Admisones');
INSERT INTO `docentes` VALUES ('8', '1234', 'RAYNER ', 'MORALES ', 'chechy2310@hotmail.com', '3014567433', 'rwaxcfg', 'lic en informatica ', '3', 'Ingles', '6', 'Admisones');

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `genero` varchar(1) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES ('10', 'arrieta', '123', 'jhon', 'Arrieta', 'M', 'chechy2310@hotmail.com');
INSERT INTO `usuarios` VALUES ('12', 'margarita', '123', 'Helen ', 'Lopez ', 'F', 'hellemalosa@hotmail.com');
