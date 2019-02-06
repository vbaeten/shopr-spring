INSERT INTO  user (id, active, username, firstname, lastname, password) VALUES (1000, true, 'jdoe', 'John', 'Doe', '$2a$10$ckFULcsmnz2Nw/lDLh0ApuVI4L6wxOUc79g7403jtSgp2SNM4wd4a'); #123456
INSERT INTO  user (id, active, username, firstname, lastname, password) VALUES (2000, true, 'ndoe', 'Nancy', 'Doe', '$2a$10$1vySPJT4f6aDJLAFKJtvl.2qhIFlpY314ItTA9trNSOI0Y2QNJC4K'); #pass123

REPLACE INTO `role` VALUES (0,'GUEST');
REPLACE INTO `role` VALUES (1,'ADMIN');
REPLACE INTO `role` VALUES (2,'CUSTOMER');

INSERT  user_role values (1000,1);
INSERT  user_role values (2000,2);

INSERT INTO product (id, title, supplier_id, price, type) VALUES (1001, 'Thriller Book', 'Best Thrillers', 39.99, 'fiction');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1002, 'Fantasy Book', 'Best Fantasies', 9.99, 'fiction');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1003, 'Detective Book', 'Best Detective', 19.99, 'fiction');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1004, 'Romance Book', 'Best Romance', 5.99, 'fiction');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1005, 'Sci-Fi Book', 'Best Sci-Fi', 59.99, 'fiction');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1006, 'History Book', 'Best History', 79.99, 'nonFiction');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1007, 'Cooking Book', 'Best Cooking', 69.99, 'nonFiction');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1008, 'Science Book', 'Best Science', 99.99, 'nonFiction');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1009, 'Sport Book', 'Best Sport', 29.99, 'nonFiction');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1010, 'Classic LP', 'Best Classic', 45.99, 'lp');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1011, 'POP LP', 'Best POP', 45.99, 'lp');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1012, 'ROCK LP', 'Best ROCK', 41.99, 'lp');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1013, 'DANCE LP', 'Best DANCE', 42.99, 'lp');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1014, 'RnB LP', 'Best RnB', 46.99, 'lp');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1015, 'HIPHOP LP', 'Best HIPHOP', 47.99, 'lp');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1016, 'God of war', 'Santa Monica', 29.99, 'game');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1017, 'The Witcher 3', 'CD Project', 19.99, 'game');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1018, 'World of Warcraft', 'Blizzard', 35.99, 'game');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1019, 'The Legend of Zelda: Breath of the Wild', 'Nintendo', 29.99, 'game');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1020, 'Overwatch', 'Blizzard', 19.99, 'game');
INSERT INTO product (id, title, supplier_id, price, type) VALUES (1021, 'Mario Kart 8', 'Nintendo', 25.99, 'game');


INSERT INTO book (id, author, isbn, pages) VALUES (1001, 'Adeel Burke', '1233', 333);
INSERT INTO book (id, author, isbn, pages) VALUES (1002, 'Sam Jackson', '1244', 444);
INSERT INTO book (id, author, isbn, pages) VALUES (1003, 'Aadil Knight', '1235', 521);
INSERT INTO book (id, author, isbn, pages) VALUES (1004, 'Harlee Burnett', '1236', 221);
INSERT INTO book (id, author, isbn, pages) VALUES (1005, 'Drew Brock', '1225', 652);
INSERT INTO book (id, author, isbn, pages) VALUES (1006, 'Freddy Cohen', '1472', 789);
INSERT INTO book (id, author, isbn, pages) VALUES (1007, 'Micheal Felix', '1287', 120);
INSERT INTO book (id, author, isbn, pages) VALUES (1008, 'Cari Martins', '1278', 952);
INSERT INTO book (id, author, isbn, pages) VALUES (1009, 'Jim Warner', '1472', 450);


INSERT INTO fiction (id, genre, summary) VALUES (1001, 0 ,'Thriller Summary');
INSERT INTO fiction (id, genre, summary) VALUES (1002, 1, 'Fantasy Summary');
INSERT INTO fiction (id, genre, summary) VALUES (1003, 2, 'Detective Summary');
INSERT INTO fiction (id, genre, summary) VALUES (1004, 3, 'Romance Summary');
INSERT INTO fiction (id, genre, summary) VALUES (1005, 4, 'Sci-Fi Summary');

INSERT INTO non_fiction (id, genre) VALUES (1006, 0);
INSERT INTO non_fiction (id, genre) VALUES (1007, 1);
INSERT INTO non_fiction (id, genre) VALUES (1008, 2);
INSERT INTO non_fiction (id, genre) VALUES (1009, 3);

INSERT INTO lp (id, performer, genre) VALUES (1010, 'Mikey Gill', 0);
INSERT INTO lp (id, performer, genre) VALUES (1011, 'Leyton Rawlings', 1);
INSERT INTO lp (id, performer, genre) VALUES (1012, 'Kerry Gibbs', 2);
INSERT INTO lp (id, performer, genre) VALUES (1013, 'Zayaan Lutz', 3);
INSERT INTO lp (id, performer, genre) VALUES (1014, 'Harlow Hope', 4);
INSERT INTO lp (id, performer, genre) VALUES (1015, 'Ava Mathis', 5);


INSERT INTO game (id, editor, genre ,pegi_rating) VALUES (1016, 'Sony', 1, 18);
INSERT INTO game (id, editor, genre ,pegi_rating) VALUES (1017, 'Sony', 1, 18);
INSERT INTO game (id, editor, genre ,pegi_rating) VALUES (1018, 'Blizzard', 0, 13);
INSERT INTO game (id, editor, genre ,pegi_rating) VALUES (1019, 'Nintendo', 1, 13);
INSERT INTO game (id, editor, genre ,pegi_rating) VALUES (1020, 'Blizzard', 2, 13);
INSERT INTO game (id, editor, genre ,pegi_rating) VALUES (1021, 'Nintendo', 4, 7);
