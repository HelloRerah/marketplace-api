CREATE TABLE users(
    -- BIGINT is a MySQL data type used to store large whole numbers --
    id BIGINT NOT NULL AUTO_INCREMENT, 
    full_name VARCHAR(120) NOT NULL,
    email VARCHAR(255) NOT NULL, 
    phone VARCHAR(20) NOT NULL, 
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    phone_verified BOOLEAN NOT NULL DEFAULT FALSE,
    age_confirmed BOOLEAN NOT NULL DEFAULT FALSE,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE', 
    city VARCHAR(100) NULL, 
    latitude DECIMAL(9,6) NULL, 
    longitude DECIMAL(9,6) NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id),
    CONSTRAINT uq_users_email UNIQUE (email),
    CONSTRAINT uq_users_phone UNIQUE (phone)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

