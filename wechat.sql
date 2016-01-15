/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : wechat

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-01-15 11:17:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth`
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `authority` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of auth
-- ----------------------------
INSERT INTO `auth` VALUES ('1', 'admin', 'admin', '1');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `count` int(11) NOT NULL,
  `picUrl` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'lv', 'dsfdsfds', 'bag', '10000', '10', 'http://7xpxq6.com1.z0.glb.clouddn.com/Tulips.jpg-1', 'www.baidu.com', '2016-01-11 15:40', '1');
INSERT INTO `product` VALUES ('2', 'aaa', 'dsf', 'bag', '231', '10', 'http://7xpxq6.com1.z0.glb.clouddn.com/Tulips.jpg', 'www.baidu.com', '2016-01-11 15:56', '1');
INSERT INTO `product` VALUES ('3', 'aaa', 'dsf', 'bag', '231', '10', 'http://7xpxq6.com1.z0.glb.clouddn.com/Tulips.jpg', 'www.baidu.com', '2016-01-11 15:57', '1');
INSERT INTO `product` VALUES ('4', 'aaa', 'dsf', 'bag', '231', '10', 'http://7xpxq6.com1.z0.glb.clouddn.com/Tulips.jpg2016-01-11 15:58', 'www.baidu.com', '2016-01-11 15:58', '1');
INSERT INTO `product` VALUES ('5', 'aaa', 'dsf', 'bag', '231', '10', 'http://7xpxq6.com1.z0.glb.clouddn.com/Tulips.jpg-2016-01-11 16:00', 'www.baidu.com', '2016-01-11 16:00', '1');
INSERT INTO `product` VALUES ('6', 'aaa', 'dsfdsfds', 'bag', '10000', '10', 'http://7xpxq6.com1.z0.glb.clouddn.com/Tulips.jpg-2016-01-11 16:48', 'ds', '2016-01-11 16:48', '1');

-- ----------------------------
-- Table structure for `user_subscribe_event`
-- ----------------------------
DROP TABLE IF EXISTS `user_subscribe_event`;
CREATE TABLE `user_subscribe_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ToUserName` varchar(255) NOT NULL,
  `FromUserName` varchar(255) NOT NULL,
  `CreateTime` varchar(255) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Event` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of user_subscribe_event
-- ----------------------------
INSERT INTO `user_subscribe_event` VALUES ('1', 'wuji0619', '120948192489102', '1452503647', 'subscribe');
INSERT INTO `user_subscribe_event` VALUES ('2', 'gh_156fb851cf61', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', '1452578607', 'unsubscribe');
INSERT INTO `user_subscribe_event` VALUES ('3', 'gh_156fb851cf61', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', '1452578681', 'subscribe');

-- ----------------------------
-- Table structure for `user_text_message`
-- ----------------------------
DROP TABLE IF EXISTS `user_text_message`;
CREATE TABLE `user_text_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userOpenId` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `time` varchar(255) NOT NULL DEFAULT 'CURRENT_TIMESTAMP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of user_text_message
-- ----------------------------
INSERT INTO `user_text_message` VALUES ('1', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', '?', '1452503567');
INSERT INTO `user_text_message` VALUES ('2', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', '?', '1452503647');
INSERT INTO `user_text_message` VALUES ('3', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', '的', '1452503851');
INSERT INTO `user_text_message` VALUES ('4', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', '了', '1452662830');
INSERT INTO `user_text_message` VALUES ('5', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', 'bag', '1452662839');
INSERT INTO `user_text_message` VALUES ('6', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', 'bag', '1452662942');
INSERT INTO `user_text_message` VALUES ('7', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', 'lv', '1452662949');
INSERT INTO `user_text_message` VALUES ('8', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', '自己', '1452662957');
INSERT INTO `user_text_message` VALUES ('9', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', 'bag', '1452662974');
INSERT INTO `user_text_message` VALUES ('10', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', 'lv', '1452662985');
INSERT INTO `user_text_message` VALUES ('11', 'oLUO5jm7NHn7cMTU6HYZXI52Eavw', '你信', '1452662991');
