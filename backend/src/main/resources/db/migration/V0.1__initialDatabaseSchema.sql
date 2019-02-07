-- we don't know how to generate root <with-no-name> (class Root) :(
create table shopr2.article
(
  type varchar(31) not null,
  id bigint not null
    primary key,
  supplier varchar(255) null,
  price double null,
  title varchar(255) null
)
  engine=MyISAM;

create table shopr2.book
(
  author varchar(255) null,
  isbn bigint not null,
  pages int not null,
  id bigint not null
    primary key
)
  engine=MyISAM;

create table shopr2.fiction
(
  genre int null,
  synopsis varchar(255) null,
  id bigint not null
    primary key
)
  engine=MyISAM;

create table shopr2.game
(
  genre int null,
  min_age int null,
  publisher varchar(255) null,
  id bigint not null
    primary key
)
  engine=MyISAM;

create table shopr2.hibernate_sequence
(
  next_val bigint null
)
  engine=MyISAM;

create table shopr2.lp
(
  artist varchar(255) null,
  genre int null,
  id bigint not null
    primary key
)
  engine=MyISAM;

create table shopr2.non_fiction
(
  subject int null,
  id bigint not null
    primary key
)
  engine=MyISAM;

create table shopr2.order_line
(
  id bigint not null
    primary key,
  quantity int not null,
  sub_total double not null,
  article_id bigint null,
  order_id bigint null
)
  engine=MyISAM;

create index FKgyaq7gsm6vugjkw4smqwxsn4b
  on shopr2.order_line (article_id);

create index FKk9f9t1tmkbq5w27u8rrjbxxg6
  on shopr2.order_line (order_id);

create table shopr2.orders
(
  id bigint not null
    primary key,
  order_date datetime null,
  user_id bigint null
)
  engine=MyISAM;

create index FKel9kyl84ego2otj2accfd8mr7
  on shopr2.orders (user_id);

create table shopr2.rating
(
  id bigint not null
    primary key,
  description varchar(255) null,
  score int not null,
  article_id bigint null,
  user_id bigint null
)
  engine=MyISAM;

create index FKff3wnj5681kqa2tdaimkkhx7b
  on shopr2.rating (article_id);

create index FKpn05vbx6usw0c65tcyuce4dw5
  on shopr2.rating (user_id);

create table shopr2.user
(
  id bigint auto_increment
    primary key,
  first_name varchar(255) null,
  name varchar(255) null
)
  engine=MyISAM;
