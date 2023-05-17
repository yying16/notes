drop
    database if exists notes;
create
    database notes;
use
    notes;

create table t_user
(
    account     varchar(30) not null comment '账号',
    password    varchar(30) not null comment '密码',
    username    varchar(30) not null comment '用户名',
    telephone   varchar(30) not null comment '手机号码',
    email       varchar(50) not null comment '邮箱',
    user_groups text comment '分组',
    primary key (account)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
create index index_account on t_user (account ASC);

insert into t_user(account, password, username, telephone, email)
values ('zhangsan', 'zs123456', '张三', '15915712354', 'zhangsan@163.com'),
       ('lisi', 'ls123456', '李四', '13430241235', 'lisi@qq.com'),
       ('wangwu', 'ww123456', '王五', '13645236589', 'wangwu@163.com'),
       ('chenliu', 'cl123456', '陈六', '13316397963', 'chenliu@163.com'),
       ('xuqi', 'xq123456', '许七', '13352679568', 'xuqi@163.com'),
       ('maba', 'mb123456', '马八', '13654879632', 'maba@163.com'),
       ('zhengjiu', 'zj123456', '郑九', '13912546983', 'zhengjiu@163.com'),
       ('huangshi', 'hs123456', '黄十', '15815632498', 'huangshi@163.com');

drop table if exists t_notes;
CREATE TABLE t_notes
(
    notes_id    int auto_increment comment '错题编号',
    notes_title varchar(50) not null comment '错题标题',
    promulgator varchar(30) not null comment '发布者账号',
    priority    varchar(10)         default '' comment '优先级',
    subject     text comment '错题内容',
    answer      text comment '标准答案',
    respond     text comment '我的答案',
    summary     text comment '错题内容',
    notes_group varchar(30) default '' comment '错题分组',
    deleted     boolean     default false comment '是否删除',
    update_time datetime    default now() comment '更新时间',
    PRIMARY KEY (notes_id),
    foreign key (promulgator) references t_user (account)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
create index index_notes_id on t_notes (notes_id ASC);

insert into t_notes(notes_title, promulgator, subject, answer, respond, summary)
values ('1+1=?', 'zhangsan', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'zhangsan', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'lisi', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'zhangsan', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'lisi', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'wangwu', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'zhangsan', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'zhangsan', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'wangwu', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'wangwu', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'zhangsan', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'zhangsan', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'lisi', '1+1=2', '2', '1', '1+1=2'),
       ('1+1=?', 'wangwu', '1+1=2', '2', '1', '1+1=2');

drop table if exists t_photo;
CREATE TABLE t_photo
(
    photo_id     int auto_increment primary key,
    photo_source varchar(50) not null,
    photo_name   varchar(50) not null,
    photo_type   varchar(10)
);