-- schema.sql
CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS referral (
    id INT AUTO_INCREMENT PRIMARY KEY,
    referrer_id INT NOT NULL,
    referred_id INT NOT NULL,
    level INT NOT NULL,
    FOREIGN KEY (referrer_id) REFERENCES user(id),
    FOREIGN KEY (referred_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS commission (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    level INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id)
);
