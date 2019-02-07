INSERT INTO user(id, name, first_name) VALUES (1, 'Seresia', 'Laura');
INSERT INTO user(id, name, first_name) VALUES (2, 'Van Gucht', 'Marc');
INSERT INTO user(id, name, first_name) VALUES (3, 'Sanz', 'Bernadette');
INSERT INTO user(id, name, first_name) VALUES (4, 'Demeulenaere', 'Mitch');
INSERT INTO user(id, name, first_name) VALUES (5, 'Van Gucht', 'Ines');
INSERT INTO user(id, name, first_name) VALUES (6, 'Van Gucht', 'Laurens');
INSERT INTO user(id, name, first_name) VALUES (7, 'Debruyne', 'Karel');
INSERT INTO user(id, name, first_name) VALUES (8, 'De Clercq', 'Ellis');

INSERT INTO article(id, title, price, supplier, type) VALUES (1, 'Zelda', 59, 'Dreamland', 'Game');
INSERT INTO article(id, title, price, supplier, type) VALUES (2, 'Mitch Date Life', 130, 'De Eenhoorn', 'Non-Fiction');
INSERT INTO article(id, title, price, supplier, type) VALUES (3, 'OK Computer', 59, 'TechData', 'Lp');
INSERT INTO article(id, title, price, supplier, type) VALUES (4, 'The Cider House Rules', 59, 'Dreamland', 'Fiction');
INSERT INTO article(id, title, price, supplier, type) VALUES (5, 'Song of Solomon', 59, 'Dreamland', 'Fiction');
INSERT INTO article(id, title, price, supplier, type) VALUES (6, 'AC Origins', 59, 'Dreamland', 'Game');
INSERT INTO article(id, title, price, supplier, type) VALUES (7, 'Star Wars', 59, 'Dreamland', 'Game');
INSERT INTO article(id, title, price, supplier, type) VALUES (8, 'Nopi', 59, 'Dreamland', 'Non-Fiction');
INSERT INTO article(id, title, price, supplier, type) VALUES (9, 'Glassworks', 59, 'Dreamland', 'Lp');
INSERT INTO article(id, title, price, supplier, type) VALUES (10, 'We Are Born', 59, 'Dreamland', 'Lp');

INSERT INTO game(id, publisher, min_age, genre) VALUES (1, 'Nintendo', 8, '2');
INSERT INTO game(id, publisher, min_age, genre) VALUES (6, 'Ubisoft', 12, '3');
INSERT INTO game(id, publisher, min_age, genre) VALUES (7, 'EA', 12, '0');

INSERT INTO lp(id, artist, genre) VALUES (3, 'Radiohead', '2');
INSERT INTO lp(id, artist, genre) VALUES (9, 'Philip Glass', '0');
INSERT INTO lp(id, artist, genre) VALUES (10, 'Sia', '1');

INSERT INTO book(id, author, isbn, pages) VALUES (2, 'Mitch Demeulenaere',111, 1800);
INSERT INTO book(id, author, isbn, pages) VALUES (4, 'John Irving',111, 1800);
INSERT INTO book(id, author, isbn, pages) VALUES (5, 'Toni Morrison', 111, 80);
INSERT INTO book(id, author, isbn, pages) VALUES (8, 'Yotam Ottolenghi', 111, 80);

INSERT INTO fiction(id, genre, synopsis) VALUES (4, '1', 'A young man is taught medicine by the doctor at the orphanage where he was brought up. However, when he clashes with his mentor over the issue of abortion, he leaves the home and finds work on a cider farm.');
INSERT INTO fiction(id, genre, synopsis) VALUES (5, '3', 'Set in an unknown city in Michigan. One of the first characters we encounter is Robert Smith, a member of the Seven Days, a society of black men who reciprocate every unpunished murder of a black person by murdering a white person in a similar way.');

INSERT INTO non_fiction(id, subject) VALUES (2, '2');
INSERT INTO non_fiction(id, subject) VALUES (8, '1');