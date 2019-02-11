create table shopr.orderline
(
	orderline_id bigint auto_increment
		primary key,
	quantity bigint not null,
	sub_total double null,
	total_price double null,
	article_article_id bigint null
)
engine=MyISAM
;

create index FKeikbraxeyrsjt5uaroi9wyhyi
	on shopr.orderline (article_article_id)
;

