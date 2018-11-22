DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS productCategory;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS orders;

CREATE TABLE products(
id serial primary key not null,
name varchar(50) not null,
description varchar(120),
category varchar(20) not null,
price real not null,
currency varchar(10) not null,
supplier varchar(20) not null
);

CREATE TABLE suppliers(
id serial primary key not null,
name varchar(50) not null,
description varchar(80)
);

CREATE TABLE productCategory(
id serial primary key not null,
name varchar(50) not null,
description varchar(120),
departement varchar(20)
);

CREATE TABLE users(
id serial primary key not null,
name varchar(50) not null,
email varchar(50) not null,
password varchar(20) not null,
mobile varchar(15),
billing_address varchar(80),
shipping_address varchar(80)
);

CREATE TABLE orders(
id serial primary key not null,
order_date date not null,
order_status varchar(20) not null,
total_price integer not null,
product_list varchar(80)
);