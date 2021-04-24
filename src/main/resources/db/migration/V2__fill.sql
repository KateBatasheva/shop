insert into categories (title) values
('Fruits');

insert into product_table (title, category_id, price) values
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

insert into role_table(name) values
('ROLE_ADMIN'),
('ROLE_MANAGER'),
('ROLE_USER');

insert into user_table (username, password, email) values
('admin', '$2y$12$AaHpwWFl8GE/5sPtBVh5.uAvUvc8eWcirFjmUawYO3w1Wg3GMzF6W', 'admin@gmail.com' ),
('manager', '$2y$12$3Srk2v1qo5e7pssKngkWkukDC.ZQIpZujl6LHRSzyuMIu2BKu37Dm ', 'manager@gmail.com' ),
('user', '$2y$12$TWC84ttLkd1pMXpAXwR8M.OajlrmUCRmYBhTyiJ4O8yOj4Vj3x9qe', 'user@gmail.com' );


insert into users_roles (user_id, role_id) values
(1,1),
(2,2),
(2,3),
(3,3);