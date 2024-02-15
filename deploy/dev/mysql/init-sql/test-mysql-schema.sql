/******************************************/
/*   数据库  */
/******************************************/

CREATE DATABASE IF NOT EXISTS test;

USE test;

CREATE USER 'test' IDENTIFIED BY 'test';

GRANT ALL ON test.* TO test;

FLUSH PRIVILEGES;

/******************************************/
/*   表   */
/******************************************/

/*   表
CREATE TABLE `test`
(
    `id`           bigint AUTO_INCREMENT     not null comment 'id',
    `comment`     varchar(255)         default null comment '备注',
    primary key (`id`)
) ENGINE=NDB ;
-- ) ENGINE=INNODB ;
*/

CREATE TABLE `test`
(
    `id`           bigint AUTO_INCREMENT     not null comment 'id',
    `comment`     varchar(255)         default null comment '备注',
    primary key (`id`)
);
