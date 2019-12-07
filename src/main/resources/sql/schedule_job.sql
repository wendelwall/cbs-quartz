/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : lanjerry

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 28/01/2019 17:47:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `id` CHAR(22) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bean_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `method_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(500) NULL DEFAULT NULL COMMENT '执行任务url',
  `method` varchar(10) NOT NULL DEFAULT 'POST' COMMENT '执行任务方式，默认POST',
  `body` LONGTEXT NULL DEFAULT NULL COMMENT '执行任务参数，默认{}',
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '状态 1.启动 2.暂停',
  `delete_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除 0.否 1.是',
  `creator_id` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `creator_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('5dNAnvCbyZYzApRd93ogGb', '任务01', '0/2 * * * * ?', 'testJob01', 'execute', 'http://localhost:8082/rest/json','POST', '{}', 1, 0, 1, 'admin', '2019-01-28 17:46:43', '2019-01-28 17:50:15');
INSERT INTO `schedule_job` VALUES ('Dhrm8Vmx1MZ5QPqMyg7wLQ', '任务02', '0/2 * * * * ?', 'testJob02', 'execute', 'http://localhost:8082/rest/json','POST', '{}', 1, 0, 1, 'admin', '2019-01-28 16:45:46', '2019-01-28 17:09:15');
INSERT INTO `schedule_job` (`id`,`job_name`,`cron_expression`,`bean_name`,`method_name`,`url`,`method`,`body`,`status`,`delete_flag`,`creator_id`,`creator_name`,`created_time`,`updated_time`) VALUES ('NfA4WYwFNZkw2iNGiJCcMj','中旺保-永安家财无忧险发送邮件任务','0 35 13 * * ?','','','http://localhost:10110/api/ops/pop/sendMail','POST','{\"startTime\":\"2019-08-23\",\"endTime\":\"2019-08-23\"}',1,0,1,'admin','2019-01-28 16:45:46','2019-01-28 17:09:15');

SET FOREIGN_KEY_CHECKS = 1;
