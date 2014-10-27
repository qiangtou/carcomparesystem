/*==============================================================*/
/* Database name:  carcomparesystem                             */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/10/25 星期六 18:11:34                      */
/*==============================================================*/


drop database if exists carcomparesystem;

/*==============================================================*/
/* Database: carcomparesystem                                   */
/*==============================================================*/
create database carcomparesystem;

use carcomparesystem;

/*==============================================================*/
/* Table: brand                                                 */
/*==============================================================*/
create table brand
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   shortName            varchar(10) not null,
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

alter table brand comment '品牌';

/*==============================================================*/
/* Table: car                                                   */
/*==============================================================*/
create table car
(
   id                   int not null auto_increment,
   seriesId             int comment '车系Id',
   name                 varchar(50) not null comment '名称',
   structure            tinyint comment '1两厢2三厢3掀背,4旅行版,5硬顶敞篷车6,软顶敞篷车,7硬顶跑车,8客车,9货车',
   level                tinyint comment '1微型车 2小型车 3紧凑型车 4中型车 5中大型车 6豪华车 7SUV 8MPV 9跑车 10皮卡 11微面 12电动车
            ',
   seatNum              int,
   sideDoorNum          int comment '从下拉框选择（1、2、3、4）',
   openType             tinyint comment '1平开、 2侧滑、 3对开、 4上开
            ',
   price                int comment '价格',
   year                 int comment '上市年份',
   extendProperty       varchar(500) comment '上市日期、价位、排量、长度(mm)、宽度(mm)、高度(mm)、轴距(mm)、前轮距(mm)、后轮距(mm)、车门数、整备质量(kg)',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

alter table car comment '车辆款型表';

/*==============================================================*/
/* Table: carpic                                                */
/*==============================================================*/
create table carpic
(
   id                   int not null auto_increment,
   typeId               int comment '款型id',
   color                tinyint comment '颜色;黑、白、银、灰、红、绿、蓝、黄、褐',
   picUrl               varchar(100) comment '图片地址',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

alter table carpic comment '款型颜色图片';

/*==============================================================*/
/* Table: pic                                                   */
/*==============================================================*/
create table pic
(
   id                   int not null auto_increment,
   videoId              int not null,
   name                 varchar(20) not null comment '名称',
   url                  longblob not null comment '地址',
   isShow               tinyint not null comment '0:不显示,1:显示',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

alter table pic comment '图片表';

/*==============================================================*/
/* Table: series                                                */
/*==============================================================*/
create table series
(
   id                   int not null auto_increment,
   name                 varchar(50) not null comment '车系名称',
   brandId              int not null comment '品牌Id',
   brandName            varchar(50) comment '品牌名称',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

alter table series comment '车系表';

/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on series
(
   name
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   loginName            varchar(1) not null comment '登录名',
   name                 varchar(1),
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

alter table user comment '用户表';

/*==============================================================*/
/* Index: Index_1                                               */
/*==============================================================*/
create index Index_1 on user
(
   loginName
);

/*==============================================================*/
/* Table: video                                                 */
/*==============================================================*/
create table video
(
   id                   int not null auto_increment,
   name                 varchar(1) not null comment '名称',
   url                  varchar(100),
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

alter table video comment '视频表';

alter table car add constraint FK_Reference_3 foreign key (seriesId)
      references series (id) on delete restrict on update restrict;

alter table carpic add constraint FK_Reference_4 foreign key (typeId)
      references car (id) on delete restrict on update restrict;

alter table pic add constraint FK_Reference_1 foreign key (videoId)
      references video (id) on delete restrict on update restrict;

alter table series add constraint FK_Reference_2 foreign key (brandId)
      references brand (id) on delete restrict on update restrict;

