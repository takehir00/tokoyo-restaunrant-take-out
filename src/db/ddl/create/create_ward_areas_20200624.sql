drop table ward_area;
create table ward_area
    (id int not null primary key AUTO_INCREMENT,
    name varchar(100),
    image MEDIUMTEXT,
    mime_type varchar(100),
    ward_id int not null,
    created_at datetime,
    updated_at datetime,
    FOREIGN KEY (ward_id)
        references ward(id)
    );