INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (4.5, 1275, 0.5, 'Lav', 'https://i.imgur.com/TtXcqhR.png', 65);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (4.9, 1702, 0.33, 'Lav Premium', 'https://i.imgur.com/T3gCAOE.png', 73);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (6, 502, 0.33, 'Grimbergen Blanche', 'https://i.imgur.com/qIq1OrC.png', 132);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (6.7, 435, 0.33, 'Grimbergen Blonde', 'https://i.imgur.com/OnioHd5.png', 132);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (2, 842, 0.33, 'Twist Limun', 'https://i.imgur.com/DNmvAvn.png', 84);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (5, 796, 0.5, 'Budweiser Budvar', 'https://i.imgur.com/AkT8Zz2.png', 91);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (4.5, 607, 0.33, 'Somersby Borovnica', 'https://i.imgur.com/H1nES8z.png', 87);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (4.5, 572, 0.33, 'Somersby Jabuka', 'https://i.imgur.com/ndWKw6v.png', 87);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (4.5, 381, 0.33, 'Somersby Kruška', 'https://i.imgur.com/7blHRZp.png', 87);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (5, 1322, 0.33, 'Kronenbourg', 'https://javar98.imgur.com/all', 96);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (5.3, 635, 0.5, 'Erdinger', 'https://i.imgur.com/jzpTYji.png', 82);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (5.3, 589, 0.5, 'Erdinger Dunkel', 'https://i.imgur.com/8O9SSqL.png', 82);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (5, 1635, 0.5, 'Carlsberg', 'https://i.imgur.com/KYc3uH3.png', 92);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (4.6, 1431, 0.5, 'Tuborg Green', 'https://i.imgur.com/E1btgw2.png', 76);
INSERT INTO carlsberg.product (alcohol, amount, mass, name, picture, price) VALUES (4.4, 636, 0.33, 'San Miguel', 'https://i.imgur.com/S9omKPE.png', 82);

INSERT INTO carlsberg.warehouse_order (created_on, user_id) VALUES (now(), 1);
INSERT INTO carlsberg.warehouse_order (created_on, user_id) VALUES (now(), 2);

INSERT INTO carlsberg.order_product (number_of_ordered_products, warehouse_order_id, product_id) VALUES (28, 1, 4);
INSERT INTO carlsberg.order_product (number_of_ordered_products, warehouse_order_id, product_id) VALUES (42, 1, 2);
INSERT INTO carlsberg.order_product (number_of_ordered_products, warehouse_order_id, product_id) VALUES (21, 2, 1);
INSERT INTO carlsberg.order_product (number_of_ordered_products, warehouse_order_id, product_id) VALUES (72, 2, 7);
