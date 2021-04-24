create table categories (
    id              bigserial primary key,
    title           varchar(255)
    );

create table product_table (
    id                      bigserial primary key,
    title                   varchar(255),
        category_id             int,
    price                   int,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp,
    foreign key (category_id) references categories (id)

    );
create table user_table
(
    id                      bigserial primary key,
    username                varchar(50) not null unique,
    password                varchar(500) not null,
    email                   varchar(150) unique,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp
);

create table order_table (
    id                      bigserial primary key,
    owner_id                bigint references user_table (id),
    price                   int,
    address                 varchar(255),
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp
);

create table order_items
(
    id             bigserial primary key,
    order_id                bigint references order_table (id),
    product_id              bigint references product_table (id),
    title          varchar(255),
    quantity       int,
    price          int,
    total_price    int,
        created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp
);


create table role_table
(
    id   serial      not null constraint role_table_pk primary key,
    name varchar(20) not null,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp
);

create table users_roles (
    user_id                 bigint not null references user_table (id),
    role_id                 bigint not null references role_table (id),
    primary key (user_id, role_id)
);

