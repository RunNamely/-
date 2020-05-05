/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/10/31 10:05:19                          */
/*==============================================================*/


/*==============================================================*/
/* Table: t_daily_work                                          */
/*==============================================================*/
create table t_daily_work
(
   id                   int not null auto_increment comment 'ID标识',
   flag                 int default 0 comment '有效标识  0：有效  1：无效',
   create_time          datetime comment '创建时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   schedule_id          int not null comment '调度ID',
   equipment_id         int comment '设备id',
   equipment_seq        varchar(200) comment '设备序号',
   start_time           datetime comment '加工开始时间',
   end_time             datetime comment '加工结束时间',
   working_count        int comment '加工数量',
   qualified_count      int comment '合格数量',
   unqualified_cout     int comment '不合格数量',
   complete_flag        int default 1 comment '结束报工标识  0：是  1：否',
   factory_id           int not null comment '工厂ID',
   bak                  varchar(500) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: t_equipment                                           */
/*==============================================================*/
create table t_equipment
(
   id                   int not null auto_increment comment 'ID标识',
   flag                 int default 0 comment '有效标识 0：有效  1：失效',
   create_time          datetime comment '创建时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   equipment_seq        varchar(200) not null comment '设备序号',
   equipment_name       varchar(300) comment '设备名称',
   equipment_img_url    varchar(300) comment '设备图片',
   equipment_status     int default 10 comment '设备状态 10：启用  20：停用  30：故障',
   factory_id           int not null comment '工厂ID',
   primary key (id)
);

alter table t_equipment comment '设备表';

/*==============================================================*/
/* Table: t_equipment_product                                   */
/*==============================================================*/
create table t_equipment_product
(
   id                   int not null auto_increment comment 'ID标识',
   equipment_id         int not null comment '设备ID',
   product_id           int not null comment '产品ID',
   yield                int comment '产能',
   unit                 int comment '产能单位  10：天  20：月  30：年  40：小时',
   factory_id           int not null comment '工厂ID',
   primary key (id)
);

alter table t_equipment_product comment '设备与产品对应表';

/*==============================================================*/
/* Table: t_factory                                             */
/*==============================================================*/
create table t_factory
(
   id                   int not null auto_increment comment '工厂ID',
   flag                 int default 0 comment '有效标识  0:有效   1:无效',
   create_time          datetime comment '创建时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   bak                  varchar(500) comment '备注',
   factory_name         varchar(500) comment '工厂名称',
   factory_img_url      varchar(500) comment '工厂图片',
   factory_addr         varchar(500) comment '工厂地址',
   factory_url          varchar(200) comment '工厂网址',
   factory_worker       int comment '工厂人数',
   factory_status       int comment '工厂状态  0:正常  1:关闭',
   primary key (id)
);

/*==============================================================*/
/* Table: t_order_track                                         */
/*==============================================================*/
create table t_order_track
(
   id                   int not null auto_increment comment 'ID标识',
   flag                 int default 0 comment '有效标识 0：有效  1：无效',
   create_time          datetime comment '创建时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   schedule_id          int comment '调度id',
   plan_id              int comment '计划id',
   product_id           int comment '产品id',
   working_count        int comment '加工数量',
   qualified_count      int default 0 comment '合格数',
   factory_id           int not null comment '工厂ID',
   primary key (id)
);

alter table t_order_track comment '订单跟踪表';

/*==============================================================*/
/* Index: Index_schedule_seq                                    */
/*==============================================================*/
create index Index_schedule_seq on t_order_track
(
   schedule_id
);

/*==============================================================*/
/* Table: t_permit                                              */
/*==============================================================*/
create table t_permit
(
   id                   int not null auto_increment comment '权限ID',
   flag                 int default 0 comment '有效标识  0:有效  1:无效',
   status               int comment '权限状态  0:正常  1:停用',
   parent_id            int comment '权限父ID',
   permit_name          varchar(300) comment '权限名称',
   permit_desc          varchar(300) comment '权限描述',
   permit_path          varchar(300) comment '校验地址',
   primary key (id)
);

/*==============================================================*/
/* Table: t_product                                             */
/*==============================================================*/
create table t_product
(
   id                   int not null auto_increment comment 'ID标识',
   flag                 int default 0 comment '有效标识 0：有效  1：无效',
   create_time          datetime comment '创建时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   product_num          varchar(200) not null comment '产品编号',
   product_name         varchar(300) not null comment '产品名称',
   product_img_url      varchar(300) comment '产品图片所在目录',
   factory_id           int not null comment '工厂ID',
   primary key (id)
);

alter table t_product comment '用于定义产品';

/*==============================================================*/
/* Index: Index_product_name                                    */
/*==============================================================*/
create index Index_product_name on t_product
(
   product_num
);

/*==============================================================*/
/* Index: Index_product_num                                     */
/*==============================================================*/
create index Index_product_num on t_product
(
   product_num
);

/*==============================================================*/
/* Table: t_product_order                                       */
/*==============================================================*/
create table t_product_order
(
   id                   int not null auto_increment comment 'ID标识',
   flag                 int default 0 comment '有效标识  0：有效  1：无效',
   create_time          datetime comment '创建时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   order_seq            varchar(200) not null comment '订单编号',
   order_source         int comment '订单来源',
   product_id           int comment '产品ID',
   product_count        int not null comment '产品数量',
   end_date             date not null comment '订单截止日期',
   order_status         int not null default 10 comment '订单状态 10：未接单  20：已接单  30：已拒绝  40：生产中  50：订单完成',
   factory_id           int not null comment '工厂ID',
   factory_yield        int comment '工厂产能',
   primary key (id)
);

alter table t_product_order comment '订单表';

/*==============================================================*/
/* Index: Index_order_seq                                       */
/*==============================================================*/
create index Index_order_seq on t_product_order
(
   order_seq
);

/*==============================================================*/
/* Table: t_product_plan                                        */
/*==============================================================*/
create table t_product_plan
(
   id                   int not null auto_increment comment 'ID标识',
   flag                 int default 0 comment '有效标识  0：有效  1：无效',
   create_time          datetime comment '创建时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   plan_seq             varchar(200) comment '计划编号',
   order_id             int not null comment '订单ID',
   product_id           int not null comment '产品ID',
   plan_count           int comment '计划数量',
   delivery_date        date comment '交货日期',
   plan_start_date      date comment '计划开始日期',
   plan_end_date        date comment '计划结束日期',
   plan_status          int default 10 comment '计划状态  10：未启动  20：已启动   30：已完成',
   factory_id           int not null comment '工厂ID',
   primary key (id)
);

alter table t_product_plan comment '生产计划表';

/*==============================================================*/
/* Index: Index_plan_seq                                        */
/*==============================================================*/
create index Index_plan_seq on t_product_plan
(
   plan_seq
);

/*==============================================================*/
/* Index: Index_order_seq                                       */
/*==============================================================*/
create index Index_order_seq on t_product_plan
(
   plan_seq
);

/*==============================================================*/
/* Table: t_product_schedule                                    */
/*==============================================================*/
create table t_product_schedule
(
   id                   int not null auto_increment comment 'ID标识',
   flag                 int default 0 comment '有效标识  0：有效  1：无效',
   create_time          datetime comment '创建时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   schedule_seq         varchar(200) comment '工单编号',
   schedule_count       int comment '工单数量',
   schedule_status      int not null default 10 comment '工单状态 10：未开始   20：生产中  30：已完成',
   plan_id              int not null comment '计划ID',
   product_id           int not null comment '产品ID',
   equipment_id         int comment '设备ID',
   start_date           date comment '开始日期',
   end_date             date comment '结束日期',
   factory_id           int not null comment '工厂ID',
   primary key (id)
);

alter table t_product_schedule comment '生产调度表';

/*==============================================================*/
/* Table: t_role_permit                                         */
/*==============================================================*/
create table t_role_permit
(
   id                   int not null auto_increment comment 'ID标识',
   flag                 int default 0 comment '有效标识',
   create_time          datetime comment '创建时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   factory_id           int comment '工厂ID',
   role_id              int comment '角色ID',
   permit_id            int comment '权限ID',
   primary key (id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null auto_increment comment '主键ID',
   flag                 int default 0 comment '有效标识  0：有效  1：无效',
   create_time          datetime comment '注册时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   user_status          int comment '用户状态 0:正常  1：锁定',
   user_name            varchar(50) not null comment '用户名',
   user_real_name       varchar(100) comment '用户姓名',
   user_passwd          varchar(100) not null comment '用户密码',
   user_job_num         varchar(100) comment '用户工号',
   user_phone_num       char(11) comment '用户手机号',
   user_email           varchar(100) comment '用户email',
   role_id              int comment '角色ID',
   factory_id           int not null comment '工厂ID',
   primary key (id)
);

alter table t_user comment '用户表';

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   id                   int not null auto_increment comment '角色ID',
   flag                 int default 0 comment '有效标识  0:有效  1:无效',
   create_time          datetime comment '创建时间',
   create_userid        int comment '创建人ID',
   update_time          datetime comment '修改时间',
   update_userid        int comment '修改人ID',
   role_desc            varchar(500) comment '角色描述',
   role_name            varchar(300) comment '角色名称',
   role_status          int comment '角色状态  0:正常  1:禁用',
   factory_id           int comment '工厂ID',
   primary key (id)
);

