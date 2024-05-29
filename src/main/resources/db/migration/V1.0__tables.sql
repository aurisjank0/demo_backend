create table if not exists product (
    id bigint auto_increment not null,
    title varchar not null,
    rentable bool not null
);

create table if not exists price (
     id bigint auto_increment not null,
     commitment_months int,
     price_value decimal not null
);

create table if not exists product_price (
    id bigint auto_increment not null,
    product_id bigint not null,
    price_id bigint not null
);

create table if not exists users (
     id bigint auto_increment not null,
     email varchar not null,
     full_name varchar not null,
     password varchar not null,
     created_at timestamp,
     updated_at timestamp
);
