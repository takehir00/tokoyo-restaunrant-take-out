drop table ward;
create table ward
    (id int not null primary key AUTO_INCREMENT,
    name varchar(100),
    image varchar(10000),
    created_at datetime,
    updated_at datetime);