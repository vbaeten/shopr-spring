insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (2000, 'Rumours', 10, 'LP Studio', 'lp', 1);
insert into shopr.lp(article_id, artist, lp_genre) VALUES (2000, 'Fleetwood Mac', 'ROCK');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (2001, 'All Killer No Filler', 8, 'LP Studio', 'lp', 1);
insert into shopr.lp(article_id, artist, lp_genre) VALUES (2001, 'Sum41', 'ROCK');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (2002, 'Duck Hunt', 12.99, 'Gamewalhalla', 'game', 1);
insert into shopr.game(article_id, game_genre, minimum_age, publisher) VALUES (2002, 'RTS', 6, 'Nintendo');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (2003, 'The Sims', 10.99, 'Gamesync', 'game', 1);
insert into shopr.game(article_id, game_genre, minimum_age, publisher) VALUES (2003, 'RACE', 7, 'Electronic Arts');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (2004, 'War and Peace', 22, 'Penguin Books Ltd', 'bookfiction', 1);
insert into shopr.book(article_id, author, isbn, number_of_pages ) VALUES (2004, 'Leo Tolstoy', '978-02-4126-554-3', 1440);
insert into shopr.bookfiction (article_id, bookfiction_genre, summary)
VALUES (2004, 'THRILLER', 'Summary');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (2005, 'The clan of the cave bear', 16.16, 'Crown Publishing Group', 'bookfiction', 1);
insert into shopr.book(article_id, author, isbn, number_of_pages ) VALUES (2005, 'Jean M. Auel', '978-05-5338-167-2', 468);
insert into shopr.bookfiction (article_id, bookfiction_genre, summary)
VALUES (2005, 'THRILLER', 'Summary');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (2006, 'The Vegetable Butcher', 20.36, 'Workman Publishing New York', 'booknonfiction', 1);
insert into shopr.book(article_id, author, isbn, number_of_pages ) VALUES (2006, 'Cara Mangini', '978-07-6118-052-4', 352);
insert into shopr.booknonfiction (article_id, booknonfiction_genre)
VALUES (2006, 'COOKBOOK');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (2007, 'Long walk to freedom', 16.99, 'Little, Brown & Company', 'booknonfiction', 1);
insert into shopr.book(article_id, author, isbn, number_of_pages ) VALUES (2007, 'Nelson Mandela', '978-03-1654-818-2', 656);
insert into shopr.booknonfiction (article_id, booknonfiction_genre)
VALUES (2007, 'BIOGRAPHY');
