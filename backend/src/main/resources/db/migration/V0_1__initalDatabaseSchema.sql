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
	admin   bit          null,
	logged_in   bit          null,
	name varchar(255) not null,
	user_name  varchar(255) not null
)
engine=MyISAM;

create table order_line
(
  id bigint auto_increment
    primary key,
  quantity   decimal(19, 2) null,
  article_id bigint null,
  order_id   bigint null
)
  engine = MyISAM;

create index FKgyaq7gsm6vugjkw4smqwxsn4b
  on order_line (article_id);

create index FKk9f9t1tmkbq5w27u8rrjbxxg6
  on order_line (order_id);

create table orders
(
  order_id bigint auto_increment
    primary key,
  confirmed bit not null,
  date_of_order datetime null,
  user_id bigint
)
  engine = MyISAM;

create index FKel9kyl84ego2otj2accfd8mr7
  on orders (user_id);