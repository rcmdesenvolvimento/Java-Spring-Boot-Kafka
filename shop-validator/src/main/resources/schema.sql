create schema if not exists shop_validator;

create table shop_validator.product(
	id bigserial primary key,
	product_identifier varchar(100) not null,
	amount int not null
);