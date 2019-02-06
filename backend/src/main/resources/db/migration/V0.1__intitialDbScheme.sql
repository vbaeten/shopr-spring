create table article
(
	type varchar(31) not null,
	article_id bigint auto_increment
		primary key,
	version_id bigint null,
	price double not null,
	supplier_id varchar(100) null,
	title varchar(100) null
)
engine=MyISAM
;

create table book
(
	author varchar(100) null,
	isbn varchar(20) null,
	number_of_pages int null,
	article_id bigint not null
		primary key,
	constraint UK_ehpdfjpu1jm3hijhj4mm0hx9h
		unique (isbn)
)
engine=MyISAM
;

create table bookfiction
(
	bookfiction_genre varchar(255) null,
	summary varchar(255) null,
	article_id bigint not null
		primary key
)
engine=MyISAM
;

create table booknonfiction
(
	booknonfiction_genre varchar(255) null,
	article_id bigint not null
		primary key
)
engine=MyISAM
;

create table game
(
	game_genre varchar(255) null,
	minimum_age int null,
	publisher varchar(255) null,
	article_id bigint not null
		primary key
)
engine=MyISAM
;

create table lp
(
	artist varchar(255) null,
	lp_genre varchar(255) null,
	article_id bigint not null
		primary key
)
engine=MyISAM
;

create table user
(
	user_id bigint auto_increment
		primary key,
	version_id bigint null,
	admin bit not null,
	first_name varchar(255) null,
	last_name varchar(255) null,
	logged_on bit not null,
	user_name varchar(50) null,
	constraint UK_lqjrcobrh9jc8wpcar64q1bfh
		unique (user_name)
)
engine=MyISAM
;

