create schema if not exists shop;

create table shop.shop(
	id bigserial primary key,
	identifier varchar(100) not null,
	status varchar(20) not null,
	date_shop date
);

create table shop.shop_item(
	id bigserial primary key,
	product_identifier varchar(100) not null,
	amount int not null,
	price float not null,
	shop_id bigint REFERENCES shop(id)
);