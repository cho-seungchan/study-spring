create table tbl_product(
    id bigint auto_increment primary key,
    product_name varchar(255) not null,
    product_price int default 0,
    product_stock int default 0
);

alter table tbl_product add createdDate datetime default current_timestamp;
alter table tbl_product add updatedDate datetime default current_timestamp;
alter table tbl_product add status varchar(255) default 'enable';

select * from tbl_product;
