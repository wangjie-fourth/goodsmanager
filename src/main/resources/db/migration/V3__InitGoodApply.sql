create table GOOD_APPLY
(
    GOOD_APPLY_ID            bigint primary key auto_increment comment '主键id',
    GOOD_ID       bigint comment '物品名称id',
    APPLY_USER    varchar(50) comment '领用人员',
    APPLY_DATE    timestamp default current_timestamp comment '领用时间',
    APPLY_NUMBER  int comment '领用数量',
    APPLY_EXPLAIN text comment '领用说明'
) ENGINE = InnoDB  AUTO_INCREMENT = 1  DEFAULT CHARSET = utf8 comment '商品申请表';
INSERT INTO GOOD_APPLY(GOOD_ID, APPLY_USER, APPLY_DATE, APPLY_NUMBER, APPLY_EXPLAIN) VALUES (1,'张三','2019-03-02 12:30:51',5,'这是很长很长很长很长的说明');
INSERT INTO GOOD_APPLY(GOOD_ID, APPLY_USER, APPLY_DATE, APPLY_NUMBER, APPLY_EXPLAIN) VALUES (2,'李四','2019-08-09 12:59:00',1,'这是很长很长很长很长的说明');