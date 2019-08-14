/*
Navicat MySQL Data Transfer

Source Server         : mydell
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : zsdemo

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-08-13 19:30:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Cno` char(10) NOT NULL,
  `Cname` char(20) NOT NULL,
  `Credit` int(11) DEFAULT NULL,
  `Semester` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('C001', '高等数学', '4', '1');
INSERT INTO `course` VALUES ('C002', '大学英语', '3', '1');
INSERT INTO `course` VALUES ('C003', '大学英语', '3', '2');
INSERT INTO `course` VALUES ('C004', '计算机文化学', '2', '2');
INSERT INTO `course` VALUES ('C005', 'Java', '2', '3');
INSERT INTO `course` VALUES ('C006', '数据库基础', '4', '5');
INSERT INTO `course` VALUES ('C007', '数据结构', '4', '4');
INSERT INTO `course` VALUES ('c008', '来跨服呢', '4', '5');

-- ----------------------------
-- Table structure for t1
-- ----------------------------
DROP TABLE IF EXISTS `t1`;
CREATE TABLE `t1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t1
-- ----------------------------
INSERT INTO `t1` VALUES ('1', '60');

-- ----------------------------
-- Table structure for z_user
-- ----------------------------
DROP TABLE IF EXISTS `z_user`;
CREATE TABLE `z_user` (
  `user` varchar(255) NOT NULL,
  `passwork` varchar(255) NOT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_user
-- ----------------------------
INSERT INTO `z_user` VALUES ('asd', '123');
