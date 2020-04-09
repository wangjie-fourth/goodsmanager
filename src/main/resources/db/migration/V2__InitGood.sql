create table GOOD
(
    GOOD_ID      bigint primary key auto_increment comment '主键id',
    GOOD_NAME    varchar(100) comment '商品名称',
    CATEGORY_ID  bigint comment '物品类别id',
    STORAGE_DATE datetime default current_timestamp comment '入库日期',
    UNIT         varchar(50) comment '单位',
    INVENTORY    bigint comment '库存量',
    NOTE         VARCHAR(500) comment '物品备注'
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 comment '商品表';

INSERT INTO GOOD(GOOD_ID, GOOD_NAME, CATEGORY_ID, STORAGE_DATE, UNIT, INVENTORY, NOTE)
VALUES (1, '联想笔记本', 1, '2019-03-02', '台', 5, '笔记本电脑');
INSERT INTO GOOD(GOOD_ID, GOOD_NAME, CATEGORY_ID, STORAGE_DATE, UNIT, INVENTORY, NOTE)
VALUES (2, '中性笔', 2, '2019-08-09', '盒', 1, '手写笔');