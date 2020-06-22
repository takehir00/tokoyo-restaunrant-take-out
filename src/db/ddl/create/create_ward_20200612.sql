drop table ward;
create table ward
    (id int not null primary key AUTO_INCREMENT,
    name varchar(100),
    image MEDIUMTEXT,
    mime_type varchar(100),
    created_at datetime,
    updated_at datetime);