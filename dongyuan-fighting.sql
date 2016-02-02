/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : dongyuan-fighting

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2016-02-02 08:56:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长id',
  `type` int(4) NOT NULL COMMENT '标识广告的类型',
  `location` int(64) NOT NULL COMMENT '方位，这个后期自定义，用字符串如“left"更直观，就不用数字表示了',
  `path` varchar(255) DEFAULT NULL,
  `uri` varchar(256) NOT NULL COMMENT '文件uri地址',
  `enabled` bit(1) DEFAULT b'1' COMMENT '状态(0无效，1有效)',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `attr1` int(11) DEFAULT NULL COMMENT '预留整型字段1',
  `attr2` int(11) DEFAULT NULL COMMENT '预留整型字段2',
  `attr3` varchar(64) DEFAULT NULL COMMENT '预留字符串字段3',
  `attr4` varchar(64) DEFAULT NULL COMMENT '预留字符串字段4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告位';

-- ----------------------------
-- Table structure for task_gift
-- ----------------------------
DROP TABLE IF EXISTS `task_gift`;
CREATE TABLE `task_gift` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长id',
  `user_id` bigint(20) NOT NULL,
  `join_count` int(11) NOT NULL COMMENT '参与总人数',
  `join_amount` decimal(10,2) NOT NULL COMMENT '参与金额',
  `status` tinyint(4) DEFAULT NULL,
  `joined_count` int(11) DEFAULT '0' COMMENT '已参与人数',
  `enabled` bit(1) DEFAULT b'1' COMMENT '状态(0无效，1有效)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `attr1` int(11) DEFAULT NULL COMMENT '预留整型字段1',
  `attr2` int(11) DEFAULT NULL COMMENT '预留整型字段2',
  `attr3` varchar(64) DEFAULT NULL COMMENT '预留字符串字段3',
  `attr4` varchar(64) DEFAULT NULL COMMENT '预留字符串字段4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for task_gift_line
-- ----------------------------
DROP TABLE IF EXISTS `task_gift_line`;
CREATE TABLE `task_gift_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长id',
  `task_id` bigint(20) NOT NULL COMMENT '任务id',
  `user_id` bigint(20) NOT NULL COMMENT '参与用户',
  `earn_amount` decimal(10,2) DEFAULT '0.00' COMMENT '拆红包金额',
  `opened` bit(1) DEFAULT b'1' COMMENT '状态(0未领取，1已领取)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `attr1` int(11) DEFAULT NULL COMMENT '预留整型字段1',
  `attr2` int(11) DEFAULT NULL COMMENT '预留整型字段2',
  `attr3` varchar(64) DEFAULT NULL COMMENT '预留字符串字段3',
  `attr4` varchar(64) DEFAULT NULL COMMENT '预留字符串字段4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for transfer_cash
-- ----------------------------
DROP TABLE IF EXISTS `transfer_cash`;
CREATE TABLE `transfer_cash` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `pay_username` varchar(32) NOT NULL COMMENT '用户名，如果是银行卡转账需要账号用户名',
  `pay_type` tinyint(4) NOT NULL COMMENT '提现使用的支付类型;规则后期定义，如0:支付宝，1:云支付',
  `pay_account` varchar(32) NOT NULL COMMENT '转账账号',
  `pay_amount` decimal(10,2) NOT NULL COMMENT '提现金额',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态(0支付中，1已支付，2支付失败)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `attr1` int(11) DEFAULT NULL COMMENT '预留整型字段1',
  `attr2` int(11) DEFAULT NULL COMMENT '预留整型字段2',
  `attr3` varchar(64) DEFAULT NULL COMMENT '预留字符串字段3',
  `attr4` varchar(64) DEFAULT NULL COMMENT '预留字符串字段4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for transfer_cash_history
-- ----------------------------
DROP TABLE IF EXISTS `transfer_cash_history`;
CREATE TABLE `transfer_cash_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长id',
  `cash_id` bigint(20) NOT NULL COMMENT '提现表id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `pay_username` varchar(32) NOT NULL COMMENT '用户名，如果是银行卡转账需要账号用户名',
  `pay_type` tinyint(4) NOT NULL COMMENT '提现使用的支付类型;规则后期定义，如0:支付宝，1:云支付',
  `pay_account` varchar(32) NOT NULL COMMENT '转账账号',
  `pay_amount` decimal(10,2) NOT NULL COMMENT '提现金额',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态(0支付中，1已支付，2支付失败)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `attr1` int(11) DEFAULT NULL COMMENT '预留整型字段1',
  `attr2` int(11) DEFAULT NULL COMMENT '预留整型字段2',
  `attr3` varchar(64) DEFAULT NULL COMMENT '预留字符串字段3',
  `attr4` varchar(64) DEFAULT NULL COMMENT '预留字符串字段4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长id',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `mobile` varchar(11) NOT NULL COMMENT '手机号',
  `enabled` bit(1) DEFAULT b'1' COMMENT '状态(0无效，1有效)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `attr1` int(11) DEFAULT NULL COMMENT '预留整型字段1',
  `attr2` int(11) DEFAULT NULL COMMENT '预留整型字段2',
  `attr3` varchar(64) DEFAULT NULL COMMENT '预留字符串字段3',
  `attr4` varchar(64) DEFAULT NULL COMMENT '预留字符串字段4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for virtual_account
-- ----------------------------
DROP TABLE IF EXISTS `virtual_account`;
CREATE TABLE `virtual_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长id',
  `user_id` bigint(20) NOT NULL COMMENT '用户名',
  `balance` decimal(10,2) DEFAULT '0.00' COMMENT '余额',
  `enabled` bit(1) DEFAULT b'1' COMMENT '状态(0无效，1有效)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `attr1` int(11) DEFAULT NULL COMMENT '预留整型字段1',
  `attr2` int(11) DEFAULT NULL COMMENT '预留整型字段2',
  `attr3` varchar(64) DEFAULT NULL COMMENT '预留字符串字段3',
  `attr4` varchar(64) DEFAULT NULL COMMENT '预留字符串字段4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='虚拟账户表';

-- ----------------------------
-- Table structure for yunpay_order
-- ----------------------------
DROP TABLE IF EXISTS `yunpay_order`;
CREATE TABLE `yunpay_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `total_fee` decimal(10,2) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `trade_order_id` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
