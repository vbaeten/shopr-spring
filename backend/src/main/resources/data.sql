insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (1000, 'Rumours', 10, 'LP Studio', 'lp', 1);
insert into shopr.lp(article_id, artist, lpgenre) VALUES (1000, 'Fleetwood Mac', 'ROCK');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (1001, 'All Killer No Filler', 8, 'LP Studio', 'lp', 1);
insert into shopr.lp(article_id, artist, lpgenre) VALUES (1001, 'Sum41', 'ROCK');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (1002, 'Duck Hunt', 12.99, 'Gamewalhalla', 'game', 1);
insert into shopr.game(article_id, gameGenre, minimum_age, publisher) VALUES (1002, 'RTS', 6, 'Nintendo');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (1003, 'The Sims', 10.99, 'Gamesync', 'game', 1);
insert into shopr.game(article_id, gameGenre, minimum_age, publisher) VALUES (1003, 'RACE', 7, 'Electronic Arts');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (1004, 'War and Peace', 22, 'Penguin Books Ltd', 'bookfiction', 1);
insert into shopr.book(article_id, author, isbn, number_of_pages ) VALUES (1004, 'Leo Tolstoy', '978-02-4126-554-3', 1440);
insert into shopr.bookfiction(article_id, bookfictiongenre, summary) VALUES (1004,'THRILLER','Summary');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (1005, 'The clan of the cave bear', 16.16, 'Crown Publishing Group', 'bookfiction', 1);
insert into shopr.book(article_id, author, isbn, number_of_pages ) VALUES (1005, 'Jean M. Auel', '978-05-5338-167-2', 468);
insert into shopr.bookfiction(article_id, bookfictiongenre, summary) VALUES (1005, 'THRILLER', 'Summary');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (1006, 'The Vegetable Butcher', 20.36, 'Workman Publishing New York', 'booknonfiction', 1);
insert into shopr.book(article_id, author, isbn, number_of_pages ) VALUES (1006, 'Cara Mangini', '978-07-6118-052-4', 352);
insert into shopr.booknonfiction(article_id, booknonfictiongenre) VALUES (1006, 'COOKBOOK');

insert into shopr.article(article_id, title, price, supplier_id, type, version_id) VALUES (1007, 'Long walk to freedom', 16.99, 'Little, Brown & Company', 'booknonfiction', 1);
insert into shopr.book(article_id, author, isbn, number_of_pages ) VALUES (1007, 'Nelson Mandela', '978-03-1654-818-2', 656);
insert into shopr.booknonfiction(article_id, booknonfictiongenre) VALUES (1007, 'BIOGRAPHY');
