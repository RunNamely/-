/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/10/31 10:05:19                          */
/*==============================================================*/


/*==============================================================*/
/* Table: t_daily_work                                          */
/*==============================================================*/
create table t_daily_work
(
   id                   int not null auto_increment comment 'ID��ʶ',
   flag                 int default 0 comment '��Ч��ʶ  0����Ч  1����Ч',
   create_time          datetime comment '����ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   schedule_id          int not null comment '����ID',
   equipment_id         int comment '�豸id',
   equipment_seq        varchar(200) comment '�豸���',
   start_time           datetime comment '�ӹ���ʼʱ��',
   end_time             datetime comment '�ӹ�����ʱ��',
   working_count        int comment '�ӹ�����',
   qualified_count      int comment '�ϸ�����',
   unqualified_cout     int comment '���ϸ�����',
   complete_flag        int default 1 comment '����������ʶ  0����  1����',
   factory_id           int not null comment '����ID',
   bak                  varchar(500) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: t_equipment                                           */
/*==============================================================*/
create table t_equipment
(
   id                   int not null auto_increment comment 'ID��ʶ',
   flag                 int default 0 comment '��Ч��ʶ 0����Ч  1��ʧЧ',
   create_time          datetime comment '����ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   equipment_seq        varchar(200) not null comment '�豸���',
   equipment_name       varchar(300) comment '�豸����',
   equipment_img_url    varchar(300) comment '�豸ͼƬ',
   equipment_status     int default 10 comment '�豸״̬ 10������  20��ͣ��  30������',
   factory_id           int not null comment '����ID',
   primary key (id)
);

alter table t_equipment comment '�豸��';

/*==============================================================*/
/* Table: t_equipment_product                                   */
/*==============================================================*/
create table t_equipment_product
(
   id                   int not null auto_increment comment 'ID��ʶ',
   equipment_id         int not null comment '�豸ID',
   product_id           int not null comment '��ƷID',
   yield                int comment '����',
   unit                 int comment '���ܵ�λ  10����  20����  30����  40��Сʱ',
   factory_id           int not null comment '����ID',
   primary key (id)
);

alter table t_equipment_product comment '�豸���Ʒ��Ӧ��';

/*==============================================================*/
/* Table: t_factory                                             */
/*==============================================================*/
create table t_factory
(
   id                   int not null auto_increment comment '����ID',
   flag                 int default 0 comment '��Ч��ʶ  0:��Ч   1:��Ч',
   create_time          datetime comment '����ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   bak                  varchar(500) comment '��ע',
   factory_name         varchar(500) comment '��������',
   factory_img_url      varchar(500) comment '����ͼƬ',
   factory_addr         varchar(500) comment '������ַ',
   factory_url          varchar(200) comment '������ַ',
   factory_worker       int comment '��������',
   factory_status       int comment '����״̬  0:����  1:�ر�',
   primary key (id)
);

/*==============================================================*/
/* Table: t_order_track                                         */
/*==============================================================*/
create table t_order_track
(
   id                   int not null auto_increment comment 'ID��ʶ',
   flag                 int default 0 comment '��Ч��ʶ 0����Ч  1����Ч',
   create_time          datetime comment '����ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   schedule_id          int comment '����id',
   plan_id              int comment '�ƻ�id',
   product_id           int comment '��Ʒid',
   working_count        int comment '�ӹ�����',
   qualified_count      int default 0 comment '�ϸ���',
   factory_id           int not null comment '����ID',
   primary key (id)
);

alter table t_order_track comment '�������ٱ�';

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
   id                   int not null auto_increment comment 'Ȩ��ID',
   flag                 int default 0 comment '��Ч��ʶ  0:��Ч  1:��Ч',
   status               int comment 'Ȩ��״̬  0:����  1:ͣ��',
   parent_id            int comment 'Ȩ�޸�ID',
   permit_name          varchar(300) comment 'Ȩ������',
   permit_desc          varchar(300) comment 'Ȩ������',
   permit_path          varchar(300) comment 'У���ַ',
   primary key (id)
);

/*==============================================================*/
/* Table: t_product                                             */
/*==============================================================*/
create table t_product
(
   id                   int not null auto_increment comment 'ID��ʶ',
   flag                 int default 0 comment '��Ч��ʶ 0����Ч  1����Ч',
   create_time          datetime comment '����ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   product_num          varchar(200) not null comment '��Ʒ���',
   product_name         varchar(300) not null comment '��Ʒ����',
   product_img_url      varchar(300) comment '��ƷͼƬ����Ŀ¼',
   factory_id           int not null comment '����ID',
   primary key (id)
);

alter table t_product comment '���ڶ����Ʒ';

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
   id                   int not null auto_increment comment 'ID��ʶ',
   flag                 int default 0 comment '��Ч��ʶ  0����Ч  1����Ч',
   create_time          datetime comment '����ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   order_seq            varchar(200) not null comment '�������',
   order_source         int comment '������Դ',
   product_id           int comment '��ƷID',
   product_count        int not null comment '��Ʒ����',
   end_date             date not null comment '������ֹ����',
   order_status         int not null default 10 comment '����״̬ 10��δ�ӵ�  20���ѽӵ�  30���Ѿܾ�  40��������  50���������',
   factory_id           int not null comment '����ID',
   factory_yield        int comment '��������',
   primary key (id)
);

alter table t_product_order comment '������';

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
   id                   int not null auto_increment comment 'ID��ʶ',
   flag                 int default 0 comment '��Ч��ʶ  0����Ч  1����Ч',
   create_time          datetime comment '����ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   plan_seq             varchar(200) comment '�ƻ����',
   order_id             int not null comment '����ID',
   product_id           int not null comment '��ƷID',
   plan_count           int comment '�ƻ�����',
   delivery_date        date comment '��������',
   plan_start_date      date comment '�ƻ���ʼ����',
   plan_end_date        date comment '�ƻ���������',
   plan_status          int default 10 comment '�ƻ�״̬  10��δ����  20��������   30�������',
   factory_id           int not null comment '����ID',
   primary key (id)
);

alter table t_product_plan comment '�����ƻ���';

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
   id                   int not null auto_increment comment 'ID��ʶ',
   flag                 int default 0 comment '��Ч��ʶ  0����Ч  1����Ч',
   create_time          datetime comment '����ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   schedule_seq         varchar(200) comment '�������',
   schedule_count       int comment '��������',
   schedule_status      int not null default 10 comment '����״̬ 10��δ��ʼ   20��������  30�������',
   plan_id              int not null comment '�ƻ�ID',
   product_id           int not null comment '��ƷID',
   equipment_id         int comment '�豸ID',
   start_date           date comment '��ʼ����',
   end_date             date comment '��������',
   factory_id           int not null comment '����ID',
   primary key (id)
);

alter table t_product_schedule comment '�������ȱ�';

/*==============================================================*/
/* Table: t_role_permit                                         */
/*==============================================================*/
create table t_role_permit
(
   id                   int not null auto_increment comment 'ID��ʶ',
   flag                 int default 0 comment '��Ч��ʶ',
   create_time          datetime comment '����ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   factory_id           int comment '����ID',
   role_id              int comment '��ɫID',
   permit_id            int comment 'Ȩ��ID',
   primary key (id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null auto_increment comment '����ID',
   flag                 int default 0 comment '��Ч��ʶ  0����Ч  1����Ч',
   create_time          datetime comment 'ע��ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   user_status          int comment '�û�״̬ 0:����  1������',
   user_name            varchar(50) not null comment '�û���',
   user_real_name       varchar(100) comment '�û�����',
   user_passwd          varchar(100) not null comment '�û�����',
   user_job_num         varchar(100) comment '�û�����',
   user_phone_num       char(11) comment '�û��ֻ���',
   user_email           varchar(100) comment '�û�email',
   role_id              int comment '��ɫID',
   factory_id           int not null comment '����ID',
   primary key (id)
);

alter table t_user comment '�û���';

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   id                   int not null auto_increment comment '��ɫID',
   flag                 int default 0 comment '��Ч��ʶ  0:��Ч  1:��Ч',
   create_time          datetime comment '����ʱ��',
   create_userid        int comment '������ID',
   update_time          datetime comment '�޸�ʱ��',
   update_userid        int comment '�޸���ID',
   role_desc            varchar(500) comment '��ɫ����',
   role_name            varchar(300) comment '��ɫ����',
   role_status          int comment '��ɫ״̬  0:����  1:����',
   factory_id           int comment '����ID',
   primary key (id)
);

