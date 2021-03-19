CREATE TABLE products (id bigserial primary key, category_id int, title varchar(255), price int);
INSERT INTO products (title, category_id, price) values
('Apple',1, 80),
('Pear',1, 70),
('Peach',1, 90),
('Orange',1, 70),
('Grapfruit',1, 190),
('Pomegranate',1, 280),
('Cherry',1, 190),
('Blueberry',1, 320),
('Raspberry',1, 250),
('Lemon',1, 90),
('Lime',1, 120),
('Mango',1, 110),
('Pomelo',1, 80),
('Strawberry',1, 190),
('Banan',1, 20),
('Apricot',1, 50),
('Grapes',1, 70),
('Kiwi',1, 100),
('Pineapple',1, 130),
('Watermelon',1, 30);

create table categories (id bigserial primary key, title varchar(255));
INSERT INTO categories (title) values
('Fruits');