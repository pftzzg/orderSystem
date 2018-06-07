/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.201
Source Server Version : 50615
Source Host           : 192.168.0.201:3306
Source Database       : wutong_order

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2018-06-04 10:31:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(100) DEFAULT NULL,
  `real_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
