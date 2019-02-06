-- we don't know how to generate schema shoprangular (class Schema) :(
create table book
(
	id bigint not null
		primary key,
	author varchar(255) null,
	isbn varchar(255) null,
	total_pages smallint(6) null
)
;

create table fiction
(
	book_genre varchar(255) null,
	preview varchar(255) null,
	id bigint not null
		primary key
)
;

create table games
(
	genre varchar(255) null,
	min_age smallint(6) null,
	publisher varchar(255) null,
	id bigint not null
		primary key
)
;

create table item_review
(
	id bigint not null
		primary key,
	description varchar(255) null,
	score smallint(6) null
)
;

create table items
(
	type varchar(31) null,
	id bigint auto_increment
		primary key,
	price double null,
	title varchar(100) null
)
;

create table lps
(
	genre varchar(255) null,
	publisher varchar(255) null,
	id bigint not null
		primary key
)
;

create table non_fiction
(
	subject varchar(255) null,
	id bigint not null
		primary key
)
;

create table order_line
(
	id bigint not null
		primary key,
	quantity smallint(6) null
)
;

create table orders
(
	id bigint not null
		primary key,
	date datetime null,
	total_price double null
)
;

create table users
(
	id bigint auto_increment
		primary key,
	first_name varchar(255) null,
	last_name varchar(255) null,
	user_name varchar(255) null
)
;

