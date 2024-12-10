CREATE TABLE IF NOT EXISTS dishes (
	dish_id serial PRIMARY KEY,
	dish_name varchar(255) NOT NULL,
	dish_description varchar(255) NOT NULL,
	dish_weight float NOT NULL,
	dish_price float NOT NULL
);

CREATE TABLE IF NOT EXISTS events (
	event_id serial PRIMARY KEY,
	event_name varchar(255) NOT NULL,
	event_description varchar(255) NOT NULL,
	event_date date NOT NULL,
	event_time time NOT NULL,
	event_capacity integer NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
	order_id serial PRIMARY KEY,
	table_number varchar(8) NOT NULL,
	order_status varchar(20) NOT NULL,
	order_timestamp timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS order_items (
	item_id serial PRIMARY KEY,
	order_id serial REFERENCES orders(order_id),
	dish_id serial REFERENCES dishes(dish_id),
	item_quantity integer NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
	user_id serial PRIMARY KEY,
	username varchar(32) NOT NULL UNIQUE,
	user_password varchar(64) NOT NULL,
	user_enabled boolean NOT NULL,
	user_role varchar(32) NOT NULL
);