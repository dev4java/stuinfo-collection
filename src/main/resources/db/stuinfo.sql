/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : stuinfo

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2014-05-08 18:21:54
*/

SET FOREIGN_KEY_CHECKS=0;
create database stuinfo default charset utf8;
grant all privileges on stuinfo.* to 'newft'@'%' identified by 'newft';
-- ----------------------------
-- Table structure for `sc_general_answerquestion`
-- ----------------------------
DROP TABLE IF EXISTS `sc_general_answerquestion`;
CREATE TABLE `sc_general_answerquestion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stuid` bigint(20) NOT NULL COMMENT '学生id',
  `questionid` bigint(20) NOT NULL COMMENT '学校的问卷id',
  `answer` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '问卷的回答',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc_general_answerquestion
-- ----------------------------
INSERT INTO `sc_general_answerquestion` VALUES ('3', '123', '7', '5个人');
INSERT INTO `sc_general_answerquestion` VALUES ('4', '2', '9', '5个人');
INSERT INTO `sc_general_answerquestion` VALUES ('5', '3', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('7', '5', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('8', '6', '1', '否');
INSERT INTO `sc_general_answerquestion` VALUES ('9', '7', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('10', '8', '1', '否');
INSERT INTO `sc_general_answerquestion` VALUES ('11', '9', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('12', '10', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('13', '11', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('14', '12', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('15', '13', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('16', '14', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('17', '15', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('18', '16', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('19', '17', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('20', '18', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('21', '19', '1', '是');
INSERT INTO `sc_general_answerquestion` VALUES ('22', '20', '1', '是');

-- ----------------------------
-- Table structure for `sc_general_parent`
-- ----------------------------
DROP TABLE IF EXISTS `sc_general_parent`;
CREATE TABLE `sc_general_parent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `relation` int(1) unsigned zerofill NOT NULL DEFAULT '1' COMMENT '关系 1爸爸 2妈妈',
  `stuid` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `company` varchar(50) DEFAULT NULL COMMENT '公司',
  `job_title` varchar(50) DEFAULT NULL COMMENT '职务',
  `telphone` bigint(11) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc_general_parent
-- ----------------------------
INSERT INTO `sc_general_parent` VALUES ('3', '1', '2', '学生甲爸爸', 'LuoLe', '职员', '12236544563');
INSERT INTO `sc_general_parent` VALUES ('4', '2', '2', '学生甲妈妈', 'LuoLe', '职员', '12236544563');
INSERT INTO `sc_general_parent` VALUES ('5', '3', '3', '父亲', '父亲单位', '父亲职务', '13412344321');
INSERT INTO `sc_general_parent` VALUES ('6', '0', '3', '母亲', '母亲单位', '母亲职务', null);
INSERT INTO `sc_general_parent` VALUES ('9', '3', '5', '父亲姓名', '父亲单位', '父亲职位', '13412344321');
INSERT INTO `sc_general_parent` VALUES ('10', '0', '5', '母亲姓名', '母亲单位', '母亲职务', null);
INSERT INTO `sc_general_parent` VALUES ('11', '3', '6', '父未知', '父单位未知', '父职位未知', '13412344321');
INSERT INTO `sc_general_parent` VALUES ('12', '0', '6', '母未知', '母单位未知', '母职务未知', null);
INSERT INTO `sc_general_parent` VALUES ('13', '3', '7', '福明', '发顺丰', '发生的', '13412333211');
INSERT INTO `sc_general_parent` VALUES ('14', '3', '7', '母姓名', '母单位', '母职位', '13345677654');
INSERT INTO `sc_general_parent` VALUES ('15', '3', '8', '福明发生的', '发顺丰发生的', '发生的发生', '13412333211');
INSERT INTO `sc_general_parent` VALUES ('16', '3', '8', '母姓名范德萨', '母单位发生的', '母职位发生的', '13345677654');
INSERT INTO `sc_general_parent` VALUES ('17', '3', '9', 'fgdgf', 'dfgdfg', 'dgd', '13612345678');
INSERT INTO `sc_general_parent` VALUES ('18', '3', '9', 'fdg', 'dgd', 'dgd', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('19', '3', '10', 'fgdgf', 'dfgdfg', 'dgd', '13612345678');
INSERT INTO `sc_general_parent` VALUES ('20', '3', '10', 'fdg', 'dgd', 'dgd', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('21', '3', '11', 'fgdgf', 'dfgdfg', 'dgd', '13612345678');
INSERT INTO `sc_general_parent` VALUES ('22', '3', '11', 'fdg', 'dgd', 'dgd', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('23', '3', '12', 'fgdgf', 'dfgdfg', 'dgd', '13612345678');
INSERT INTO `sc_general_parent` VALUES ('24', '3', '12', 'fdg', 'dgd', 'dgd', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('25', '3', '13', 'fgdgf', 'dfgdfg', 'dgd', '13612345678');
INSERT INTO `sc_general_parent` VALUES ('26', '3', '13', 'fdg', 'dgd', 'dgd', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('27', '3', '14', 'fgdgf', 'dfgdfg', 'dgd', '13612345678');
INSERT INTO `sc_general_parent` VALUES ('28', '3', '14', 'fdg', 'dgd', 'dgd', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('29', '3', '15', 'fgdgf', 'dfgdfg', 'dgd', '13612345678');
INSERT INTO `sc_general_parent` VALUES ('30', '3', '15', 'fdg', 'dgd', 'dgd', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('31', '3', '16', 'fgdgf', 'dfgdfg', 'dgd', '13612345678');
INSERT INTO `sc_general_parent` VALUES ('32', '3', '16', 'fdg', 'dgd', 'dgd', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('33', '3', '17', 'fgdgf', 'dfgdfg', 'dgd', '13612345678');
INSERT INTO `sc_general_parent` VALUES ('34', '3', '17', 'fdg', 'dgd', 'dgd', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('35', '3', '18', 'bvbcvb', 'cbcvb', 'cbcvb', '13612345678');
INSERT INTO `sc_general_parent` VALUES ('36', '3', '18', 'vbcvb', 'cbcv', 'cbcvb', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('37', '3', '19', 'dfgdf', 'fdg', 'dgdf', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('38', '3', '19', 'dfgdg', 'dfgdfg', 'dgdsfg', '13512345678');
INSERT INTO `sc_general_parent` VALUES ('39', '3', '20', 'fsdf', 'fds', 'fds', '13412344321');
INSERT INTO `sc_general_parent` VALUES ('40', '3', '20', 'fds', 'fdsf', 'fdsf', '13412344321');

-- ----------------------------
-- Table structure for `sc_general_schoolquestion`
-- ----------------------------
DROP TABLE IF EXISTS `sc_general_schoolquestion`;
CREATE TABLE `sc_general_schoolquestion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(1) DEFAULT NULL COMMENT '//状态 0有效 1 无效',
  `dept` int(1) DEFAULT NULL COMMENT '学部 1 小学 2初中 3 高中 4 大学 5幼儿园',
  `quest_type` int(1) DEFAULT NULL COMMENT '问题类型',
  `question` varchar(200) DEFAULT NULL COMMENT '问题',
  `answer` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc_general_schoolquestion
-- ----------------------------
INSERT INTO `sc_general_schoolquestion` VALUES ('1', '0', '1', '1', '你家属于阳光小区吗', '1 是;2不是');
INSERT INTO `sc_general_schoolquestion` VALUES ('2', '1', '1', '2', '你家有几口人?', null);
INSERT INTO `sc_general_schoolquestion` VALUES ('3', '1', '2', '1', '这里不应该出来2', '是的');
INSERT INTO `sc_general_schoolquestion` VALUES ('4', '1', '2', '0', '你家在哪儿?', null);
INSERT INTO `sc_general_schoolquestion` VALUES ('5', '1', '2', '0', '你几口人?', null);
INSERT INTO `sc_general_schoolquestion` VALUES ('6', '1', '2', '0', '你几口人?', null);
INSERT INTO `sc_general_schoolquestion` VALUES ('7', '1', '2', '0', '你几口人????', null);
INSERT INTO `sc_general_schoolquestion` VALUES ('8', '1', '2', '0', '你几口人????', null);
INSERT INTO `sc_general_schoolquestion` VALUES ('9', '1', '2', '0', '你几口人????', null);

-- ----------------------------
-- Table structure for `sc_general_student`
-- ----------------------------
DROP TABLE IF EXISTS `sc_general_student`;
CREATE TABLE `sc_general_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `sex` int(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `huji_address` varchar(200) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `apply_dept` int(1) DEFAULT NULL COMMENT '和学部对应',
  `stuanswer` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc_general_student
-- ----------------------------
INSERT INTO `sc_general_student` VALUES ('2', '学生甲', '1', '2014-05-06', 'beijing', '北京朝阳芍药居小区', '1', '2不是');
INSERT INTO `sc_general_student` VALUES ('3', '鬼地方', '1', '1990-12-30', '北京户口', '北京海淀', '1', '是');
INSERT INTO `sc_general_student` VALUES ('5', '路人甲', '1', '1990-12-30', '湖北', '湖北宜昌', '1', '是');
INSERT INTO `sc_general_student` VALUES ('6', '燕赤霞', '1', '1891-11-11', '燕京', '兰若寺', '1', '否');
INSERT INTO `sc_general_student` VALUES ('7', '学生', '1', '1990-11-11', '学生户口', '家庭住址', '1', '是');
INSERT INTO `sc_general_student` VALUES ('8', '学生发生的', '1', '1990-11-11', '学生户口发生的', '家庭住址发生的', '1', '否');
INSERT INTO `sc_general_student` VALUES ('9', 'fgd', '2', '1990-12-30', 'dg', 'dgdg', '1', '是');
INSERT INTO `sc_general_student` VALUES ('10', 'fgdhfgh', '2', '1990-12-31', 'dg', 'dgdg', '1', '是');
INSERT INTO `sc_general_student` VALUES ('11', 'fgdhfgh', '2', '1990-12-31', 'dg', 'dgdg', '1', '是');
INSERT INTO `sc_general_student` VALUES ('12', 'fgdhfghfre', '2', '1990-01-11', 'dg', 'dgdg', '1', '是');
INSERT INTO `sc_general_student` VALUES ('13', 'fgdhfghfre', '2', '1990-01-11', 'dg', 'dgdg', '1', '是');
INSERT INTO `sc_general_student` VALUES ('14', 'fgdhfghfre', '2', '1990-01-11', 'dg', 'dgdg', '1', '是');
INSERT INTO `sc_general_student` VALUES ('15', 'fgdhfghfre', '2', '1990-01-11', 'dg', 'dgdg', '1', '是');
INSERT INTO `sc_general_student` VALUES ('16', 'fgdhfghfre', '2', '1990-01-11', 'dg', 'dgdg', '1', '是');
INSERT INTO `sc_general_student` VALUES ('17', 'fgdhfghfre', '2', '1990-01-11', 'dg', 'dgdg', '1', '是');
INSERT INTO `sc_general_student` VALUES ('18', 'hfg', '2', '1990-10-11', 'gcb', 'cbcvbcv', '1', '是');
INSERT INTO `sc_general_student` VALUES ('19', 'fddf', '2', '1990-11-11', 'fgdfdf', 'dgdfd', '1', '是');
INSERT INTO `sc_general_student` VALUES ('20', 'rtewrw', '2', '2014-05-08', 'fdsfs', 'fdsf', '1', '是');

-- ----------------------------
-- Table structure for `sc_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sc_sys_user`;
CREATE TABLE `sc_sys_user` (
  `login_name` varchar(200) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc_sys_user
-- ----------------------------
INSERT INTO `sc_sys_user` VALUES ('admin', '8c68b82fc9b15410be1f56a700608537', '1', '1');

-- ----------------------------
-- View structure for `stu_list`
-- ----------------------------
DROP VIEW IF EXISTS `stu_list`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stu_list` AS select `sc_general_student`.`name` AS `孩子姓名`,`sc_general_student`.`sex` AS `性别`,`sc_general_student`.`birthday` AS `生日`,`sc_general_student`.`huji_address` AS `户口所在地`,`sc_general_student`.`address` AS `家庭住址`,`sc_general_student`.`stuanswer` AS `是否租住` from `sc_general_student` ;
