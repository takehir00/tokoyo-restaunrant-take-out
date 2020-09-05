drop table if exists question;
create table question
    (id int not null primary key AUTO_INCREMENT,
    title varchar(100) not null,
    text varchar(10000),
    sender_mail_address varchar(1000) not null,
    resolved_flg boolean not null,
    created_at datetime,
    updated_at datetime);