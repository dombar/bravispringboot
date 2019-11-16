DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS person_phone;
DROP TABLE IF EXISTS person_whatsapp;
DROP TABLE IF EXISTS person_email;

CREATE TABLE person (
  person_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE person_phone (
  phone_id INT AUTO_INCREMENT  PRIMARY KEY,
  phone VARCHAR(50) DEFAULT NULL,
  person_id INT
);

CREATE TABLE person_whatsapp (
  whatsapp_id INT AUTO_INCREMENT  PRIMARY KEY,
  whatsapp VARCHAR(50) DEFAULT NULL,
  person_id INT
);

CREATE TABLE person_email (
  email_id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(50) DEFAULT NULL,
  person_id INT
);

INSERT INTO person (name) VALUES
  ('Afranio');

INSERT INTO person_email (email, person_id) VALUES
  ('baroninet@gmail.com',1);

INSERT INTO person_phone (phone, person_id) VALUES
    ('34999581898', 1);

INSERT INTO person_whatsapp (whatsapp, person_id) VALUES
    ('34999581898', 1);