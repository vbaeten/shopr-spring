create table users (
  id         bigint not null AUTO_INCREMENT,
  first_name varchar(255),
  last_name  varchar(255),
  user_name  varchar(255),
  primary key (id)
);

create table book (
  id         bigint not null,
  author     VARCHAR(255),
  isbn       VARCHAR(255),
  total_pages smallint,
  primary key (id)

);

create table fiction (
  book_genre VARCHAR(255),
  preview   VARCHAR(255),
  id        bigint not null,
  PRIMARY KEY (id)
);

create table games (
  genre     VARCHAR(255),
  min_age    smallint,
  publisher VARCHAR(255),
  id        BIGINT NOT NULL,
  PRIMARY KEY (id)
);

create table items (

  type  VARCHAR(31),
  id    bigint not null AUTO_INCREMENT,
  price double,
  title VARCHAR(100),
  primary key (id)

);

create table item_review (

  id          bigint not null,
  description VARCHAR(255),
  score       smallint,
  primary key (id)
);

create table lps (
  genre VARCHAR(255),
  publisher VARCHAR(255),
  id bigint not null,
  primary key (id)
);

create table non_fiction(

  subject VARCHAR(255),
  id bigint not null,
  primary key (id)
);

create table order_line(
  id bigint not null,
  quantity smallint,
  primary key (id)
);

create table orders(
  id bigint not null,
  date DATETIME,
  total_price double,
  primary key (id)

);
