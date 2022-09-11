/*
Navicat MySQL Data Transfer

Source Server         : data
Source Server Version : 80030
Source Host           : localhost:3306
Source Database       : bigc_exhibition

Target Server Type    : MYSQL
Target Server Version : 80030
File Encoding         : 65001

Date: 2022-09-08 16:37:36
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`
(
    `id`         int          NOT NULL AUTO_INCREMENT,
    `strat_time` datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    `end_time`   datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    `creat_time` datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    `creater`    varchar(255) NOT NULL,
    `content`    mediumtext   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`
(
    `id`       int          NOT NULL AUTO_INCREMENT,
    `nickname` varchar(255) NOT NULL,
    `username` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin`
VALUES ('1', '老大', 'laoda', '581054937f41137eb95bd0554959b750');
INSERT INTO `admin`
VALUES ('2', '小弟', 'xiaodi', '9d5d2da596d1e597fc73746ce33d4f8c');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) NOT NULL,
    `message`     varchar(255) NOT NULL,
    `activity_id` int          NOT NULL DEFAULT '-1',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of message
-- ----------------------------
