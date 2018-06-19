/*
 Navicat Premium Data Transfer

 Source Server         : DB
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : tourism

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 03/18/2018 15:44:40 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Assign`
-- ----------------------------
DROP TABLE IF EXISTS `Assign`;
CREATE TABLE `Assign` (
  `A_Id` int(255) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `C_Id` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Username` varchar(30) CHARACTER SET utf8 NOT NULL,
  `Result` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`A_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Assign`
-- ----------------------------
BEGIN;
INSERT INTO `Assign` VALUES ('7', '12', '1231', '1'), ('8', '13', '1231', '0'), ('9', '14', '1230', '0'), ('10', '16', '1231', '0'), ('11', '17', '1231', '0'), ('13', '1', '123', '0');
COMMIT;

-- ----------------------------
--  Table structure for `C_Type`
-- ----------------------------
DROP TABLE IF EXISTS `C_Type`;
CREATE TABLE `C_Type` (
  `C_T_Id` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `C_T_Name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `C_T_Desc` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `C_T_State` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`C_T_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `C_Type`
-- ----------------------------
BEGIN;
INSERT INTO `C_Type` VALUES ('1', '脏', '就是脏', '1'), ('2', '乱', '就是乱', '0'), ('3', '差', '就是差', '1');
COMMIT;

-- ----------------------------
--  Table structure for `Complain`
-- ----------------------------
DROP TABLE IF EXISTS `Complain`;
CREATE TABLE `Complain` (
  `C_Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `C_Name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `C_Tel` varchar(13) CHARACTER SET utf8 DEFAULT NULL,
  `C_TargetType` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `C_Target` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `C_Type` int(4) DEFAULT NULL,
  `C_Cont` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `C_Recorder` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `C_Time` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `C_Remark` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `C_Mark` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`C_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Complain`
-- ----------------------------
BEGIN;
INSERT INTO `Complain` VALUES ('12', '张三', '15884867897', '住宿', 'rest', '2', '避暑山庄', null, null, '123', '1'), ('13', '张三', '15884867897', '住宿', 'rest', '2', '避暑山庄', null, null, '123', '1'), ('14', '张三', '15884867897', '住宿', 'rest', '2', '避暑山庄', '', null, '123', '1'), ('15', '123', '123', '住宿', '123', '2', '123', '', null, '123', '0'), ('16', '123', '123', '住宿', '123', '1', '123', '123', '2018-03-18 02:15:45', '123', '1'), ('17', 'qaz', '123', '住宿', '123', '1', '123', '123', '2018-03-18 02:47:20', '123', '1');
COMMIT;

-- ----------------------------
--  Table structure for `Dispose`
-- ----------------------------
DROP TABLE IF EXISTS `Dispose`;
CREATE TABLE `Dispose` (
  `D_Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `C_Id` int(10) DEFAULT NULL,
  `D_Name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `D_Time` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `D_Finish` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `D_Cont` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`D_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Dispose`
-- ----------------------------
BEGIN;
INSERT INTO `Dispose` VALUES ('2', '12', '234', '2018-03-18 03:05:09', '1', '123');
COMMIT;

-- ----------------------------
--  Table structure for `Feedback`
-- ----------------------------
DROP TABLE IF EXISTS `Feedback`;
CREATE TABLE `Feedback` (
  `F_Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `C_Id` int(10) DEFAULT NULL,
  `F_Name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `F_Time` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `F_Cont` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`F_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Feedback`
-- ----------------------------
BEGIN;
INSERT INTO `Feedback` VALUES ('2', '12', '123', '2018-03-18 02:28:35', '123');
COMMIT;

-- ----------------------------
--  Table structure for `Hotel`
-- ----------------------------
DROP TABLE IF EXISTS `Hotel`;
CREATE TABLE `Hotel` (
  `H_Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `H_Name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `H_Rating` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `H_StanPrice` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `H_DiscPrice` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `H_Tel` varchar(13) CHARACTER SET utf8 DEFAULT NULL,
  `H_Url` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `H_BusRoute` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `H_ParkSpace` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `H_Opening` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `H_Addr` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `H_Desc` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `H_Pic` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`H_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Hotel`
-- ----------------------------
BEGIN;
INSERT INTO `Hotel` VALUES ('1', 'qwe', '快捷', '123', '123', '122', '123', '123', '123', '123', '123', 'asdfg', null), ('12', 'asd', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123'), ('41', '213', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', null);
COMMIT;

-- ----------------------------
--  Table structure for `Performance`
-- ----------------------------
DROP TABLE IF EXISTS `Performance`;
CREATE TABLE `Performance` (
  `P_Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `P_Name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `P_Price` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `P_Tel` varchar(13) CHARACTER SET utf8 DEFAULT NULL,
  `P_Addr` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `P_BusRoute` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `P_Opening` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `P_Desc` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `P_Pic` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`P_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Performance`
-- ----------------------------
BEGIN;
INSERT INTO `Performance` VALUES ('1', 'asd', '123', '123', '123', '123', '123', '123', '123'), ('6', '123', '123', '123', '123', '123', '123', '123', '123'), ('7', '123', '123', '123', '123', '123', '123', '123', '123'), ('10', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', null);
COMMIT;

-- ----------------------------
--  Table structure for `Restaurant`
-- ----------------------------
DROP TABLE IF EXISTS `Restaurant`;
CREATE TABLE `Restaurant` (
  `R_Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `R_Name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `R_AvgPrice` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `R_Tel` varchar(13) CHARACTER SET utf8 DEFAULT NULL,
  `R_Url` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `R_BusRoute` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `R_ParkSpace` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `R_Opening` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `R_Addr` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `R_Desc` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `R_Pic` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`R_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Restaurant`
-- ----------------------------
BEGIN;
INSERT INTO `Restaurant` VALUES ('1', 'qwe', '123', '123', '123', '123', '123', '123', 'asd', '', null), ('6', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123'), ('7', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123'), ('8', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123'), ('9', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123'), ('10', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123'), ('12', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', null);
COMMIT;

-- ----------------------------
--  Table structure for `Scenic`
-- ----------------------------
DROP TABLE IF EXISTS `Scenic`;
CREATE TABLE `Scenic` (
  `S_Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `S_Name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `S_Type` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `S_StanPrice` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `S_DiscPrice` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `S_Tel` varchar(13) CHARACTER SET utf8 DEFAULT NULL,
  `S_Url` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `S_BusRoute` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `S_ParkSpace` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `S_Opening` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `S_Addr` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `S_Desc` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `S_Pic` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`S_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Scenic`
-- ----------------------------
BEGIN;
INSERT INTO `Scenic` VALUES ('1', 'qwe', '123', '123', '123', '123', '123', '123', '123', '123', '123', null, null), ('2', '123', '123', '123', '123', '123', '123', '123', '123', '123', 'asd', null, null), ('3', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', null), ('4', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', null), ('5', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', null), ('6', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', null), ('7', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', null), ('9', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `Travel`
-- ----------------------------
DROP TABLE IF EXISTS `Travel`;
CREATE TABLE `Travel` (
  `T_Id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `T_Name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `T_Linkman` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `T_Tel` varchar(13) CHARACTER SET utf8 DEFAULT NULL,
  `T_Fax` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `T_QQ` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `T_Email` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `T_Addr` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `T_Desc` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`T_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Travel`
-- ----------------------------
BEGIN;
INSERT INTO `Travel` VALUES ('1', 'qwe', 'asd', '123', '123', '123', '123', '123', '123'), ('6', '123', '123', '123', '123', '123', '123', '123', '123'), ('7', '123', '123', '123', '123', '123', '123', '123', '123'), ('8', '123', '123', '123', '123', '123', '123', '123', '123'), ('9', '123', '123', '123', '123', '123', '123', '123', '123'), ('11', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe');
COMMIT;

-- ----------------------------
--  Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `Username` varchar(30) CHARACTER SET utf8 NOT NULL,
  `Password` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `RealName` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `UserType` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `UserLock` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `LastLoginTime` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `User`
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES ('123', '123', '123', '系统管理员', '1', '2018-03-16 16:10:42'), ('1230', '123', '123', '投诉处理', '1', '2018-03-17 23:39:42'), ('1231', '123', '123', '投诉处理', '1', '2018-03-17 23:39:43'), ('1232', '123', '123', '投诉处理', '1', '2018-03-17 23:39:43'), ('1233', '123', '123', '投诉处理', '1', '2018-03-17 23:39:43'), ('1234', '123', '123', '投诉处理', '1', '2018-03-17 23:39:43'), ('1235', '123', '123', '投诉处理', '1', '2018-03-17 23:39:43'), ('1236', '123', '123', '投诉处理', '1', '2018-03-17 23:39:43'), ('1237', '123', '123', '投诉处理', '1', '2018-03-17 23:39:43'), ('1238', '123', '123', '投诉处理', '1', '2018-03-17 23:39:43'), ('1239', '123', '123', '投诉处理', '1', '2018-03-17 23:39:43'), ('admin', '000000', '管理员', '系统管理员', '1', '2018-03-18 15:00:15'), ('asd', 'asd', 'asd', '系统管理员', '0', '2018-02-06 18:06:55'), ('qwe', 'qwe', 'qwe', '投诉处理', '1', '2018-02-04 14:19:52'), ('zhang', '123', '123', '服务人员', '1', '2018-02-04 14:19:22'), ('zhangsan', '123', '123', '系统管理员', '1', '2018-02-03 01:50:06');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
