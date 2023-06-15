CREATE TABLE product (
    id uuid PRIMARY KEY,
    name varchar(100) not null,
    price DECIMAL(10,2) not null
)