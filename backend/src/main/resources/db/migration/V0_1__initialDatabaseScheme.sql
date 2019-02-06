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
	price varchar(255) null,
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
	id bigint not null
		primary key,
	active bit null,
	firstname varchar(255) null,
	lastname varchar(255) null,
	password varchar(255) null,
	username varchar(255) null
)
engine=MyISAM
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

