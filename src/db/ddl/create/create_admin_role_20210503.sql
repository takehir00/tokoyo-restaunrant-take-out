drop table if exists admin_role;
create table admin_role
    (id int not null primary key AUTO_INCREMENT,
    name varchar(100) unique not null,
    created_at datetime,
    updated_at datetime);