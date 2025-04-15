create table tbl_online(
    id bigint auto_increment primary key,
    market_name varchar(255) not null,
    constraint fk_online_product foreign key(id)
    references tbl_product(id)
);

select * from tbl_online;

create or replace view view_online as
(
    select o.id, product_name, product_price, product_stock, market_name, createdDate, updatedDate, status
    from tbl_product p join tbl_online o
    on p.id = o.id
);

/*limit [개수]*/
/*limit [개수] offset [시작인덱스]*/
/*limit [시작인덱스], [개수] */
select * from view_online
order by id desc
limit 2, 2;
















