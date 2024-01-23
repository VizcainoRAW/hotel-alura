-- Create the hotel database
CREATE DATABASE IF NOT EXISTS hotel_database;
USE hotel_database;

-- Create the table for customers
CREATE TABLE IF NOT EXISTS customers (
    customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone_number VARCHAR(20)
);

-- Create the table for rooms
CREATE TABLE IF NOT EXISTS rooms (
    room_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_number BIGINT NOT NULL,
    type VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    occupied BOOLEAN NOT NULL DEFAULT FALSE
);

-- Create the table for reservations
CREATE TABLE IF NOT EXISTS reservations (
    reservation_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT,
    room_id BIGINT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);

-- Create the table for employees
CREATE TABLE IF NOT EXISTS employees (
    employee_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);

-- Create the table for services
CREATE TABLE IF NOT EXISTS services (
    service_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cost DECIMAL(10, 2) NOT NULL
);

-- Create the table to assign services to rooms
CREATE TABLE IF NOT EXISTS room_service (
    room_id BIGINT,
    service_id BIGINT,
    PRIMARY KEY (room_id, service_id),
    FOREIGN KEY (room_id) REFERENCES rooms(room_id),
    FOREIGN KEY (service_id) REFERENCES services(service_id)
);

-- Insert sample data for testing

-- Customers
INSERT INTO customers (first_name, last_name, email, phone_number)
VALUES
('John', 'Doe', 'john.doe@example.com', '123-456-7890'),
('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210');

-- Rooms
INSERT INTO rooms (room_number, type, price, occupied)
VALUES
(101, 'Single', 80.00, FALSE),
(201, 'Double', 120.00, FALSE),
(301, 'Suite', 200.00, FALSE);

-- Reservations
INSERT INTO reservations (customer_id, room_id, start_date, end_date)
VALUES
(1, 1, '2024-01-10', '2024-01-15'),
(2, 2, '2024-02-05', '2024-02-10');

-- Employees
INSERT INTO employees (first_name, last_name, salary)
VALUES
('Alice', 'Johnson', 50000.00),
('Bob', 'Williams', 60000.00);

-- Services
INSERT INTO services (name, cost)
VALUES
('Wi-Fi', 10.00),
('Breakfast', 15.00);

-- Room Service
INSERT INTO room_service (room_id, service_id)
VALUES
(1, 1),
(2, 2);