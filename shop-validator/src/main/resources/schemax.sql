create table product(
	id serial primary key,
	product_identifier varchar(100) not null,
	amount int not null
);