--<ScriptOptions statementTerminator=";"/>

CREATE TABLE account (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(45),
	money DECIMAL(10 , 0),
	PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE  `goods_tbl`(
   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
   `goods_name` VARCHAR(100) NOT NULL COMMENT '商品名称',
   `goods_price` int (40) NOT NULL COMMENT '商品价格',
   `fav_price` int(20)  COMMENT '优惠价格',
   `fav_start` char(8) CHARACTER SET utf8 DEFAULT NULL COMMENT '开始优惠时间 ',
   `fav_end` char(8) CHARACTER SET utf8 DEFAULT NULL COMMENT '结束优惠时间 ',
   `good_surnum` int(20) DEFAULT '0' COMMENT '商品剩余数量' ,
   `state` int(1) COMMENT '商商品状态',
   PRIMARY KEY ( `id` )
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE  `customer`(
   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
   `customer_id` int (40) NOT NULL COMMENT '用户id',
   `goods_id` int (40) NOT NULL COMMENT '商品id',
   `goods_num` int(20) COMMENT '商品数量',
   PRIMARY KEY ( `id` )
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE  `order`(
   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
   `customer_id` int (40) NOT NULL COMMENT '用户id',
   `goods_id` int (40) NOT NULL COMMENT '商品id',
   `buy_num`int (20) NOT NULL COMMENT '购买数量',
   `buy_price` INT (20)NOT NULL COMMENT'购买价格',
   `order_time` datetime NOT NULL COMMENT '订单产生时间' ,
   PRIMARY KEY ( `id` )
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `auid` bigint(20) unsigned NOT NULL COMMENT '用户唯一标识码',
  `auiddigest` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT 'auid的消息摘要',
  `usercode` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '小影账号',
  `nickname` varchar(500) DEFAULT NULL COMMENT '昵称',
  `realname` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '真实姓名',
  `studio_flag` int(2) NOT NULL DEFAULT '0' COMMENT '工作室标志',
  `profile_image_url` varchar(500) DEFAULT NULL COMMENT '头像路径',
  `backgroud_img` varchar(1024) DEFAULT NULL COMMENT '用户背景图',
  `country` varchar(100) DEFAULT NULL COMMENT '国家编码',
  `province` varchar(100) DEFAULT NULL COMMENT '省编码',
  `city` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城市编码',
  `address` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '地址',
  `device_name` varchar(128) DEFAULT NULL COMMENT '用户设备名称',
  `school_name` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '学校名称',
  `company_name` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '公司名称',
  `language` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '语言',
  `gender` int(2) DEFAULT '2' COMMENT '性别0男，1女，2保密',
  `birthday_y` char(4) CHARACTER SET utf8 DEFAULT NULL COMMENT '出生日期-年',
  `birthday_m` char(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '出生日期-月',
  `birthday_d` char(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '出生日期-日',
  `phonenumber` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号码',
  `sinaweiboid` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '新浪微博ID',
  `qq` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT 'QQ号码',
  `blog` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '博客地址',
  `favorite_email` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '联系邮箱',
  `description` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简介',
  `tags` varchar(300) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户标签',
  `edition` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户系统版本 0:弃用,1:V1,2:V2',
  `fans_count` int(20) DEFAULT '0' COMMENT '粉丝个数',
  `follow_count` int(20) DEFAULT '0' COMMENT '已关注用户个数',
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '状态 0未启用1正常2冻结3禁用4删除5屏蔽9注销',
  `is_unique_nickname` int(11) NOT NULL DEFAULT '0' COMMENT '用户昵称是否唯 唯一：1 不唯一：0',
  `is_no_talk` int(2) NOT NULL DEFAULT '0' COMMENT '是否禁言 0未禁言  1禁言 ',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `country_code` char(2) DEFAULT 'CN' COMMENT '国家代码(两位代码)',
  `snsinfo` varchar(500) DEFAULT NULL COMMENT '第三方账号类型和主页地址，key为账号类型代码，value为对应主页地址',
  `extend_info` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'json字符串:扩展信息字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_userinfo_auid` (`auid`),
  UNIQUE KEY `uk_userinfo_auiddigest` (`auiddigest`),
  KEY `idx_user_info_modify_time` (`modify_time`),
  KEY `idx_user_info_state` (`state`) USING BTREE,
  KEY `IDX_NICKNAME_IS_UNIQUE_NICKNAME` (`nickname`(191),`is_unique_nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=39307407 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表'