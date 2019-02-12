-- we don't know how to generate root <with-no-name> (class Root) :(
create table shopr.article
(
	type varchar(31) not null,
	article_id bigint auto_increment
		primary key,
	price decimal(8,2) not null,
	id_supplier varchar(100) not null,
	title varchar(100) not null
)
engine=MyISAM;

create table shopr.book
(
	author varchar(100) null,
	book_type varchar(255) null,
	isbn varchar(17) not null,
	nr_of_pages int null,
	article_id bigint not null
		primary key,
	constraint UK_BOOK_ISBN_UNIQ
		unique (isbn)
)
engine=MyISAM;

create table shopr.fiction
(
	fiction_genre varchar(255) null,
	short_summary varchar(255) null,
	article_id bigint not null
		primary key
)
engine=MyISAM;

create table shopr.game
(
	game_genre varchar(255) null,
	minimum_age int null,
	publisher varchar(100) null,
	article_id bigint not null
		primary key
)
engine=MyISAM;

create table shopr.lp
(
	lp_genre varchar(255) null,
	publisher varchar(100) null,
	article_id bigint not null
		primary key
)
engine=MyISAM;

create table shopr.non_fiction
(
	non_fiction_subject varchar(255) null,
	article_id bigint not null
		primary key
)
engine=MyISAM;

create table shopr.user
(
	id bigint auto_increment
		primary key,
	first_name varchar(255) not null,
	name varchar(255) not null
)
engine=MyISAM;