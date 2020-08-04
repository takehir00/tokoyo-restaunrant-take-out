drop table restaurant;
create table restaurant
    (id int not null primary key AUTO_INCREMENT,
     name varchar(100) not null,
     address varchar(1000),
     phone_number varchar(100),
     image MEDIUMTEXT,
     mime_type varchar(100),
     introduction varchar(2000),
     genre_id int,
     from_time varchar(10),
     to_time varchar(10),
     ward_id int not null,
     created_at datetime,
         updated_at datetime,
         FOREIGN KEY (ward_id)
             references ward(id)
    );