
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (1,"12345",49.99,"WoW", "game");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (2,"12346",59.99,"WoW2", "game");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (3,"12347",44.99,"GTA", "game");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (4,"12348",99.99,"Super Mario", "game");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (5,"12349",49.99,"Need For Speed", "game");

INSERT INTO game(articleId, game_genre, minimum_age, publisher) VALUES (1,"RPG",12,"Blizzard");
INSERT INTO game(articleId, game_genre, minimum_age, publisher) VALUES (2,"MMORPG",14,"Blizzard1");
INSERT INTO game(articleId, game_genre, minimum_age, publisher) VALUES (3,"FPS",18,"Rockstar");
INSERT INTO game(articleId, game_genre, minimum_age, publisher) VALUES (4,"RTS",10,"Nintendo");
INSERT INTO game(articleId, game_genre, minimum_age, publisher) VALUES (5,"RACE",16,"Playstation");


INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (11,"123456",9.99,"Top Classics", "lp");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (12,"123457",12.99,"Top 50 Pop", "lp");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (13,"123458",8.99,"Top 20 Rock", "lp");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (14,"123459",10.99,"Top 50 Dance", "lp");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (15,"123460",19.99,"R&B Top 100", "lp");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (16,"123461",13.99,"Hiphop Top 50", "lp");

INSERT INTO lp(articleId, lpGenre, publisher) VALUES (11,"CLASSIC", "uitv1");
INSERT INTO lp(articleId, lpGenre, publisher) VALUES (12,"POP", "uitv2");
INSERT INTO lp(articleId, lpGenre, publisher) VALUES (13,"ROCK", "uitv3");
INSERT INTO lp(articleId, lpGenre, publisher) VALUES (14,"DANCE", "uitv4");
INSERT INTO lp(articleId, lpGenre, publisher) VALUES (15,"RNB", "uitv5");
INSERT INTO lp(articleId, lpGenre, publisher) VALUES (16,"HIPHOP", "uitv6");


INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (101,"1234561",12.99,"Beste Thriller", "fiction");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (102,"1234562",8.99,"Beste Fantasy", "fiction");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (103,"1234563",9.99,"Beste Detective", "fiction");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (104,"1234564",7.99,"Beste Romance", "fiction");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (105,"1234563",11.99,"Beste Sci-fi", "fiction");

INSERT INTO book(articleId, nr_of_pages, author, isbn) VALUES (101,100,"Markske","514-15-5444-356-5");
INSERT INTO book(articleId, nr_of_pages, author, isbn) VALUES (102,105,"Jommeke","514-15-1586-356-5");
INSERT INTO book(articleId, nr_of_pages, author, isbn) VALUES (103,150,"Jeromeke","514-15-3218-356-5");
INSERT INTO book(articleId, nr_of_pages, author, isbn) VALUES (104,125,"Tommeke","514-15-8941-356-5");
INSERT INTO book(articleId, nr_of_pages, author, isbn) VALUES (105,200,"Janneke","514-15-3546-356-5");

INSERT INTO fiction(articleId, fiction_genre, short_summary) VALUES (101,"THRILLER","korte inhoud1 blablablablablabla");
INSERT INTO fiction(articleId, fiction_genre, short_summary) VALUES (102,"FANTASY","korte inhoud2 blablablablablabla");
INSERT INTO fiction(articleId, fiction_genre, short_summary) VALUES (103,"DETECTIVE","korte inhoud3 blablablablablabla");
INSERT INTO fiction(articleId, fiction_genre, short_summary) VALUES (104,"ROMANCE","korte inhoud4 blablablablablabla");
INSERT INTO fiction(articleId, fiction_genre, short_summary) VALUES (105,"SCIFI","korte inhoud5 blablablablablabla");


INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (1001,"12345671",19.99,"Beste Geschiedenis", "nonFiction");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (1002,"12345672",7.99,"Beste Kookboek", "nonFiction");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (1003,"12345672",14.99,"Beste Wetenschap", "nonFiction");
INSERT INTO article(articleId, ID_supplier, price, title, TYPE) VALUES (1004,"12345671",12.99,"Beste Sport", "nonFiction");

INSERT INTO book(articleId, nr_of_pages, author, isbn) VALUES (1001,550,"Markske","514-15-8465-356-5");
INSERT INTO book(articleId, nr_of_pages, author, isbn) VALUES (1002,50,"Jommeke","514-15-1561-356-5");
INSERT INTO book(articleId, nr_of_pages, author, isbn) VALUES (1003,250,"Jeromeke","514-15-6515-356-5");
INSERT INTO book(articleId, nr_of_pages, author, isbn) VALUES (1004,125,"Tommeke","514-15-8974-356-5");

INSERT INTO non_fiction(articleId, non_fiction_subject) VALUES (1001,"HISTORY");
INSERT INTO non_fiction(articleId, non_fiction_subject) VALUES (1002,"COOKING");
INSERT INTO non_fiction(articleId, non_fiction_subject) VALUES (1003,"SCIENCE");
INSERT INTO non_fiction(articleId, non_fiction_subject) VALUES (1004,"SPORTS");


