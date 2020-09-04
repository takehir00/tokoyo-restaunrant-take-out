drop table menu;
create table menu
    (id int not null primary key AUTO_INCREMENT,
    name varchar(100),
    price int,
    image MEDIUMTEXT,
    mime_type varchar(100),
    restaurant_id int,
    priority int,
    created_at datetime,
    updated_at datetime);