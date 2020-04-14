// Customers
DROP TABLE IF EXISTS Customers;
CREATE TABLE Customers (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255)
);
// Addresses
DROP TABLE IF EXISTS Addresses;
CREATE TABLE Addresses (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    customer_id INT CONSTRAINT address_customer_ref REFERENCES Customers(id)
);

