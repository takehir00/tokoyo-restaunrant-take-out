drop table if exists client_account;
create table client_account
    (id int not null primary key AUTO_INCREMENT,
    email varchar(100) unique not null,
    password varchar(1000),
    name varchar(100),
    image_url varchar(1000),
    created_at datetime,
    updated_at datetime);