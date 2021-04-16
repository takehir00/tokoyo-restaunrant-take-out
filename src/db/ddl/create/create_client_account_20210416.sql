drop table if exists client_account;
create table client_account
    (id int not null primary key AUTO_INCREMENT,
    name varchar(100) unique not null,
    password varchar(1000) unique not null,
    created_at datetime,
    updated_at datetime);