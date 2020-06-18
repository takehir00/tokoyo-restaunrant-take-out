drop table menu;
create table menu
    (id int not null AUTO_INCREMENT,
    name varchar(100),
    price int,
    image varchar(10000),
    restaurant_id int,
    priority int,
    created_at datetime,
    updated_at datetime);