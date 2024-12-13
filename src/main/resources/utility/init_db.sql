DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE IF NOT EXISTS dishes (
	id serial PRIMARY KEY,
	name varchar(255) NOT NULL,
	description varchar(255) NOT NULL,
	weight float NOT NULL,
	price float NOT NULL
);

CREATE TABLE IF NOT EXISTS events (
	id serial PRIMARY KEY,
	name varchar(255) NOT NULL,
	description varchar(255) NOT NULL,
	event_time timestamp NOT NULL,
	capacity integer NOT NULL
);

CREATE TABLE IF NOT EXISTS order_statuses (
    id serial PRIMARY KEY,
    name varchar(32) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS orders (
	id serial PRIMARY KEY,
	number varchar(8) NOT NULL,
	status varchar(20) REFERENCES order_statuses(id),
	order_time timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS order_items (
	id serial PRIMARY KEY,
	order_id serial REFERENCES orders(id),
	dish_id serial REFERENCES dishes(id),
	quantity integer NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles (
    id serial PRIMARY KEY,
    name varchar(32) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users (
	id serial PRIMARY KEY,
	username varchar(32) NOT NULL UNIQUE,
	password varchar(64) NOT NULL,
	role serial REFERENCES user_roles(id)
);