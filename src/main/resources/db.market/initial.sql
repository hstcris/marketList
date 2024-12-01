create database market;
use market;

CREATE TABLE purchase_list (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    month VARCHAR(255) NOT NULL,
    tenant_id VARCHAR(255) NOT NULL
);
CREATE TABLE purchase_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    purchase_list_id BIGINT NOT NULL,
    tenant_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (purchase_list_id) REFERENCES purchase_list(id)
);
CREATE TABLE price_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    purchase_list_id BIGINT NOT NULL,
    tenant_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (purchase_list_id) REFERENCES purchase_list(id)
);


