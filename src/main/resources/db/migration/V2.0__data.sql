-- product
insert into product ( title, rentable ) values ('Xbox Series X', true);
insert into product ( title, rentable ) values ('Xbox Series S', true);
insert into product ( title, rentable ) values ('Sony PS5', true);
insert into product ( title, rentable ) values ('Nintendo Switch Lite', true);
insert into product ( title, rentable ) values ('Oculus Quest 2', true);
insert into product ( title, rentable ) values ('Oculus Quest', false);
insert into product ( title, rentable ) values ('Oculus Rift S', true);
insert into product ( title, rentable ) values ('HTC Vive Cosmos', true);

--price
insert into price ( commitment_months, price_value ) values (null, 35);
insert into price ( commitment_months, price_value ) values (null, 25);
insert into price ( commitment_months, price_value ) values (null, 17);
insert into price ( commitment_months, price_value ) values (null, 30);
insert into price ( commitment_months, price_value ) values (null, 45);

insert into price ( commitment_months, price_value ) values (3, 30);
insert into price ( commitment_months, price_value ) values (3, 20);
insert into price ( commitment_months, price_value ) values (3, 13);
insert into price ( commitment_months, price_value ) values (3, 25);
insert into price ( commitment_months, price_value ) values (3, 40);

insert into price ( commitment_months, price_value ) values (6, 25);
insert into price ( commitment_months, price_value ) values (6, 17);
insert into price ( commitment_months, price_value ) values (6, 10);
insert into price ( commitment_months, price_value ) values (6, 20);
insert into price ( commitment_months, price_value ) values (6, 35);

-- product_price
insert into product_price (product_id, price_id ) values (select id from product where title = 'Xbox Series X', select id from price where commitment_months is null and price_value = 35);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Xbox Series X', select id from price where commitment_months = 3 and price_value = 30);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Xbox Series X', select id from price where commitment_months = 6 and price_value = 25);

insert into product_price (product_id, price_id ) values (select id from product where title = 'Xbox Series S', select id from price where commitment_months is null and price_value = 25);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Xbox Series S', select id from price where commitment_months = 3 and price_value = 20);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Xbox Series S', select id from price where commitment_months = 6 and price_value = 17);

insert into product_price (product_id, price_id ) values (select id from product where title = 'Sony PS5', select id from price where commitment_months is null and price_value = 35);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Sony PS5', select id from price where commitment_months = 3 and price_value = 30);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Sony PS5', select id from price where commitment_months = 6 and price_value = 25);

insert into product_price (product_id, price_id ) values (select id from product where title = 'Nintendo Switch Lite', select id from price where commitment_months is null and price_value = 17);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Nintendo Switch Lite', select id from price where commitment_months = 3 and price_value = 13);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Nintendo Switch Lite', select id from price where commitment_months = 6 and price_value = 10);

insert into product_price (product_id, price_id ) values (select id from product where title = 'Oculus Quest 2', select id from price where commitment_months is null and price_value = 35);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Oculus Quest 2', select id from price where commitment_months = 3 and price_value = 30);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Oculus Quest 2', select id from price where commitment_months = 6 and price_value = 25);

insert into product_price (product_id, price_id ) values (select id from product where title = 'Oculus Quest', select id from price where commitment_months is null and price_value = 30);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Oculus Quest', select id from price where commitment_months = 3 and price_value = 25);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Oculus Quest', select id from price where commitment_months = 6 and price_value = 20);

insert into product_price (product_id, price_id ) values (select id from product where title = 'Oculus Rift S', select id from price where commitment_months is null and price_value = 35);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Oculus Rift S', select id from price where commitment_months = 3 and price_value = 30);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Oculus Rift S', select id from price where commitment_months = 6 and price_value = 25);

insert into product_price (product_id, price_id ) values (select id from product where title = 'HTC Vive Cosmos', select id from price where commitment_months is null and price_value = 45);
insert into product_price (product_id, price_id ) values (select id from product where title = 'HTC Vive Cosmos', select id from price where commitment_months = 3 and price_value = 40);
insert into product_price (product_id, price_id ) values (select id from product where title = 'HTC Vive Cosmos', select id from price where commitment_months = 6 and price_value = 35);

insert into users (email, full_name, password, created_at, updated_at) values ('user@test.com', 'jonas jonaitis', '$2a$10$FP91k661x8ryrNx3UxHPUeja/bUC/qCfZo2laVvdsUC54.MVxs94W', now(), now());
insert into users (email, full_name, password, created_at, updated_at) values ('system@local.com', 'system', '$2a$10$xkdfwD0lObXSlsEbf8hDVuCN3byOtsbpI10muD7UfhKC0Q029mncS', now(), now());
