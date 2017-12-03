/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : biz

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-09-04 16:17:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `id` varchar(255) NOT NULL,
  `version` bigint(20) NOT NULL,
  `enable_flag` int(11) NOT NULL,
  `item_order` int(11) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `code` varchar(10) NOT NULL,
  `last_updated` datetime NOT NULL,
  `name` varchar(50) NOT NULL,
  `extention` varchar(1000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'qwe');
