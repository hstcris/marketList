create database market;
use market;

CREATE TABLE tenant (
    tenant_id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tb_purchase_list (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    month VARCHAR(255) NOT NULL,
    tenant_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (tenant_id) REFERENCES tenant(tenant_id)
);
CREATE TABLE tb_purchase_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    purchase_list_id BIGINT NOT NULL,
    tenant_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (purchase_list_id) REFERENCES tb_purchase_list(id),
        FOREIGN KEY (tenant_id) REFERENCES tenant(tenant_id)
);
CREATE TABLE tb_price_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    purchase_list_id BIGINT NOT NULL,
    tenant_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (purchase_list_id) REFERENCES tb_purchase_list(id),
        FOREIGN KEY (tenant_id) REFERENCES tenant(tenant_id)
);




