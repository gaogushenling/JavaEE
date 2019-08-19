/*
Navicat MySQL Data Transfer

Source Server         : mydell
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : sell

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-08-19 18:41:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_order
-- ----------------------------
DROP TABLE IF EXISTS `s_order`;
CREATE TABLE `s_order` (
  `order_id` varchar(255) NOT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_order
-- ----------------------------
INSERT INTO `s_order` VALUES ('22', '22', '22', '2019-08-19 15:08:14', '2019-08-19 15:08:14');
INSERT INTO `s_order` VALUES ('4461d5c3618e474f89149e523e9eb840585785', '77', '77', '2019-08-19 15:27:00', '2019-08-19 15:27:00');
INSERT INTO `s_order` VALUES ('b18f34be7b0c414eac760bf907847904987912', '77', '77', null, null);

-- ----------------------------
-- Table structure for s_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `s_order_detail`;
CREATE TABLE `s_order_detail` (
  `detail_id` varchar(255) NOT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `order_id` (`order_id`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_order_detail
-- ----------------------------
INSERT INTO `s_order_detail` VALUES ('22', '22', '55', '22');
