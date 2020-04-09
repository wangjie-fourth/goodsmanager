/*
 Navicat Premium Data Transfer

 Source Server         : goods
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:13307
 Source Schema         : goods

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 04/04/2020 04:53:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for CATEGORY
-- ----------------------------
DROP TABLE IF EXISTS `CATEGORY`;
CREATE TABLE `CATEGORY`  (
  `CATEGORY_ID` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CATEGORY_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`CATEGORY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品类别信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of CATEGORY
-- ----------------------------
INSERT INTO `CATEGORY` VALUES (1, '电脑');
INSERT INTO `CATEGORY` VALUES (2, '办公用品');
INSERT INTO `CATEGORY` VALUES (3, '配件');

-- ----------------------------
-- Table structure for GOOD
-- ----------------------------
DROP TABLE IF EXISTS `GOOD`;
CREATE TABLE `GOOD`  (
  `GOOD_ID` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `GOOD_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `CATEGORY_ID` bigint(0) NULL DEFAULT NULL COMMENT '物品类别id',
  `STORAGE_DATE` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '入库日期',
  `UNIT` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `INVENTORY` bigint(0) NULL DEFAULT NULL COMMENT '库存量',
  `NOTE` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物品备注',
  PRIMARY KEY (`GOOD_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of GOOD
-- ----------------------------
INSERT INTO `GOOD` VALUES (1, '联想笔记本', 1, '2019-03-02 00:00:00', '台', 5, '笔记本电脑');
INSERT INTO `GOOD` VALUES (2, '中性笔', 2, '2019-08-09 00:00:00', '盒', 1, '手写笔');

-- ----------------------------
-- Table structure for GOOD_APPLY
-- ----------------------------
DROP TABLE IF EXISTS `GOOD_APPLY`;
CREATE TABLE `GOOD_APPLY`  (
  `GOOD_APPLY_ID` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `GOOD_ID` bigint(0) NULL DEFAULT NULL COMMENT '物品名称id',
  `APPLY_USER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '领用人员',
  `APPLY_DATE` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '领用时间',
  `APPLY_NUMBER` int(0) NULL DEFAULT NULL COMMENT '领用数量',
  `APPLY_EXPLAIN` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '领用说明',
  PRIMARY KEY (`GOOD_APPLY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品申请表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of GOOD_APPLY
-- ----------------------------
INSERT INTO `GOOD_APPLY` VALUES (1, 1, '张三', '2019-03-02 12:30:51', 5, '这是很长很长很长很长的说明');
INSERT INTO `GOOD_APPLY` VALUES (2, 2, '李四', '2019-08-09 12:59:00', 1, '这是很长很长很长很长的说明');

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history`  (
  `installed_rank` int(0) NOT NULL,
  `version` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `script` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `checksum` int(0) NULL DEFAULT NULL,
  `installed_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `installed_on` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `execution_time` int(0) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`) USING BTREE,
  INDEX `flyway_schema_history_s_idx`(`success`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of flyway_schema_history
-- ----------------------------
INSERT INTO `flyway_schema_history` VALUES (1, '1', 'InitCategory', 'SQL', 'V1__InitCategory.sql', 143529579, 'root', '2020-04-03 20:52:51', 75, 1);
INSERT INTO `flyway_schema_history` VALUES (2, '2', 'InitGood', 'SQL', 'V2__InitGood.sql', 1854562438, 'root', '2020-04-03 20:52:51', 81, 1);
INSERT INTO `flyway_schema_history` VALUES (3, '3', 'InitGoodApply', 'SQL', 'V3__InitGoodApply.sql', -573458775, 'root', '2020-04-03 20:52:51', 80, 1);

SET FOREIGN_KEY_CHECKS = 1;
