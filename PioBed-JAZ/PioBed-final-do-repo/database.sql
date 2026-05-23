CREATE DATABASE IF NOT EXISTS piobed;
USE piobed;

CREATE TABLE IF NOT EXISTS movie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    production_year INT,
    is_available BOOLEAN NOT NULL DEFAULT false
);

INSERT INTO movie (name, category, production_year, is_available)
VALUES
('Incepcja', 'Sci-Fi', 2010, false),
('Gladiator', 'Dramat', 2000, true),
('Shrek', 'Animacja', 2001, false);

SELECT * FROM movie;
