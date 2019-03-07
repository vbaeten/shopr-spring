create table article
(
  type        varchar(31)  not null,
  id          bigint auto_increment
    primary key,
  distributor varchar(255) null,
  price       int          not null,
  title       varchar(255) null
)
  engine = MyISAM;

create table book
(
  author   varchar(255) null,
  isbn     varchar(255) null,
  nr_pages int          not null,
  id       bigint       not null
    primary key
)
  engine = MyISAM;

create table fiction
(
  fiction_genre_enum varchar(255) null,
  id                 bigint       not null
    primary key
)
  engine = MyISAM;

create table game
(
  age             int          not null,
  game_genre_enum varchar(255) null,
  studio          varchar(255) null,
  id              bigint       not null
    primary key
)
  engine = MyISAM;

create table lp
(
  artist        varchar(255) null,
  lp_genre_enum varchar(255) null,
  id            bigint       not null
    primary key
)
  engine = MyISAM;

create table non_fiction
(
  about                  varchar(255) null,
  non_fiction_genre_enum varchar(255) null,
  id                     bigint       not null
    primary key
)
  engine = MyISAM;

create table order_from_shop
(
  id          bigint auto_increment
    primary key,
  order_date  datetime     null,
  order_state varchar(255) null,
  user_id     bigint       null
)
  engine = MyISAM;

create index FKl8rt4re2e67sovw42vgp3hqtj
  on order_from_shop (user_id);

create table order_line
(
  id                 bigint auto_increment
    primary key,
  amount             int    not null,
  price_order_date   int    not null,
  article_id         bigint null,
  order_from_shop_id bigint null,
  order_id           bigint null
)
  engine = MyISAM;

create index FKgyaq7gsm6vugjkw4smqwxsn4b
  on order_line (article_id);

create index FKrtfhj7o4bvd7kshkpx09af99u
  on order_line (order_id);

create index FKsxmefferxg87j27yah1em0wf0
  on order_line (order_from_shop_id);

create table rating
(
  id      bigint auto_increment
    primary key,
  comment varchar(255) null,
  score   int          not null
)
  engine = MyISAM;

create table user
(
  id             bigint auto_increment
    primary key,
  first_name     varchar(255) null,
  last_name      varchar(255) null,
  user_role_enum varchar(255) null
)
  engine = MyISAM;

create table user_article_list
(
  user_id         bigint not null,
  article_list_id bigint not null
)
  engine = MyISAM;

create index FK76ce5t29linrc8stwfrc03rpy
  on user_article_list (article_list_id);

create index FKctw6lf0wu8ikrlp4hr53gq0cn
  on user_article_list (user_id);

create table user_rating_list
(
  user_id        bigint not null,
  rating_list_id bigint not null
)
  engine = MyISAM;

create index FK2ul8rbpb4d2veaidoyf21c3ke
  on user_rating_list (user_id);

create index FKmx7rl5j25ll6swyx70yfm3unc
  on user_rating_list (rating_list_id);

