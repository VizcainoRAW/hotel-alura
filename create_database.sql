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
    price DECIMAL(10, 2) NOT NULL
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
    position VARCHAR(50) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);

-- Create the table for services
CREATE TABLE IF NOT EXISTS services (
    service_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cost DECIMAL(10, 2) NOT NULL
);

-- Create the junction table for the many-to-many relationship between services and reservations
CREATE TABLE IF NOT EXISTS reservation_services (
    reservation_id BIGINT,
    service_id BIGINT,
    PRIMARY KEY (reservation_id, service_id),
    FOREIGN KEY (reservation_id) REFERENCES reservations(reservation_id),
    FOREIGN KEY (service_id) REFERENCES services(service_id)
);

-- Create the table for invoices
CREATE TABLE IF NOT EXISTS invoices (
    invoice_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    reservation_id BIGINT,
    total DECIMAL(10, 2),
    issue_date DATE,    FOREIGN KEY (reservation_id) REFERENCES reservations(reservation_id)
);

-- Create the table for payments
CREATE TABLE IF NOT EXISTS payments (
    payment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    invoice_id BIGINT,
    amount DECIMAL(10, 2),
    payment_date DATE,
    FOREIGN KEY (invoice_id) REFERENCES invoices(invoice_id)
);

-- Insert sample data into tables (you can modify as needed)

-- Insert customers
INSERT INTO customers (first_name, last_name, email, phone_number)
VALUES
('John', 'Doe', 'john.doe@example.com', '123-456-7890'),
('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210');

-- Insert rooms
INSERT INTO rooms (room_number, type, price)
VALUES
(101, 'Single', 80.00),
(201, 'Double', 120.00),
(301, 'Suite', 200.00);

-- Insert reservations
INSERT INTO reservations (customer_id, room_id, start_date, end_date)
VALUES
(1, 1, '2024-01-10', '2024-01-15'),
(2, 2, '2024-02-05', '2024-02-10');

-- Insert employees
INSERT INTO employees (first_name, last_name, position, salary)
VALUES
('Alice', 'Johnson', 'Receptionist', 50000.00),
('Bob', 'Williams', 'Housekeeper', 40000.00);

-- Insert services
INSERT INTO services (name, cost)
VALUES
('Wi-Fi', 10.00),
('Breakfast', 15.00);