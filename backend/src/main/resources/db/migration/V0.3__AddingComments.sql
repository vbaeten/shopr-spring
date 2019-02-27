create table comments
(
	id bigint not null
		primary key,
	description varchar(255) null,
	product_id bigint null,
	user_id bigint null
)
engine=MyISAM
;

create index FKj9to9e3tjoimlgn3w4vjm4xe3
	on comments (product_id)
;

create index FKqi14bvepnwtjbbaxm7m4v44yg
	on comments (user_id)
;

create table favorite_product
(
	id bigint not null
		primary key,
	product_id bigint null,
	user_id bigint null
)
engine=MyISAM
;

create index FK2lg2xrrb5c14y0s8hwoyn783n
	on favorite_product (product_id)
;

create index FK77loqyqxss454wdhhyhuatyfx
	on favorite_product (user_id)
;

create table ratings
(
	id bigint not null
		primary key,
	rating double not null,
	product_id bigint null,
	user_id bigint null
)
engine=MyISAM
;

create index FKgd4laqdp3puv1bxgmh62tj8hn
	on ratings (user_id)
;