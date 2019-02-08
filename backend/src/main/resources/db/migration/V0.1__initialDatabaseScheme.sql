-- we don't know how to generate schema shopr (class Schema) :(
create table book
(
	author varchar(255) null,
	isbn varchar(255) null,
	pages int null,
	id bigint not null
		primary key
)
engine=MyISAM
;

create table cart
(
	id bigint not null
		primary key,
	total_price double not null,
	user_id bigint null
)
engine=MyISAM
;

create index FKl70asp4l4w0jmbm1tqyofho4o
	on cart (user_id)
;

create table cartitem
(
	id bigint not null
		primary key,
	price double not null,
	quantity int not null,
	cart_id bigint null,
	product_id bigint null
)
engine=MyISAM
;

create index FK1h6e1eb88o4qyku4y34inyr72
	on cartitem (product_id)
;

create index FKcj0jvvlv7mum72m5qblw5m1tc
	on cartitem (cart_id)
;

create table fiction
(
	genre int null,
	summary varchar(255) null,
	id bigint not null
		primary key
)
engine=MyISAM
;

create table game
(
	editor varchar(255) null,
	genre int null,
	pegi_rating int not null,
	id bigint not null
		primary key
)
engine=MyISAM
;

create table hibernate_sequence
(
	next_val bigint null
)
engine=MyISAM
;

create table lp
(
	genre int null,
	performer varchar(255) null,
	id bigint not null
		primary key
)
engine=MyISAM
;

create table non_fiction
(
	genre int null,
	id bigint not null
		primary key
)
engine=MyISAM
;

create table product
(
	type varchar(31) not null,
	id bigint not null
		primary key,
	price double not null,
	supplier_id varchar(255) null,
	title varchar(255) null
)
engine=MyISAM
;

create table role
(
	role_id int auto_increment
		primary key,
	role varchar(255) null
)
engine=MyISAM
;

create table user
(
	id bigint auto_increment
		primary key,
	active bit null,
	firstname varchar(255) null,
	lastname varchar(255) null,
	password varchar(255) null,
	username varchar(255) null,
	cart_id bigint null
)
engine=MyISAM
;

create index FKtqa69bib34k2c0jhe7afqsao6
	on user (cart_id)
;

create table user_role
(
	user_id bigint not null,
	role_id int not null,
	primary key (user_id, role_id)
)
engine=MyISAM
;

create index FKa68196081fvovjhkek5m97n3y
	on user_role (role_id)
;

