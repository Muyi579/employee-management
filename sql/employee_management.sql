/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : employee_management

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 12/01/2023 16:32:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '营销部');
INSERT INTO `dept` VALUES (2, '宇宙');
INSERT INTO `dept` VALUES (3, '大炮');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hiredate` date NOT NULL,
  `salary` float(10, 2) NOT NULL,
  `dept_id` int(11) NOT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, '张飞', '女', '2002-09-09', 10.00, 1);
INSERT INTO `emp` VALUES (2, '嘉诚', '男', '2000-01-19', 1000.00, 2);
INSERT INTO `emp` VALUES (3, '关羽', '男', '1000-09-11', 19199.00, 2);
INSERT INTO `emp` VALUES (4, '吕长建', '男', '2020-04-16', 19919.00, 2);

SET FOREIGN_KEY_CHECKS = 1;
