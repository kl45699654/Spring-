CREATE TABLE  `order`(
   `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
   `customer_id` INT (40) NOT NULL COMMENT '用户id',
   `goods_id` INT (40) NOT NULL COMMENT '商品id',
   `buy_num`INT (20) NOT NULL COMMENT '购买数量',
   `buy_price` INT (20)NOT NULL COMMENT'购买价格',
   `order_time` DATETIME NOT NULL COMMENT '订单产生时间' ,
   PRIMARY KEY ( `id` )
)ENGINE=INNODB DEFAULT CHARSET=utf8;