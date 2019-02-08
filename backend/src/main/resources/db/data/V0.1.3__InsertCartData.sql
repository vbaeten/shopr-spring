INSERT INTO cart (id, user_id, total_price) VALUES (1, 2000,59.97);

INSERT INTO cartItem (id, quantity, price, product_id, cart_id) VALUES (1, 3, 19.99, 1017, 1);

UPDATE user  SET cart_id = 1 WHERE id = 2000;